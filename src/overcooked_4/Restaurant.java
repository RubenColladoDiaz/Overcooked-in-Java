package overcooked_4;

import overcooked_3.Comandes;
import overcooked_3.DecoradorAmbient;
import overcooked_3.Plat;
import overcooked_3.PlatsBruts;
import overcooked_4.*;
import overcooked_4.observers.ConsumptionObserver;

public class Restaurant implements DecoradorAmbient, ConsumptionObserver {

	// atributs del restaurant
	private static Restaurant instance;
	private static String nom;

	public static Comandes comandes = new Comandes();
	private static PlatsBruts platsBruts = new PlatsBruts();

	private DecoradorAmbient ambient;
	
	private double ingresos = 0.0;
	private int popularitat = 0;

	// constructor privat de restaurant
	private Restaurant(String nom) {
		Restaurant.nom = nom;
		this.ingresos = 0.00;
		this.popularitat = 50;
	}

	// mètode getInstance que es cridarà des de fora i que accedirà al constructor
	// privat
	public static Restaurant getInstance(String nom) {
		if (instance == null) {
			instance = new Restaurant(nom);
		}
		return instance;
	}

	// mètodes
	public void obrirRestaurant() {
		System.out.println("El restaurant " + nom + " està obert!");
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
		while (!platsBruts.isEmpty()) {
			Thread.sleep(3000);
			Plat platANetejar = platsBruts.poll();
			System.out.println("S'ha netejat el plat " + platANetejar);
		}
		if (platsBruts.isEmpty()) {
			System.out.println("El rentat automàtic ha acabat, no queden més plats bruts.");
		}
	}

	public void setAmbient(DecoradorAmbient ambient) {
		this.ambient = ambient;
	}

	@Override
	public double getModificadorDesgastCuiner() {
		return ambient.getModificadorDesgastCuiner();
	}

	@Override
	public double getModificadorPacienciaClient() {
		return ambient.getModificadorPacienciaClient();
	}

	@Override
	public void updateConsumption(Plat plat, String clientName, boolean paid, double amount) {
		// TODO Auto-generated method stub
		if(paid) {
			this.ingresos += amount;
			this.popularitat += 5;
		}else {
			this.popularitat -= 10;
		}
	}
}
