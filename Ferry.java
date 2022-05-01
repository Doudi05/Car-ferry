import java.util.*;

public class Ferry{
	private Deque<Vehicle> rangDroite;
	private Deque<Vehicle> rangGauche;

	private double longDroite, longGauche;
	private double taille;

	private double chargeMax, chargeDroite, chargeGauche;
	private int nbPassagers;

	Ferry(double taille, double chargeMax){
		this.taille = taille;
		this.chargeMax = chargeMax;
		this.nbPassagers = 0;
		
		this.chargeDroite = 0;
		this.chargeGauche = 0;

		this.rangGauche = new LinkedList<Vehicle>();
		this.rangDroite = new LinkedList<Vehicle>();
		this.longDroite = 0;
		this.longGauche = 0;
	}

	public int embarquement(Vehicle v){
		if(chargeDroite >= chargeGauche){
			if(verifTaille(v, longGauche) && verifPoids(v)){
				rangGauche.offerLast(v);
				longGauche += v.getLongueur() + 0.5;

				if(v instanceof Camion){
					Camion c = (Camion)v;
					chargeGauche += v.getPoidsVide() + c.getPoidsCargaison();
				}
				else{
					chargeGauche += v.getPoidsVide();
				}
			}
			else{
				System.out.println("Erreur lors de l'ajout du véhicule");
				return -1;
			}
		}
		else if(chargeDroite < chargeGauche){
			if(verifTaille(v,longDroite) && verifPoids(v)){
				rangDroite.offerLast(v);
				longDroite += v.getLongueur() + 0.5;
			}
			else{
				System.out.println("Erreur lors de l'ajout du véhicule");
				return -1;
			}

			if(v instanceof Camion){
					Camion c = (Camion)v;
					chargeDroite += v.getPoidsVide() + c.getPoidsCargaison();
			}
			else{
					chargeDroite += v.getPoidsVide();
			}
		}

		if(v instanceof Voiture){
			Voiture v1 = (Voiture)v;
			nbPassagers += v1.getNbPassengers() + 1;
		}

		System.out.println("Vehicule ajouté !");
		return 1;
	}

	private boolean verifTaille(Vehicle v, double longueur){
		if((v.getLongueur()+longueur) >= taille){
			return false;
		}

		return true;
	}

	private boolean verifPoids(Vehicle v){
		if(v instanceof Camion){
			Camion c = (Camion)v;
			if((v.getPoidsVide() + c.getPoidsCargaison() + chargeDroite + chargeGauche) > chargeMax){
				return false;
			}
		}
		else if((v.getPoidsVide() + chargeDroite + chargeGauche) > chargeMax){
			return false;
		}

		return true;
	}

	public void debarquement(){

	}

	public String toString(){
		String str = "Ferry :";

		str += "\n\tRangée gauche :\n";

		for(Vehicle v : rangGauche){
			str+="\t- "+v+"\n";
		}

		str += "\n\tRangée droite :\n";

		for(Vehicle v : rangDroite){
			str+="\t- "+v+"\n";
		}

		str+="Poids à gauche : "+chargeGauche+" / Poids à droite : "+chargeDroite;
		return str;

	}

}	