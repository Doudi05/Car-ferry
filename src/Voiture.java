
/**
 * @author Roux-Akel
 */
public class Voiture extends Vehicle{
	private int nbPassagers;
	
	/**
	 * constructeur parametré d'une voiture
	 * @param string immatriculation de la voiture
	 * @param d poidsVide de la voiture
	 * @param e longueur de la voiture
	 * @param conducteur conducteur de la voiture
	 * @param nbPassagers de la voiture
	 */
	public Voiture(String string, double d, double e, Conducteur conducteur, int nbPassagers) {
		super(string, d, e , conducteur);
		this.nbPassagers = nbPassagers;
	}

	/**
	 * retourne un entier correspondant au nombre de passagers présents dans la voiture
	 */
	public int getNbPassengers(){
		return nbPassagers;
	}
}
