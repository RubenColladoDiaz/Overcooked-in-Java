package overcooked_1;

public class Cuiner {
	
	private String nom;
	private int sexe; // (0-masculí, 1-femení)
	
	public Cuiner(String nom, int sexe) {
		super();
		this.nom = nom;
		this.sexe = sexe;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getSexe() {
		return sexe;
	}
	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	
	public void cuinar() {
		Plat plat = Restaurant.getInstance("El bistreau de DAMvi").servirComanda();
		if(sexe == 1) {
			System.out.println("La cuinera " + nom + " està cuinant " + plat);
		}else {
			System.out.println( "El cuiner " + nom + " està cuinant " + plat);
		}
		Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(plat);
	}
	
	@Override
	public String toString() {
		return "Cuiner [nom=" + nom + ", sexe=" + sexe + "]";
	}
}
