package overcooked_3;

public class Cuiner {
	
	private String nom;
	private int sexe; // (0-masculí, 1-femení)
	private double estat = 100.0;
	
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
		double desgastActualitzat = Restaurant.getInstance("El bistreau de DAMvi").getModificadorDesgastCuiner();
		
		Plat plat = Restaurant.getInstance("El bistreau de DAMvi").servirComanda();
		if(sexe == 1) {
			System.out.println("La cuinera " + nom + " està cuinant " + plat);
		}else {
			System.out.println( "El cuiner " + nom + " està cuinant " + plat);
		}
		Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(plat);
		
		if(this.estat <= 0) {
			this.estat = 0;
		}else {
			this.estat -= 5;
		}
	}
	
	@Override
	public String toString() {
		return "Cuiner [nom=" + nom + ", sexe=" + sexe + "]";
	}
}
