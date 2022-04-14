
public class Conducteur {
	private String Nom;
	private String Prenom;
	private String numPermis;
	
	public Conducteur(String Nom, String Prenom, String numPermis){
		Nom = this.Nom;
		Prenom = this.Prenom;
		numPermis = this.numPermis;
	}

	public Conducteur() {
		// TODO Auto-generated constructor stub
	}

	public String getNom()
	{
		return Nom;
	}
	
	public String getPrenom()
	{
		return Prenom;
	}
	
	public String getNumPermis()
	{
		return numPermis;
	}
}
