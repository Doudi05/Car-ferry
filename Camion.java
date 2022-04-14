
public class Camion extends Vehicle{
	private double poidsCargaison;
	
	public Camion(String string, double d, double e, Conducteur conducteur, double poidsCargaison){
		super(string, d, e , conducteur);
		poidsCargaison = this.poidsCargaison;
	}
	
	public double getpoidsCargaison()
	{
		return poidsCargaison;
	}
}
