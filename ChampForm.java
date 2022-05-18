import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ChampForm extends JPanel{
	private JLabel label;
	private JTextField field;

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

	public void setEnabled(boolean enabled){
		this.field.setEnabled(enabled);
	}

	public String getData(){
		return this.field.getText();
	}

	public void setText(String str){
		this.field.setText(str);
	}
}