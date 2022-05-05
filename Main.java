
public class Main {

	public static void main(String[] args) {

		Ferry ferry = new Ferry(50, 75);
		
		Voiture v1 = new Voiture("RM 1054 FF", 1.2, 4.2, new Conducteur("Martin", "Jeanne", "22FF"), 2);
		Voiture v2 = new Voiture("PO 377 AA", 1.4, 4.5, new Conducteur("Dupont", "Vincent", "A55"), 1);
		Voiture v3 = new Voiture("WX 456 RT", 1.2, 5.3, new Conducteur("Durand", "Marie", "B34"), 0);
		
		Camion c1 = new Camion("AZ 678 DF", 4, 12, new Conducteur("Grant", "Philip", "20FF"), 15);
		Camion c2 = new Camion("QS 543 HJ", 5.2, 13.5, new Conducteur("Scott", "Simon", "B55JG"), 22.5);
		Camion c3 = new Camion("BN 321 XC", 4.5, 15, new Conducteur("Lambert", "Alain", "C44Djk"), 18);

		Vehicle []vehicles = {c1, v1, v2, c2, v3, c3};

		for(int i = 0; i < vehicles.length; ++i){
			ferry.embarquement(vehicles[i]);
		}

		System.out.println(ferry);


		ferry.debarquement();
	}	

}
