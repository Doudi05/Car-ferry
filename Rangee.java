import java.util.Deque;
import java.util.LinkedList;

public class Rangee {
	private Deque<Vehicle> rangee; //D et G

	private double longueur; //D et G
	private double charge; //D et G
	private int rang; //D et G

	Rangee(double taille, double chargeMax){
		this.rangee = new LinkedList<Vehicle>();
		
		this.charge = 0;
		this.rang = 1;
		this.longueur = 0;
	}
	
	public double getCharge(){
		return this.charge;
	}
	
	public double getLongueur(){
		return this.longueur;
	}
	
	public int getRang(){
		return this.rang;
	}
	
	public Deque<Vehicle> getRangee(){
		return this.rangee;
	}
}
