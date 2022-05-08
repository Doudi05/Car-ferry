
/**
 * @author Roux-Akel
 *
 */
public class Conducteur {
	private String nom;
	private String prenom;
	private String numPermis;
	
	/**
	 * @param nom du conducteur
	 * @param prenom du conducteur
	 * @param numPermis du conducteur
	 */
	public Conducteur(String nom, String prenom, String numPermis){
		this.nom = nom;
		this.prenom = prenom;
		this.numPermis = numPermis;
	}

	/**
	 * 
	 */
	public Conducteur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return nom du conducteur
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * @return prenom du conducteur
	 */
	public String getPrenom(){
		return prenom;
	}
	
	/**
	 * @return numPermis du conducteur
	 */
	public String getNumPermis(){
		return numPermis;
	}

	/**
	 * retourner le nom et prenom du conducteur
	 */
	public String toString(){
		return nom + " " + prenom;
	}
}
