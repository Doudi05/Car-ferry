import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class FenEmbarquement extends JFrame{
	private Ferry ferry;
	private Vehicle emb = null;

	FenEmbarquement(Ferry ferry){
		this.ferry = ferry;
		this.setSize(600, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("CAR FERRY - Embarquement");
		this.setLayout(new BorderLayout());

		Color colPan = new Color(174,248,142);
		Color colForm = new Color(202,253,184);

		JPanel top = new JPanel();
		top.setBackground(colPan);
		JPanel mid = new JPanel();
		mid.setBackground(colForm);
		JPanel bot = new JPanel();
		top.setBackground(colPan);

		JLabel typeV = new JLabel("Quel est le type de vehicule ?");

		JRadioButton rBtn1 = new JRadioButton("Voiture");
		rBtn1.setSelected(true);

    	JRadioButton rBtn2 = new JRadioButton("Camion");

    	ButtonGroup bg = new ButtonGroup(); 
    	bg.add(rBtn1);
    	bg.add(rBtn2); 

    	FlowLayout flow = new FlowLayout();
    	flow.setAlignment(FlowLayout.RIGHT);
    	top.setLayout(flow);

    	top.add(typeV);
    	top.add(rBtn1);
    	top.add(rBtn2);

    	this.add(top, BorderLayout.NORTH);

    	//dimensions des differents JTexields
    	Dimension big_size = new Dimension(200, 20);
    	Dimension medium_size = new Dimension(50, 20);
    	Dimension little_size = new Dimension(25, 20);

    	mid.setLayout(new GridLayout(8, 1));
    	

    	ChampForm immat = new ChampForm("Entrez immatriculation du vehicule (20 char max)", big_size, flow, colForm);
    	ChampForm pass = new ChampForm("Entrez le nombre de passagers", little_size, flow, colForm);
    	ChampForm pds = new ChampForm("Entrez le poids du vehicule (en tonnes)", medium_size, flow, colForm);
    	ChampForm len = new ChampForm("Entrez la longueur du vehicule (en metres)", medium_size, flow, colForm);
    	ChampForm pdsc = new ChampForm("Entrez le poids de la cargaison du camion (en tonnes)", medium_size, flow, colForm);
    	pdsc.setEnabled(false);
    	ChampForm nom = new ChampForm("Entrez le nom du conducteur", big_size, flow, colForm);
    	ChampForm pnom = new ChampForm("Entrez le prenom du conducteur", big_size, flow, colForm);
    	ChampForm num = new ChampForm("Entrez le numero de permis de conduire", big_size, flow, colForm);

    
    	mid.add(immat);
    	mid.add(pass);
    	mid.add(pds);
    	mid.add(len);
    	mid.add(pdsc);
    	mid.add(nom);
    	mid.add(pnom);
    	mid.add(num);
    	this.add(mid, BorderLayout.CENTER);


    	bot.setLayout(new BorderLayout());
    	JButton valid = new JButton("Valider");
    	valid.setPreferredSize(new Dimension(100, 40));
    	bot.add(valid, BorderLayout.NORTH);

    	this.add(bot, BorderLayout.SOUTH);

    	//Actions a effectuer lorque l'on coche le bouton "voiture"
    	rBtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pdsc.setText("");
				pdsc.setEnabled(false);
				pass.setEnabled(true);
			}
		});

    	//Actions a effectuer lorque l'on coche le bouton "camion"
		rBtn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pass.setText("");
				pdsc.setEnabled(true);
				pass.setEnabled(false);

			}
		});

		valid.addActionListener(e -> {
			int ret = 0;

			//on verifie chaque donnée entrée dans le formulaire et on affiche une infobulle d'erreur si des champs son
			//absents ou incorrects

			//on commence par les verifications propres a la voiture et au camion

			//nombre de passagers : un entier
			if(rBtn1.isSelected() && pass.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//poids de la cargaison : un double
			else if(rBtn2.isSelected() && pdsc.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}

			//on verifie ensuite les données communes a tout type de véhicule

			//immatriculation : une chaine de caractere non vide et de taille inferieure a 20 caracteres
			if(immat.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//poids à vide du vehicule : un double non nul
			else if(pds.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//longueur du vehicule : un double non nul
			else if(len.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//nom du conducteur : une chaine de caracteres non vide
			else if(nom.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//prenom du conducteur : une chaine de caracteres non vide
			else if(pnom.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//numero du permis de conduire du conducteur : une chaine de caracteres non vide
			else if(num.getData().isEmpty()){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//si on arrive ici, on a aucune erreur donc on procede a l'embarquement du vehicule
			else{
				if(rBtn1.isSelected()){
					emb = new Voiture(immat.getData(), Double.parseDouble(pds.getData()), Double.parseDouble(len.getData()), new Conducteur(nom.getData(), pnom.getData(), num.getData()), Integer.parseInt(pass.getData()))
					ret = ferry.embarquement(emb);
				}
				else{
					emb = new Camion(immat.getData(), Double.parseDouble(pds.getData()), Double.parseDouble(len.getData()), new Conducteur(nom.getData(), pnom.getData(), num.getData()), Double.parseDouble(pdsc.getData()))
					ret = ferry.embarquement(emb);
				}

				//on affiche l'infobulle correspondante au resultat de l'embarquement
				if(ret == 1){
					Infobulle check = new Infobulle("Embarquement", "Embarquement reussi !", 350, 130);
					this.dispose();
				}
				else if(ret == -1){
					Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Limite de poids atteinte !", 450, 130);
				}
				else{
					Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Limite de taille atteinte !", 450, 130);
				}		
			}			
     	});

		this.setVisible(true);
	}
}