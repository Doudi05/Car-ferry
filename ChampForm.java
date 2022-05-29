/**
 * @author Roux-Akel
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ChampForm extends JPanel{
	private JLabel label;
	private JTextField field;

	/**
	 * représente un champ de formulaire avec un intitulé, et un champ de saisie textuelle 
	 * on doit preciser un flowlayout en particulier, la taille du champ ainsi que la couleur de fond
	 */
	ChampForm(String text, Dimension field_size, FlowLayout layout, Color background){
		label = new JLabel(text);
    	field = new JTextField("");
    	field.setPreferredSize(field_size);
    	this.setLayout(layout);
    	this.setBackground(background);
    	label.setHorizontalAlignment(SwingConstants.RIGHT);
    	this.add(label);
    	this.add(field);

	}

	/**
	 * cette fonction permet d'activer/desactiver le champ de saisie
	 */ 
	public void setEnabled(boolean enabled){
		this.field.setEnabled(enabled);
	}

	/**
	 * renvoie la valeur contenue dans un champ de saisie
	 */
	public String getData(){
		return this.field.getText();
	}

	/**
	 * modifie le texte présent dans le champ de saisie (notamment utile pour vider un champ non utilisable)
	 */
	public void setText(String str){
		this.field.setText(str);
	}
}