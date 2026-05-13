package overcooked_3;

public class PlatBasic implements Plat{
	private String nom;
	private double tempsPreparacio = 5.0; // Temps base en segons
	private double cost = 10.0; // Cost base en euros

   	public PlatBasic(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public double getTempsPreparacio() {
		return tempsPreparacio;
	}
	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "PlatBasic [nom=" + nom + ", tempsPreparacio=" + tempsPreparacio + ", cost=" + cost + "]";
	}
}