import java.util.*;

public class Ferry{
	private Deque<Vehicle> rangDroite;
	private Deque<Vehicle> rangGauche;

	private TreeSet<Ticket> listing;

	private double longDroite, longGauche;
	private double taille;

	private double chargeMax, chargeDroite, chargeGauche;
	private int indG, indD;
	private int nbPassagers;

	Ferry(double taille, double chargeMax){
		this.taille = taille;
		this.chargeMax = chargeMax;
		this.nbPassagers = 0;
		
		this.chargeDroite = 0;
		this.chargeGauche = 0;

		this.indD = 1;
		this.indG = 1;

		this.rangGauche = new LinkedList<Vehicle>();
		this.rangDroite = new LinkedList<Vehicle>();
		this.longDroite = 0;
		this.longGauche = 0;

		this.listing = new TreeSet<Ticket>();
	}

	public int embarquement(Vehicle v){
		if(chargeDroite >= chargeGauche){
			try{
				verifTaille(v, longGauche);
				verifPoids(v);
				rangGauche.offerLast(v);
				longGauche += v.getLongueur() + 0.5;
				listing.add(new Ticket('G', indG, v));
				indG++;

				if(v instanceof Camion){
					Camion c = (Camion)v;
					chargeGauche += v.getPoidsVide() + c.getPoidsCargaison();
				}
				else{
					chargeGauche += v.getPoidsVide();
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return -1;
			}
		}
		else if(chargeDroite < chargeGauche){
			try{
				verifTaille(v, longDroite);
				verifPoids(v);
				rangDroite.offerLast(v);
				longDroite += v.getLongueur() + 0.5;

				listing.add(new Ticket('D', indD, v));
				indD++;

				if(v instanceof Camion){
					Camion c = (Camion)v;
					chargeDroite += v.getPoidsVide() + c.getPoidsCargaison();
				}
				else{
						chargeDroite += v.getPoidsVide();
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


		System.out.println("Vehicule ajouté !");
		return 1;
	}

	private void verifTaille(Vehicle v, double longueur) throws LengthException{
		if((v.getLongueur()+longueur) >= taille){
			throw new LengthException("Erreur : Taille restante insuffisante. Vehicule non ajouté.");
		}
	}

	private void verifPoids(Vehicle v) throws WeightException{
		if(v instanceof Camion){
			Camion c = (Camion)v;
			if((v.getPoidsVide() + c.getPoidsCargaison() + chargeDroite + chargeGauche) > chargeMax){
				throw new WeightException("Erreur : Vehicule trop lourd. Vehicule non ajouté.");
			}
		}
		else if((v.getPoidsVide() + chargeDroite + chargeGauche) > chargeMax){
			throw new WeightException("Erreur : Vehicule trop lourd. Vehicule non ajouté.");
		}
	}

	public void debarquement(){
		System.out.println("Debarquement des vehicules...\n");
		Vehicle deb;

		while(!rangGauche.isEmpty() || !rangDroite.isEmpty()){
			if(chargeDroite >= chargeGauche){
				deb = rangDroite.pollFirst();

				if(deb instanceof Camion){
					Camion c = (Camion)deb;
					chargeDroite -= c.getPoidsVide() + c.getPoidsCargaison();
				}
				else{
					chargeDroite -= deb.getPoidsVide();
				}
			}
			else{
				deb = rangGauche.pollFirst();

				if(deb instanceof Camion){
					Camion c = (Camion)deb;
					chargeGauche -= c.getPoidsVide() + c.getPoidsCargaison();
				}
				else{
					chargeGauche -= deb.getPoidsVide();
				}
			}

			System.out.println("Vehicule débarqué :\n\t"+deb+"\n");
		}
	}

	public String toString(){
		String str = "\nFerry :";

		str += "\n\tRangée gauche :\n";

		for(Vehicle v : rangGauche){
			str+="\t- "+v+"\n";
		}

		str += "\n\tRangée droite :\n";

		for(Vehicle v : rangDroite){
			str+="\t- "+v+"\n";
		}

		str+="\nPoids à gauche : "+chargeGauche+" / Poids à droite : "+chargeDroite+"\n\n";

		str += "Listing des tickets :\n";

		for(Ticket t : listing){
			str += t +"\n";
		}
		return str;

	}

}	