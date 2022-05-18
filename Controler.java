import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controler implements ActionListener{
	private Fenetre f;

	Controler(Fenetre fen){
		this.f = fen;
	}

	public void actionPerformed(ActionEvent ev){
		JButton embarq = f.getButtonEmbarq();
		JButton debarq = f.getButtonDebarq();

		if(ev.getSource() == embarq){
			FenEmbarquement emb = new FenEmbarquement(f.getFerry());
			
		}
		else if(ev.getSource() == debarq){
			Vehicle deb = f.getFerry().debarquement();

			if(deb == null){
				Infobulle caleVide = new Infobulle("Debarquement", "La cale est vide !", 350, 130);
			}
			else{
				Infobulle debarquement = new Infobulle("Debarquement", "Debarquement : "+deb.getImmatriculation(), 350, 130);
			}
		}
	}
}