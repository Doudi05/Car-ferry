
public class Camion extends Vehicle{
	private double poidsCargaison;
	
	public Camion(String string, double d, double e, Conducteur conducteur, double poidsCargaison){
		super(string, d, e , conducteur);
		this.poidsCargaison = poidsCargaison;
	}
	
	public Camion() {
		// TODO Auto-generated constructor stub
	}

	public double getpoidsCargaison()
	{
		return poidsCargaison;
	}
}