
public class Conducteur {
	private String nom;
	private String prenom;
	private String numPermis;
	
	public Conducteur(String nom, String prenom, String numPermis){
		this.nom = nom;
		this.prenom = prenom;
		this.numPermis = numPermis;
	}

	public Conducteur() {
		// TODO Auto-generated constructor stub
	}

	public String getNom()
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	
	public String getNumPermis()
	{
		return numPermis;
	}

	public String toString(){
		return nom + " " + prenom;
	}
}
