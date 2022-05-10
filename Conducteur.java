
/**
 * @author Roux-Akel
 */
public class Conducteur {
	private String nom;
	private String prenom;
	private String numPermis;
	
	/**
	 * constructeur parametré d'un conducteur
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
	 * retourne une chaine de caracteres correspondant au nom du conducteur
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * retourne une chaine de caractere correspondant au prenom du conducteur
	 */
	public String getPrenom(){
		return prenom;
	}
	
	/**
	 * retourne une chaine de caracteres correspondant au numero de permis de conduire du conducteur
	 */
	public String getNumPermis(){
		return numPermis;
	}

	/**
	 * Retourne une chaine de caractere correspondant a la description du conducteur (nom + prenom)
	 */
	public String toString(){
		return nom + " " + prenom;
	}
}
