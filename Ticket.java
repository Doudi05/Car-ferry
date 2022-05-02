
public class Ticket implements Comparable{
	private char place;
	private int rang;
	private Vehicle vehicle;
	private String nom;
	private String prenom;
	private double tarif;
	
	public Ticket(char place, int rang, Vehicle vehicle) {
		this.place = place;
		this.rang = rang;
		this.vehicle = vehicle;
		nom = vehicle.getConducteur().getNom();
		prenom = vehicle.getConducteur().getPrenom();
		setTarif();
	}
	
	public char getPlace(){
		return place;
	}
	
	public int getRang(){
		return rang;
	}
	
	public void setTarif(){
		if(vehicle instanceof Voiture) {
			Voiture v = (Voiture)vehicle;
			tarif = 35.0 + 3*v.getNbPassengers();
		}else if(vehicle instanceof Camion) {
			Camion v = (Camion)vehicle;
			tarif = 45.0 + 0.1*v.getPoidsCargaison();
		}
	}

	public double getTarif(){
		return this.tarif;
	}
	
	public String toString(){
		String st1 = "\t"+nom + " " + prenom + "\n";
		String st2 = "\tPosition du véhicule dans la cale : " + place + "\n";
		String st3 = "\tnuméro du rang dans la rangée : " + rang + "\n";
		String st4 = "\tLe tarif de la traversée : " + tarif;
		return st1 + st2 + st3 + st4 + "\n";
		
	}

	public int compareTo(Object o){
		if(o instanceof Ticket){
			Ticket t = (Ticket)o;
			if(this.nom.equals(t.nom)){
				return this.prenom.compareTo(t.prenom);
			}

			return this.nom.compareTo(t.nom);	
		}
		return -2;
	}

	public boolean equals(Ticket t){
		return (this.place == t.place) && (this.rang == t.rang) && (this.vehicle.equals(t.vehicle));
	}
}
