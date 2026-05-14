package overcooked_3.abstractFactory;

public abstract class Cuiner {

	private String nom;
	private int sexe; // (0-masculí, 1-femení)
	
	protected double estat = 100.0;

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

	public void cuinar(String nomRestaurant) {
	}

	@Override
	public String toString() {
		return "Cuiner [nom=" + nom + ", sexe=" + sexe + "]";
	}
}
