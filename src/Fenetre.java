/**
 * @author Roux-Akel
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame{
	private Ferry ferry;
	private JMenuItem i1;
	private JButton embarq, debarq;

	/**
	 * représente la fenêtre principale du ferry, on a besoin du ferry en lui meme
	 * pour utiliser ses informations
	 */ 
	Fenetre(Ferry ferry){
		this.ferry = ferry;
		this.setSize(500, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("CAR FERRY");

		//controleur des boutons
		Controler control = new Controler(this);

		//couleurs de l'application
		Color colMenu = new Color(174,248,142);
		Color colPan = new Color(202,253,184);
		Color colButton = new Color(116,193,184);

		//creation des panneaux requis
		JPanel bot = new JPanel();
		bot.setBackground(colPan);
		JPanel top = new JPanel();
		top.setBackground(colPan);

		//creation de la barre de menu
		JMenuBar mb = new JMenuBar();  
		JMenu menu = new JMenu("Cale du ferry");
		i1 = new JMenuItem("Afficher la cale");  
		i1.addActionListener(control);
		menu.add(i1);
		mb.add(menu);  
		mb.setBackground(colMenu);
        this.setJMenuBar(mb);  

        this.setLayout(new BorderLayout());


        //elements de la page principale
        JLabel label = new JLabel("Nouvelle croisiere");
        label.setHorizontalAlignment(SwingConstants.CENTER);

 		embarq = new JButton("Embarquer");
 		debarq = new JButton("Debarquer");
 		embarq.setBackground(colButton);
 		debarq.setBackground(colButton);

 		embarq.addActionListener(control);
 		debarq.addActionListener(control);

        top.add(label);

        ((FlowLayout)bot.getLayout()).setHgap(30);
        bot.add(embarq);
        bot.add(debarq);

        this.add(top, BorderLayout.NORTH);
        this.add(bot, BorderLayout.CENTER);




		this.setVisible(true);
	}

	/**
	 * retourne le ferry utilisé dans l'application
	 */ 
	public Ferry getFerry(){
		return this.ferry;
	}

	/**
	 * retourne le menu item i1, utilisé dans le controleur
	 */  
	public JMenuItem getItem(){
		return this.i1;
	}

	/**
	 * retourne le bouton d'embarquement, utilisé dans le controleur
	 */ 
	public JButton getButtonEmbarq(){
		return this.embarq;
	}

	/**
	 * retourne le bouton de débarquement, utilisé dans le controleur
	 */ 
	public JButton getButtonDebarq(){
		return this.debarq;
	}
}