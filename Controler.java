import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Ce controleur va nous permettre de controler les différentes interactions entre l'utilisateur et la vue
 * sur TOUTES les fenêtres existantes dans notre projet, il prend donc en compte la fenetre principale, la fenetre
 * représentant la cale, la fenetre d'embarquement ainsi que toutes les infobulles créées...
 */ 
public class Controler implements ActionListener, ListSelectionListener{
	private Fenetre f;
	private FenCale fCale;
	private FenEmbarquement emb;

	Controler(Fenetre fen){
		this.f = fen;
	}

	/**
	 * On va controler les clics sur les deux boutons de la fenetre principale, le bouton "valider" dans la fenetre d'embarquement
	 * ainsi que le clic sur le menuitem pour afficher la cale et les vehicules qu'elle contient...
	 * le clic sur le bouton "OK" de l'infobulle "check" est lui aussi controlé
	 */
	public void actionPerformed(ActionEvent ev){
		JButton embarq = f.getButtonEmbarq();
		JButton debarq = f.getButtonDebarq();
		JMenuItem item = f.getItem();

		if(ev.getSource() == embarq){
			emb = new FenEmbarquement(f.getFerry());
			JRadioButton btn1 = emb.getRbtn1();
			JRadioButton btn2 = emb.getRbtn2();

			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					emb.getPdsc().setText("");
					emb.getPdsc().setEnabled(false);
					emb.getPass().setEnabled(true);
				}
			});

			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					emb.getPass().setText("");
					emb.getPdsc().setEnabled(true);
					emb.getPass().setEnabled(false);
				}
			});
			//on definit l'ecouteur du bouton valider dans le controleur de la fenetre principale
			emb.getButtonValid().addActionListener(ev1 -> {
				int ret = 0;
				Infobulle check;

				//on verifie chaque donnée entrée dans le formulaire et on affiche une infobulle d'erreur si des champs son
				//absents ou incorrects

				//on commence par les verifications propres a la voiture et au camion

				//nombre de passagers : un entier
				if(emb.getRbtn1().isSelected() && emb.getPass().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//poids de la cargaison : un double
				else if(emb.getRbtn2().isSelected() && emb.getPdsc().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}

				//on verifie ensuite les données communes a tout type de véhicule

				//immatriculation : une chaine de caractere non vide et de taille inferieure a 20 caracteres
				else if(emb.getImmat().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//poids à vide du vehicule : un double non nul
				else if(emb.getPds().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//longueur du vehicule : un double non nul
				else if(emb.getLen().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//nom du conducteur : une chaine de caracteres non vide
				else if(emb.getNom().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//prenom du conducteur : une chaine de caracteres non vide
				else if(emb.getPnom().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//numero du permis de conduire du conducteur : une chaine de caracteres non vide
				else if(emb.getNum().getData().isEmpty()){
					check = new Infobulle("Embarquement", "Embarquement impossible : Champs Manquants ou incorrects !", 500, 130);
				}
				//si on arrive ici, on a aucune erreur donc on procede a l'embarquement du vehicule
				else{
					if(emb.getRbtn1().isSelected()){
						Vehicle vEmb = new Voiture(emb.getImmat().getData(), Double.parseDouble(emb.getPds().getData()), Double.parseDouble(emb.getLen().getData()), new Conducteur(emb.getNom().getData(), emb.getPnom().getData(), emb.getNum().getData()), Integer.parseInt(emb.getPass().getData()));
						ret = f.getFerry().embarquement(vEmb);
					}
					else{
						Vehicle vEmb = new Camion(emb.getImmat().getData(), Double.parseDouble(emb.getPds().getData()), Double.parseDouble(emb.getLen().getData()), new Conducteur(emb.getNom().getData(), emb.getPnom().getData(), emb.getNum().getData()), Double.parseDouble(emb.getPdsc().getData()));
						ret = f.getFerry().embarquement(vEmb);
					}

					//on affiche l'infobulle correspondante au resultat de l'embarquement
					if(ret == 1){
						check = new Infobulle("Embarquement", "Embarquement reussi !", 350, 130);
						emb.dispose();
					}
					else if(ret == -1){
						check = new Infobulle("Embarquement", "Embarquement impossible : Limite de poids atteinte !", 450, 130);
					}
					else{
						check = new Infobulle("Embarquement", "Embarquement impossible : Limite de taille atteinte !", 450, 130);
					}		
				}
				check.getButtonOk().addActionListener(ev2 -> {
         			check.dispose();
     			});
			});
			
		}
		else if(ev.getSource() == debarq){
			Vehicle deb = f.getFerry().debarquement();
			Infobulle check;

			if(deb == null){
				check = new Infobulle("Debarquement", "La cale est vide !", 350, 130);
			}
			else{
				check = new Infobulle("Debarquement", "Debarquement : "+deb.getImmatriculation(), 350, 130);
			}
			check.getButtonOk().addActionListener(ev1 -> {
         		check.dispose();
     		});
		}
		else if(ev.getSource() == item){
			fCale = new FenCale(f.getFerry());	
			//on définit le controle des clics sur les lignes des deux rangées sur cette meme classe(voir ci-dessous)
			fCale.getList('D').addListSelectionListener(this);
			fCale.getList('G').addListSelectionListener(this);

		}
	}

	/**
	 * Ici, on va controler les clics sur les différentes lignes (représentant des vehicules) contenues dans les JList des deux
	 * rangées du ferry, on veillera a automatiquement déselectionner la ligne une fois selectionnée et l'infobulle affichée pour
	 * que l'utilisateur puisse recliquer sur la même ligne s'il le souhaite, enfin, on controle le clic sur le bouton "OK" des différentes
	 * infobulles créées
	 */
	public void valueChanged(ListSelectionEvent arg0) {
		JList<Vehicle> listDroite = fCale.getList('D');
		JList<Vehicle> listGauche = fCale.getList('G');
		

		if(arg0.getSource() == listDroite){
			if(arg0.getValueIsAdjusting()){
	        	Ticket t = fCale.search(listDroite.getSelectedValue().getConducteur().getNom());

	        	Infobulle check = new Infobulle("TICKET", "D"+t, 400, 130);
	        	check.getButtonOk().addActionListener(ev1 -> {
         			check.dispose();
     			});
	        }
	        else{
	        	listDroite.clearSelection();
	        }
		}
		else if(arg0.getSource() == listGauche){
			if(arg0.getValueIsAdjusting()){
	        	Ticket t = fCale.search(listGauche.getSelectedValue().getConducteur().getNom());

	        	Infobulle check = new Infobulle("TICKET", "G"+t, 400, 130);
	        	check.getButtonOk().addActionListener(ev1 -> {
         			check.dispose();
     			});
	        }
	        else{
	        	listGauche.clearSelection();
	        }
		}
	}
}