import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class FenEmbarquement extends JFrame{
	private Ferry ferry;
	FenEmbarquement(Ferry ferry){
		this.ferry = ferry;
		this.setSize(600, 500);
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

    	JRadioButton rBtn2 = new JRadioButton("Camtion");

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

    	Dimension big_size = new Dimension(200, 20);
    	Dimension medium_size = new Dimension(50, 20);
    	Dimension little_size = new Dimension(25, 20);
    	Dimension label_size = new Dimension(350, 20);

    	mid.setLayout(flow);

    	JLabel immat = new JLabel("Entrez immatriculation du vehicule (20 char max)");
    	JTextField immatTF = new JTextField();
    	immatTF.setPreferredSize(big_size);
    	immat.setPreferredSize(label_size);
    	immat.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(immat);
    	mid.add(immatTF);

    	JLabel pass = new JLabel("Entrez le nombre de passagers");
    	JTextField passTF = new JTextField();
    	passTF.setPreferredSize(little_size);
    	pass.setPreferredSize(label_size);
    	pass.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(pass);
    	mid.add(passTF);

    	JLabel pds = new JLabel("Entrez le poids du vehicule (en tonnes)");
    	JTextField pdsTF = new JTextField();
    	pdsTF.setPreferredSize(medium_size);
    	pds.setPreferredSize(label_size);
    	pds.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(pds);
    	mid.add(pdsTF);

    	JLabel len = new JLabel("Entrez la longueur du vehicule (en metres)");
    	JTextField lenTF = new JTextField();
    	lenTF.setPreferredSize(medium_size);
    	len.setPreferredSize(label_size);
    	len.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(len);
    	mid.add(lenTF);

    	JLabel pdsc = new JLabel("Entrez le poids de la cargaison du camion (en tonnes)");
    	JTextField pdscTF = new JTextField();
    	pdscTF.setEnabled(false);
    	pdscTF.setPreferredSize(medium_size);
    	pdsc.setPreferredSize(label_size);
    	pdsc.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(pdsc);
    	mid.add(pdscTF);

    	JLabel nom = new JLabel("Entrez le nom du conducteur");
    	JTextField nomTF = new JTextField();
    	nomTF.setPreferredSize(big_size);
    	nom.setPreferredSize(label_size);
    	nom.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(nom);
    	mid.add(nomTF);

    	JLabel pnom = new JLabel("Entrez le prenom du conducteur");
    	JTextField pnomTF = new JTextField();
    	pnomTF.setPreferredSize(big_size);
    	pnom.setPreferredSize(label_size);
    	pnom.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(pnom);
    	mid.add(pnomTF);

    	JLabel num = new JLabel("Entrez le numero de permis de conduire");
    	JTextField numTF = new JTextField();
    	numTF.setPreferredSize(big_size);
    	num.setPreferredSize(label_size);
    	num.setHorizontalAlignment(SwingConstants.RIGHT);
    	mid.add(num);
    	mid.add(numTF);

    	

    	

    	this.add(mid, BorderLayout.CENTER);


    	bot.setLayout(new BorderLayout());
    	JButton valid = new JButton("Valider");
    	valid.setPreferredSize(new Dimension(100, 40));
    	bot.add(valid, BorderLayout.NORTH);

    	this.add(bot, BorderLayout.SOUTH);

    	rBtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pdscTF.setEnabled(false);
				passTF.setEnabled(true);
			}
		});

		rBtn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pdscTF.setEnabled(true);
				passTF.setEnabled(false);

			}
		});

		valid.addActionListener(e -> {
			int ret = 0;
			if(rBtn1.isSelected()){
				ret = ferry.embarquement(new Voiture(immatTF.getText(), Double.parseDouble(pdsTF.getText()), Double.parseDouble(lenTF.getText()), new Conducteur(nomTF.getText(), pnomTF.getText(), numTF.getText()), Integer.parseInt(passTF.getText())));
			}
			else{
				ret = ferry.embarquement(new Camion(immatTF.getText(), Double.parseDouble(pdsTF.getText()), Double.parseDouble(lenTF.getText()), new Conducteur(nomTF.getText(), pnomTF.getText(), numTF.getText()), Double.parseDouble(pdscTF.getText())));
			}

			if(ret == 1){
				Infobulle check = new Infobulle("Embarquement", "Embarquement reussi !");
				this.dispose();
			}
			else if(ret == -1){
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Limite de poids atteinte !");
			}
			else{
				Infobulle check = new Infobulle("Embarquement", "Embarquement impossible : Limite de taille atteinte !");
			}					
     	});

		this.setVisible(true);
	}
}