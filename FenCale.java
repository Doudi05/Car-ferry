/**
 * @author Roux-Akel
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class FenCale extends JFrame{
	private Ferry ferry;
	private JList<Vehicle> listGauche, listDroite;

	/**
	 * représente la fenetre contenant les deux rangées de la cale ainsi que les
	 * véhicules qu'elles contiennent
	 */ 
	FenCale(Ferry ferry){
		this.ferry = ferry;
		this.setSize(600, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Cale du ferry");

		this.setLayout(new GridLayout(1, 2));

		//couleurs de l'application
		Color colPan = new Color(174,248,142);
		Color colList = new Color(215, 248, 210);

		JPanel left = new JPanel();
		left.setBackground(colPan);
		left.setBorder(BorderFactory.createTitledBorder("Rangee Gauche"));

		JPanel right = new JPanel();
		right.setBackground(colPan);
		right.setBorder(BorderFactory.createTitledBorder("Rangee Droite"));

		Vehicle vG[] = new Vehicle[ferry.getRangee('G').getRangee().size()];
		Vehicle vD[] = new Vehicle[ferry.getRangee('D').getRangee().size()];

		int i = 0;

		for(Vehicle v : ferry.getRangee('G').getRangee()){
			vG[i] = v;
			++i;
		}

		i = 0;

		for(Vehicle v : ferry.getRangee('D').getRangee()){
			vD[i] = v;
			++i;
		}

		listGauche = new JList<Vehicle>(vG);
		listGauche.setPreferredSize(new Dimension(250, 150));
		listGauche.setBackground(colList);
		listGauche.setBorder(BorderFactory.createLineBorder(Color.black));

		listDroite = new JList<Vehicle>(vD);
		listDroite.setPreferredSize(new Dimension(250, 150));
		listDroite.setBackground(colList);
		listDroite.setBorder(BorderFactory.createLineBorder(Color.black));

		left.add(listGauche);
		right.add(listDroite);

		this.add(left);
		this.add(right);

		this.setVisible(true);
	}

	/**
	 * recherche un ticket avec un nom donné de conducteur et le renvoie
	 */ 
	public Ticket search(String nom){
		for(Ticket t : ferry.getTickets()){
			if (t.getNom().equals(nom)){
				return t;
			}
		}

		return null;
	}


	/**
	 * retourne un liste de véhicules contenue dans une des deux rangées 
	 */
	public JList<Vehicle> getList(char c){
		if(c == 'G'){
			return this.listGauche;
		}
		else if(c == 'D'){
			return this.listDroite;
		}
		else{
			return null;
		}
	}
}