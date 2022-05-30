/**
 * @author Roux-Akel
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Infobulle extends JFrame{
	private JButton ok;

	/**
	 * représente une infobulle contenant des informations suite à une
	 * action
	 */ 
	Infobulle(String title, String message, int width, int height){
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(title);

		JPanel panLabel = new JPanel();
		JPanel panButton = new JPanel();

		this.setLayout(new GridLayout(2, 1));

		JLabel label = new JLabel(message);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		ok = new JButton("OK");

		panLabel.add(label);
		panButton.add(ok);

		

		this.add(panLabel);
		this.add(panButton);
		this.setVisible(true);
	}

	/**
	 * retourne le bouton "ok" qui va fermer la fenetre, utilisé dans le controleur
	 */ 
	public JButton getButtonOk(){
		return this.ok;
	}
}