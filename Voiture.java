
public class Voiture extends Vehicle{
	private int nbPassagers;
	
	public Voiture(String string, double d, double e, Conducteur conducteur, int nbPassagers) {
		super(string, d, e , conducteur);
		this.nbPassagers = nbPassagers;
	}

	public int getNbPassengers()
	{
		return nbPassagers;
	}
}
