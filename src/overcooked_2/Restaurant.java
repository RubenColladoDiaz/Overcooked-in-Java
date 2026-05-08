package overcooked_2;

public class Restaurant {
    
	//atributs del restaurant
    private static Restaurant instance;
    private static String nom;
    
    public static Comandes comandes = new Comandes();
    private static PlatsBruts platsBruts = new PlatsBruts();
    
    //constructor privat de restaurant
    private Restaurant(String nom) {
		Restaurant.nom=nom;
	}
    
    //mètode getInstance que es cridarà des de fora i que accedirà al constructor privat
    public static Restaurant getInstance(String nom) {
		if(instance==null) {
			instance = new Restaurant(nom);
		}
		return instance;
	}
    
    // mètodes
	public void obrirRestaurant() {
		System.out.println("El restaurant "+nom+" està obert!");
	}
	public static String getNom() {
		return nom;
	}
	
	public void afegirComanda(Plat p) {
		comandes.add(p);
		System.out.println("S'ha afegit a una comanda el plat " + p);
	}
	
	public Plat servirComanda() {
		Plat plat = comandes.poll();
		System.out.println("Es serveix el plat " + plat);
		return plat;
	}
	
	public void afegirPlatBrut(Plat p) {
		platsBruts.add(p);
		System.out.println(p + " s'ha afegit als plats bruts.");
	}
	
	public void iniciarRentatAutomatic() throws InterruptedException {
		while(!platsBruts.isEmpty()) {
			Thread.sleep(3000);
			Plat platANetejar = platsBruts.poll();
			System.out.println("S'ha netejat el plat " + platANetejar);
		}
		if(platsBruts.isEmpty()) {
			System.out.println("El rentat automàtic ha acabat, no queden més plats bruts.");
		}
	}
}
