
public abstract class Vehicle {
	private String immatriculation;
	private double poidsVide;
	private double longueur;
	private Conducteur conducteur;
	
	public Vehicle(String immatriculation, double poidsVide, double longueur, Conducteur conducteur) {
		this.immatriculation = immatriculation;
		this.poidsVide = poidsVide;
		this.longueur = longueur;
		this.conducteur = conducteur;
	}

	public String getImmatriculation()
	{
		return this.immatriculation;
	}
	
	public double getPoidsVide()
	{
		return this.poidsVide;
	}
	
	public double getLongueur()
	{
		return this.longueur;
	}
	
	public Conducteur getConducteur()
	{
		return this.conducteur;
	}
}
