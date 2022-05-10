
/**
 * @author Roux-Akel
 */
public class Camion extends Vehicle{
	private double poidsCargaison;
	
	/**
	 * constructeur parametré d'un camion
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
	 * retourne un double correspondant au poids de la cargaison du camion
	 */
	public double getPoidsCargaison(){
		return poidsCargaison;
	}
}
