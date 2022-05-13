import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class FenEmbarquement extends JFrame{
	private Ferry ferry;

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

    	//dimensions des differents JTextFields
    	Dimension big_size = new Dimension(200, 20);
    	Dimension medium_size = new Dimension(50, 20);
    	Dimension little_size = new Dimension(25, 20);

    	mid.setLayout(new GridLayout(8, 1));

    	//on créée un panel pour chaque ligne du formulaire, c'est la seule maniere que l'on a trouvé
    	//pour une disposition correcte des elements
    	JPanel p1 = new JPanel();
    	JPanel p2 = new JPanel();
    	JPanel p3 = new JPanel();
    	JPanel p4 = new JPanel();
    	JPanel p5 = new JPanel();
    	JPanel p6 = new JPanel();
    	JPanel p7 = new JPanel();
    	JPanel p8 = new JPanel();
    	p1.setLayout(flow);
    	p1.setBackground(colForm);
    	p2.setLayout(flow);
    	p2.setBackground(colForm);
    	p3.setLayout(flow);
    	p3.setBackground(colForm);
    	p4.setLayout(flow);
    	p4.setBackground(colForm);
    	p5.setLayout(flow);
    	p5.setBackground(colForm);
    	p6.setLayout(flow);
    	p6.setBackground(colForm);
    	p7.setLayout(flow);
    	p7.setBackground(colForm);
    	p8.setLayout(flow);
    	p8.setBackground(colForm);

    	JLabel immat = new JLabel("Entrez immatriculation du vehicule (20 char max)");
    	JTextField immatTF = new JTextField("");
    	immatTF.setPreferredSize(big_size);
    	//immat.setPreferredSize(label_size);
    	immat.setHorizontalAlignment(SwingConstants.RIGHT);
    	p1.add(immat);
    	p1.add(immatTF);

    	JLabel pass = new JLabel("Entrez le nombre de passagers");
    	JTextField passTF = new JTextField("");
    	passTF.setPreferredSize(little_size);
    	pass.setHorizontalAlignment(SwingConstants.RIGHT);
    	p2.add(pass);
    	p2.add(passTF);

    	JLabel pds = new JLabel("Entrez le poids du vehicule (en tonnes)");
    	JTextField pdsTF = new JTextField("");
    	pdsTF.setPreferredSize(medium_size);
    	pds.setHorizontalAlignment(SwingConstants.RIGHT);
    	p3.add(pds);
    	p3.add(pdsTF);

    	JLabel len = new JLabel("Entrez la longueur du vehicule (en metres)");
    	JTextField lenTF = new JTextField("");
    	lenTF.setPreferredSize(medium_size);
    	len.setHorizontalAlignment(SwingConstants.RIGHT);
    	p4.add(len);
    	p4.add(lenTF);

    	JLabel pdsc = new JLabel("Entrez le poids de la cargaison du camion (en tonnes)");
    	JTextField pdscTF = new JTextField("");
    	pdscTF.setEnabled(false);
    	pdscTF.setPreferredSize(medium_size);
    	pdsc.setHorizontalAlignment(SwingConstants.RIGHT);
    	p5.add(pdsc);
    	p5.add(pdscTF);

    	JLabel nom = new JLabel("Entrez le nom du conducteur");
    	JTextField nomTF = new JTextField("");
    	nomTF.setPreferredSize(big_size);
    	nom.setHorizontalAlignment(SwingConstants.RIGHT);
    	p6.add(nom);
    	p6.add(nomTF);

    	JLabel pnom = new JLabel("Entrez le prenom du conducteur");
    	JTextField pnomTF = new JTextField("");
    	pnomTF.setPreferredSize(big_size);
    	pnom.setHorizontalAlignment(SwingConstants.RIGHT);
    	p7.add(pnom);
    	p7.add(pnomTF);

    	JLabel num = new JLabel("Entrez le numero de permis de conduire");
    	JTextField numTF = new JTextField("");
    	numTF.setPreferredSize(big_size);
    	num.setHorizontalAlignment(SwingConstants.RIGHT);
    	p8.add(num);
    	p8.add(numTF);

    
    	mid.add(p1);
    	mid.add(p2);
    	mid.add(p3);
    	mid.add(p4);
    	mid.add(p5);
    	mid.add(p6);
    	mid.add(p7);
    	mid.add(p8);
    	this.add(mid, BorderLayout.CENTER);


    	bot.setLayout(new BorderLayout());
    	JButton valid = new JButton("Valider");
    	valid.setPreferredSize(new Dimension(100, 40));
    	bot.add(valid, BorderLayout.NORTH);

    	this.add(bot, BorderLayout.SOUTH);

    	//Actions a effectuer lorque l'on coche le bouton "voiture"
    	rBtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pdscTF.setText("");
				pdscTF.setEnabled(false);
				passTF.setEnabled(true);
			}
		});

    	//Actions a effectuer lorque l'on coche le bouton "camion"
		rBtn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				passTF.setText("");
				pdscTF.setEnabled(true);
				passTF.setEnabled(false);

			}
		});

		valid.addActionListener(e -> {
			int ret = 0;

			//on verifie chaque donnée entrée dans le formulaire et on affiche une infobulle d'erreur si des champs son
			//absents ou incorrects

			//on commence par les verifications propres a la voiture et au camion

			//nombre de passagers : un entier
			if(rBtn1.isSelected() && passTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//poids de la cargaison : un double
			else if(rBtn2.isSelected() && pdscTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}

			//on verifie ensuite les données communes a tout type de véhicule

			//immatriculation : une chaine de caractere non vide et de taille inferieure a 20 caracteres
			if(immatTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//poids à vide du vehicule : un double non nul
			else if(pdsTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//longueur du vehicule : un double non nul
			else if(lenTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//nom du conducteur : une chaine de caracteres non vide
			else if(nomTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//prenom du conducteur : une chaine de caracteres non vide
			else if(pnomTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//numero du permis de conduire du conducteur : une chaine de caracteres non vide
			else if(numTF.getText().equals("")){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
			}
			//si on arrive ici, on a aucune erreur donc on procede a l'embarquement du vehicule
			else{
				if(rBtn1.isSelected()){
					ret = ferry.embarquement(new Voiture(immatTF.getText(), Double.parseDouble(pdsTF.getText()), Double.parseDouble(lenTF.getText()), new Conducteur(nomTF.getText(), pnomTF.getText(), numTF.getText()), Integer.parseInt(passTF.getText())));
				}
				else{
					ret = ferry.embarquement(new Camion(immatTF.getText(), Double.parseDouble(pdsTF.getText()), Double.parseDouble(lenTF.getText()), new Conducteur(nomTF.getText(), pnomTF.getText(), numTF.getText()), Double.parseDouble(pdscTF.getText())));
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