import java.util.*;

/**
 * @author Roux-Akel
 */
public class Ferry{
	
	private Rangee raD;
	private Rangee raG;

	private TreeSet<Ticket> listing;

	private double taille;
	private double chargeMax;
	private int nbPassagers;

	/**
	 * constructeur parametré d'un Ferry
	 * @param taille de la cale
	 * @param chargeMax de la cale
	 */
	Ferry(double taille, double chargeMax){
		this.taille = taille;
		this.chargeMax = chargeMax;
		this.nbPassagers = 0;

		this.raG = new Rangee();
		this.raD = new Rangee();

		this.listing = new TreeSet<Ticket>();
	}

	/**
	 * Cette fonction a pour but de proceder a l'embarquement d'un véhicule, la gestion des erreurs
	 * à été implantée
	 * @param v véhicule
	 * @return 1 si embarquement réussi, -1 sinon
	 */
	public int embarquement(Vehicle v){
		if(raD.getCharge() >= raG.getCharge()){
			try{
				verifTaille(v, raG.getLongueur());
				verifPoids(v);
				raG.getRangee().offerLast(v);
				raG.addLongueur(v.getLongueur() + 0.5);
				listing.add(new Ticket('G', raG.getRang(), v));
				raG.incrRang();

				if(v instanceof Camion){
					Camion c = (Camion)v;
					raG.addCharge(v.getPoidsVide() + c.getPoidsCargaison());
				}
				else{
					raG.addCharge(v.getPoidsVide());
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return -1;
			}
		}
		else if(raD.getCharge() < raG.getCharge()){
			try{
				verifTaille(v, raD.getLongueur());
				verifPoids(v);
				raD.getRangee().offerLast(v);
				raD.addLongueur(v.getLongueur() + 0.5);

				listing.add(new Ticket('D', raD.getRang(), v));
				raD.incrRang();

				if(v instanceof Camion){
					Camion c = (Camion)v;
					raD.addCharge(v.getPoidsVide() + c.getPoidsCargaison());
				}
				else{
						raD.addCharge(v.getPoidsVide()); 
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return -1;
			}
		}

		if(v instanceof Voiture){
			Voiture v1 = (Voiture)v;
			nbPassagers += v1.getNbPassengers() + 1;
		}


		//System.out.println("Vehicule ajouté !");
		return 1;
	}

	/**
	 * Cette fonction a pour but de vérifier si la taille restante d'une rangée est suffisante pour embarquer un véhicule
	 * Lance une exception en cas de dépassement de la longueur max
	 * @param v véhicule
	 * @param longueur de la rangée
	 * @throws LengthException
	 */
	private void verifTaille(Vehicle v, double longueur) throws LengthException{
		if((v.getLongueur()+longueur) >= taille){
			throw new LengthException("Erreur : Taille restante insuffisante. Vehicule non ajouté.");
		}
	}

	/**
	 * Cette fonction a pour but de verifier si le poids restant de la cale est suffisant pour embarquer un vehicule
	 * Lance une exception en cas de dépassement du poids max
	 * @param v véhicule
	 * @throws WeightException
	 */
	private void verifPoids(Vehicle v) throws WeightException{
		if(v instanceof Camion){
			Camion c = (Camion)v;
			if((v.getPoidsVide() + c.getPoidsCargaison() + raD.getCharge() + raG.getCharge()) > chargeMax){
				throw new WeightException("Erreur : Vehicule trop lourd. Vehicule non ajouté.");
			}
		}
		else if((v.getPoidsVide() + raD.getCharge() + raG.getCharge()) > chargeMax){
			throw new WeightException("Erreur : Vehicule trop lourd. Vehicule non ajouté.");
		}
	}

	/**
	 * Cette fonction a pour but de proceder au debarquement d'un véhicule, elle vérifie si la cale n'est
	 * pas vide avant d'y proceder
	 */
	public void debarquement(){
		Vehicle deb;

		if(!raG.getRangee().isEmpty() || !raD.getRangee().isEmpty()){
			if(raD.getCharge() >= raG.getCharge()){
				deb = raD.getRangee().pollFirst();
				raD.decrRang();

				if(deb instanceof Camion){
					Camion c = (Camion)deb;
					raD.pickCharge(c.getPoidsVide() + c.getPoidsCargaison());
				}
				else{
					raD.pickCharge(deb.getPoidsVide());
				}
			}
			else{
				deb = raG.getRangee().pollFirst();
				raG.decrRang();
				if(deb instanceof Camion){
					Camion c = (Camion)deb;
					raG.pickCharge(c.getPoidsVide() + c.getPoidsCargaison());
				}
				else{
					raG.pickCharge(deb.getPoidsVide());
				}
			}

			System.out.println("\tVehicule débarqué :\n\t\t"+deb+"\n");
		}
		else{
			System.out.println("\tLa cale est vide.");
		}
	}

	/**
	 * Cette fonction a pou but d'afficher les vehicules présents dans les deux rangées, puis d'afficher
	 * un listing des tickets triés dans l'ordre alphabetique des Conducteurs des vehicules
	 */
	public String toString(){
		String str = "\nFerry :";

		str += "\n\tRangée gauche :\n";

		str += raG;

		str += "\n\tRangée droite :\n";

		str += raD;

		str+="\nPoids à gauche : "+raG.getCharge()+" / Poids à droite : "+raD.getCharge()+"\n\n";

		str += "Listing des tickets :\n";

		for(Ticket t : listing){
			str += t +"\n";
		}
		return str;

	}

}	