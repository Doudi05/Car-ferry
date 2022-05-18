import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame{
	private Ferry ferry;
	JButton embarq, debarq;

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
		JMenuItem i1 = new JMenuItem("Afficher la cale");  
		menu.add(i1);

		i1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FenCale cale = new FenCale(ferry);
			}
		});
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

	public Ferry getFerry(){
		return this.ferry;
	}

	public JButton getButtonEmbarq(){
		return this.embarq;
	}

	public JButton getButtonDebarq(){
		return this.debarq;
	}
}