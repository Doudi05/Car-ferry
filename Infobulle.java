import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Infobulle extends JFrame{
	Infobulle(String title, String message){
		this.setSize(400, 130);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(title);

		JPanel panLabel = new JPanel();
		JPanel panButton = new JPanel();

		this.setLayout(new GridLayout(2, 1));

		JLabel label = new JLabel(message);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JButton ok = new JButton("OK");

		panLabel.add(label);
		panButton.add(ok);

		ok.addActionListener(e -> {
         	this.dispose();
     	});

		this.add(panLabel);
		this.add(panButton);
		this.setVisible(true);
	}
}