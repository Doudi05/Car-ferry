import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Roux-Akel
 *
 */
public class Rangee {
	private Deque<Vehicle> rangee;

	private double longueur;
	private double charge;
	private int rang;

	/**
	 * 
	 */
	Rangee(){
		this.rangee = new LinkedList<Vehicle>();
		
		this.charge = 0;
		this.rang = 1;
		this.longueur = 0;
	}
	
	/**
	 * @return la charge de la cale
	 */
	public double getCharge(){
		return this.charge;
	}
	
	/**
	 * @return la longueur de la cale
	 */
	public double getLongueur(){
		return this.longueur;
	}
	
	/**
	 * @return le rang du véhicule
	 */
	public int getRang(){
		return this.rang;
	}

	/**
	 * @param lng ajouter une longueur
	 */
	public void addLongueur(double lng){
		this.longueur += lng;
	}

	/**
	 * @param charge ajouter un poids
	 */
	public void addCharge(double charge){
		this.charge += charge;
	}

	/**
	 * @param lng retirer une longueur
	 */
	public void pickLongueur(double lng){
		this.longueur -= lng;
	}

	/**
	 * @param charge retirer un poids
	 */
	public void pickCharge(double charge){
		this.charge -= charge;
	}

	/**
	 * 
	 */
	public void incrRang(){
		this.rang++;
	}
	
	/**
	 * @return la rangée choisie
	 */
	public Deque<Vehicle> getRangee(){
		return this.rangee;
	}

	/**
	 * afficher la position du véhicule dans la rangée
	 */
	public String toString(){
		String str = "";

		for(Vehicle v : rangee){
			str+="\t- "+v+"\n";
		}

		return str;
	}
}
