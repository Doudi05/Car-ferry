
/**
 * @author Roux-Akel
 *
 */
public class Voiture extends Vehicle{
	private int nbPassagers;
	
	/**
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
	 * @return nombre de passagers de la voiture
	 */
	public int getNbPassengers(){
		return nbPassagers;
	}
}
