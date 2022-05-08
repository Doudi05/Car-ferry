
/**
 * @author Roux-Akel
 *
 */
public class Camion extends Vehicle{
	private double poidsCargaison;
	
	/**
	 * @param string immatriculation du camion
	 * @param d poidsVide du camion
	 * @param e longueur du camion
	 * @param conducteur conducteur du camion
	 * @param poidsCargaison du camion
	 */
	public Camion(String string, double d, double e, Conducteur conducteur, double poidsCargaison){
		super(string, d, e , conducteur);
		this.poidsCargaison = poidsCargaison;
	}
	
	/**
	 * @return poidsCargaison du camion
	 */
	public double getPoidsCargaison(){
		return poidsCargaison;
	}
}
