import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class FenCale extends JFrame{
	private Ferry ferry;
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

		JList<Vehicle> listGauche = new JList<Vehicle>(vG);
		listGauche.setPreferredSize(new Dimension(250, 150));
		listGauche.setBackground(colList);
		listGauche.setBorder(BorderFactory.createLineBorder(Color.black));

		listGauche.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getValueIsAdjusting()){
	        		Ticket t = search(listGauche.getSelectedValue().getConducteur().getNom());

	        		Infobulle ticket = new Infobulle("TICKET", "G"+t, 400, 130);

	        	}
	        	else{
	        		listGauche.clearSelection();
	        	}


            }
		});

		JList<Vehicle> listDroite = new JList<Vehicle>(vD);
		listDroite.setPreferredSize(new Dimension(250, 150));
		listDroite.setBackground(colList);
		listDroite.setBorder(BorderFactory.createLineBorder(Color.black));

		listDroite.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getValueIsAdjusting()){
	        		Ticket t = search(listDroite.getSelectedValue().getConducteur().getNom());

	        		Infobulle ticket = new Infobulle("TICKET", "D"+t, 400, 130);
	        	}
	        	else{
	        		listDroite.clearSelection();
	        	}
            }
		});

		left.add(listGauche);
		right.add(listDroite);

		this.add(left);
		this.add(right);

		this.setVisible(true);
	}

	public Ticket search(String nom){
		for(Ticket t : ferry.getTickets()){
			if (t.getNom().equals(nom)){
				return t;
			}
		}

		return null;
	}
}