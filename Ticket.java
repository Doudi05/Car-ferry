
public class Ticket{
	private char place;
	private int rang;
	private Vehicle vehicle;
	
	public Ticket(char place, int rang, Vehicle vehicle) {
		this.place = place;
		this.rang = rang;
		this.vehicle = vehicle;
	}
	
	public Ticket() {
		
	}
	
	public char getPlace(){
		return place;
	}
	
	public int getRang(){
		return rang;
	}
	
	public double getTarif(Vehicle vehicule){
		double tarif = 2;
		if(vehicule instanceof Voiture) {
			tarif = 35.0 + 3*((Voiture) vehicule).getNbPassengers();
		}else if(vehicule instanceof Camion) {
			tarif = 45.0 + 0.1*((Camion) vehicule).getpoidsCargaison();
		}
		return tarif;
	}
	
	public String toString(){
		String st1 = vehicle.getConducteur().getNom() + " " + vehicle.getConducteur().getPrenom() + "\n";
		String st2 = "Position du véhicule dans la cale : " + getPlace() + "\n";
		String st3 = "numéro du rang dans la rangée : " + getRang() + "\n";
		String st4 = "Le tarif de la traversée : " + getTarif(vehicle);
		return st1 + st2 + st3 + st4;
		
	}
}
