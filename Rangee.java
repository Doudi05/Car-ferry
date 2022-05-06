import java.util.Deque;
import java.util.LinkedList;

public class Rangee {
	private Deque<Vehicle> rangee;

	private double longueur;
	private double charge;
	private int rang;

	Rangee(){
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

	public void addLongueur(double lng){
		this.longueur += lng;
	}

	public void addCharge(double charge){
		this.charge += charge;
	}

	public void pickLongueur(double lng){
		this.longueur -= lng;
	}

	public void pickCharge(double charge){
		this.charge -= charge;
	}

	public void incrRang(){
		this.rang++;
	}
	
	public Deque<Vehicle> getRangee(){
		return this.rangee;
	}

	public String toString(){
		String str = "";

		for(Vehicle v : rangee){
			str+="\t- "+v+"\n";
		}

		return str;
	}
}
