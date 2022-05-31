
/**
 * @author Roux-Akel
 */
public class Ticket implements Comparable<Object>{
	private char place;
	private int rang;
	private Vehicle vehicle;
	private String nom;
	private String prenom;
	private double tarif;
	
	/**
	 * constructeur parametré d'un ticket
	 * @param place du véhicule dans la cale
	 * @param rang dans la rangée
	 * @param vehicle véhicule
	 */
	public Ticket(char place, int rang, Vehicle vehicle) {
		this.place = place;
		this.rang = rang;
		this.vehicle = vehicle;
		nom = vehicle.getConducteur().getNom();
		prenom = vehicle.getConducteur().getPrenom();
		setTarif();
	}
	
	/**
	 * @return la place du véhicule dans la cale
	 */
	public char getPlace(){
		return place;
	}
	
	/**
	 * @return le rang dans la rangée
	 */
	public int getRang(){
		return rang;
	}

	/**
	 * modifie le rang du ticket (1, 2 ,3 ...)
	 */
	public void setRang(int rang){
		this.rang = rang;
	}
	
	/**
	 * calcule le tarif de la traversée pour un véhicule
	 */
	public void setTarif(){
		if(vehicle instanceof Voiture) {
			Voiture v = (Voiture)vehicle;
			tarif = 35.0 + 3*v.getNbPassengers();
		}else if(vehicle instanceof Camion) {
			Camion v = (Camion)vehicle;
			tarif = 45.0 + 0.1*(v.getPoidsCargaison()*1000);
		}
	}

	/**
	 * @return le tarif de la traversée pour un véhicule
	 */
	public double getTarif(){
		return this.tarif;
	}

	public String getNom(){
		return this.nom;
	}

	public String toString(){
		return rang + " " + nom + " " + prenom + " : " + vehicle.getImmatriculation() + " : " + tarif +"euros";
	}

	/**
	 * Compare les tickets pour les afficher par ordre alphabétique des conducteurs de véhicules
	 */
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

	/**
	 * @param t la liste des tickets
	 * @return true si les deux tickets sont egaux, false sinon
	 */
	public boolean equals(Ticket t){
		return (this.place == t.place) && (this.rang == t.rang) && (this.vehicle.equals(t.vehicle));
	}
}
