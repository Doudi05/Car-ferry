
/**
 * @author Roux-Akel
 *
 */
public abstract class Vehicle {
	private String immatriculation;
	private double poidsVide;
	private double longueur;
	private Conducteur conducteur;
	
	/**
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
	 * @return immatriculation du vehicule
	 */
	public String getImmatriculation(){
		return this.immatriculation;
	}
	
	/**
	 * @return poidsVide du vehicule
	 */
	public double getPoidsVide(){
		return this.poidsVide;
	}
	
	/**
	 * @return longueur du vehicule
	 */
	public double getLongueur(){
		return this.longueur;
	}
	
	/**
	 * @return conducteur du vehicule
	 */
	public Conducteur getConducteur(){
		return this.conducteur;
	}

	/**
	 * retourner l'immatriculation et le conducteur du vehicule
	 */
	public String toString(){
		return immatriculation + " : "+ conducteur;
	}
}
