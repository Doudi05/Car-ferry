import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Roux-Akel
 */
public class Rangee {
	private Deque<Vehicle> rangee;

	private double longueur;
	private double charge;
	private int rang;

	/**
	 * constructeur de rangée sans parametres
	 */
	Rangee(){
		this.rangee = new LinkedList<Vehicle>();
		
		this.charge = 0;
		this.rang = 0;
		this.longueur = 0;
	}
	
	/**
	 * retourne un double correspondant a la charge d'une rangée
	 */
	public double getCharge(){
		return this.charge;
	}
	
	/**
	 * retourne un double correspondant a la longueur d'une rangee
	 */
	public double getLongueur(){
		return this.longueur;
	}
	
	/**
	 * retourne un entier correspondant au rang du dernier vehicule dans la rangée
	 */
	public int getRang(){
		return this.rang;
	}

	/**
	 * Cette fonction va allonger une rangée suite a l'ajout d'un vehicule
	 */
	public void addLongueur(double lng){
		this.longueur += lng;
	}

	/**
	 * Cette fonction va allourdir une rangee suite a l'ajout d'un vehicule
	 */
	public void addCharge(double charge){
		this.charge += charge;
	}

	/**
	 * Cette fonction va racourcir une rangee suite au debarquement d'un vehicule
	 */
	public void pickLongueur(double lng){
		this.longueur -= lng;
	}

	/**
	 * Cette fonction va alleger une rangée suite au debarquement d'un vehicule
	 */
	public void pickCharge(double charge){
		this.charge -= charge;
	}

	/**
	 * On incremente le rang courant d'une rangee suite a l'ajout d'un vehicule
	 */
	public void incrRang(){
		this.rang++;
	}

	/**
	 * On decremente le rang courant d'une rangee suite au debarquement d'un vehicule
	 */
	public void decrRang(){
		this.rang--;
	}
	
	/**
	 * Retourne une rangee correspondant a la liste des vehicules presents dans celle ci
	 */
	public Deque<Vehicle> getRangee(){
		return this.rangee;
	}

	/**
	 * Retourne une chaine de caracteres correspondant a la description d'une rangee (liste des vehicules)
	 */
	public String toString(){
		String str = "";

		for(Vehicle v : rangee){
			str+="\t- "+v+"\n";
		}

		return str;
	}
}
