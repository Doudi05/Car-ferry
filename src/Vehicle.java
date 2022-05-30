
/**
 * @author R+oux-Akel
 */
public abstract class Vehicle {
	private String immatriculation;
	private double poidsVide;
	private double longueur;
	private Conducteur conducteur;
	
	/**
	 * Constructeur avec paramètres de Véhicule
	 * @param immatriculation du vehicule
	 * @param poidsVide du vehicule
	 * @param longueur du vehicule
	 * @param conducteur du vehicule
	 */
	public Vehicle(String immatriculation, double poidsVide, double longueur, Conducteur conducteur) {
		this.immatriculation = immatriculation;
		this.poidsVide = poidsVide;
		this.longueur = longueur;
		this.conducteur = conducteur;
	}

	/**
	 * retourne une chaine de caracteres correspondant a l'immatriculation du vehicule
	 */
	public String getImmatriculation(){
		return this.immatriculation;
	}
	
	/**
	 * retourne un double correspondant au poids a vide du vehicule
	 */
	public double getPoidsVide(){
		return this.poidsVide;
	}
	
	/**
	 * Retourne un double correspondant a la longueur du véhicule
	 */
	public double getLongueur(){
		return this.longueur;
	}
	
	/**
	 * Retourne le Conducteur du Véhicule
	 */
	public Conducteur getConducteur(){
		return this.conducteur;
	}

	/**
	 * retourne une chaine de caractere correspondant a la description d'un Véhicule
	 */
	public String toString(){
		return immatriculation + " : "+ conducteur;
	}
}
