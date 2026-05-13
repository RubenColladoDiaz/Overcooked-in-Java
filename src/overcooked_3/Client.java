package overcooked_3;

public class Client {
	
	private String nom;
	private int tempsPaciencia;
	private String preferenciaCuina;
	private boolean marxa;
	private String alergia;
	
	public Client(String nom, String preferenciaCuina) {
		super();
		this.nom = nom;
		this.preferenciaCuina = preferenciaCuina;
		this.tempsPaciencia = 20;
		this.marxa = false;
		this.alergia = null;
	}

	public Client(String alergia) {
		super();
		this.alergia = alergia;
		this.tempsPaciencia = 18;
	}
	
}
