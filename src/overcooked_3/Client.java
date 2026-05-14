package overcooked_3;

import overcooked_3.abstractFactory.Arros;
import overcooked_3.abstractFactory.Ingredient;
import overcooked_3.abstractFactory.Tomaquet;
import overcooked_3.factoryMethod.PizzaFactory;
import overcooked_3.factoryMethod.PlatFactory;
import overcooked_3.factoryMethod.SushiFactory;

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

	public Client(String nom, String preferenciaCuina, String alergia) {
		super();
		this.nom = nom;
		this.preferenciaCuina = preferenciaCuina;
		this.alergia = alergia;
		this.tempsPaciencia = 18;
	}

	public void ferComanda() {
		switch (preferenciaCuina.toLowerCase()) {
			case "pizza":
				PlatFactory pizzaFactory = new PizzaFactory();
				Ingredient tomaquet = new Tomaquet();
				Plat pizza = pizzaFactory.crearPlat(tomaquet);
				Restaurant.getInstance("El bistreau de DAMvi").afegirComanda(pizza);
				break;
			case "sashimi":
				PlatFactory sushiFactory = new SushiFactory();
				Ingredient arros = new Arros();
				Plat sushi = sushiFactory.crearPlat(arros);
				Restaurant.getInstance("El bistreau de DAMvi").afegirComanda(sushi);
				break;
			default:
				break;
		}
	}

	public void consumirPlat(Plat platCuinat) {
		double tempsPreparacio = platCuinat.getTempsPreparacio();
		if (tempsPreparacio > tempsPaciencia) {
			this.marxa = true;
			System.out.println(this.nom + ": El plat triga molt, marxo sense pagar.");
			Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(platCuinat);
			return;
		}
		if (this.alergia != null && platCuinat.getNom().toLowerCase().contains(alergia.toLowerCase())) {
			this.marxa = true;
			System.out.println(this.nom + ": Soc alèrgic a aquest plat, marxo sense pagar.");
			Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(platCuinat);
			return;
		}
		System.out.println(this.nom + " ha consumit el plat " + platCuinat.getNom());
		Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(platCuinat);
	}
}