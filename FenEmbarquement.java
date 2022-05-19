import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class FenEmbarquement extends JFrame{
	private Ferry ferry;
	private Vehicle emb = null;
	private JButton valid;
	private JRadioButton rBtn1, rBtn2;
	private ChampForm immat, pass, pds, len, pdsc, nom, pnom, num;

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

		rBtn1 = new JRadioButton("Voiture");
		rBtn1.setSelected(true);

    	rBtn2 = new JRadioButton("Camion");

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
    	

    	immat = new ChampForm("Entrez immatriculation du vehicule (20 char max)", big_size, flow, colForm);
    	pass = new ChampForm("Entrez le nombre de passagers", little_size, flow, colForm);
    	pds = new ChampForm("Entrez le poids du vehicule (en tonnes)", medium_size, flow, colForm);
    	len = new ChampForm("Entrez la longueur du vehicule (en metres)", medium_size, flow, colForm);
    	pdsc = new ChampForm("Entrez le poids de la cargaison du camion (en tonnes)", medium_size, flow, colForm);
    	pdsc.setEnabled(false);
    	nom = new ChampForm("Entrez le nom du conducteur", big_size, flow, colForm);
    	pnom = new ChampForm("Entrez le prenom du conducteur", big_size, flow, colForm);
    	num = new ChampForm("Entrez le numero de permis de conduire", big_size, flow, colForm);

    
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
    	valid = new JButton("Valider");
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

		this.setVisible(true);
	}

	public JRadioButton getRbtn1(){
		return this.rBtn1;
	}

	public JRadioButton getRbtn2(){
		return this.rBtn2;
	}

	public ChampForm getImmat(){
		return this.immat;
	}

	public ChampForm getPass(){
		return this.pass;
	}

	public ChampForm getPds(){
		return this.pds;
	}

	public ChampForm getLen(){
		return this.len;
	}

	public ChampForm getPdsc(){
		return this.pdsc;
	}

	public ChampForm getNom(){
		return this.nom;
	}

	public ChampForm getPnom(){
		return this.pnom;
	}

	public ChampForm getNum(){
		return this.num;
	}

	public JButton getButtonValid(){
		return this.valid;
	}
}