package overcooked_4;

import java.util.ArrayList;
import java.util.List;
import overcooked_3.Plat;
import overcooked_3.Restaurant;
import overcooked_3.abstractFactory.Arros;
import overcooked_3.abstractFactory.Ingredient;
import overcooked_3.abstractFactory.Tomaquet;
import overcooked_3.factoryMethod.PizzaFactory;
import overcooked_3.factoryMethod.PlatFactory;
import overcooked_3.factoryMethod.SushiFactory;
import overcooked_4.observers.ConsumptionObserver;
import overcooked_4.observers.OrderObserver;
import overcooked_4.subjects.ConsumptionSubject;
import overcooked_4.subjects.OrderSubject;

public class Client implements OrderSubject, ConsumptionSubject {

	private String nom;
	private int tempsPaciencia;
	private String preferenciaCuina;
	private boolean marxa;
	private String alergia;
	
	private List<OrderObserver> orderObservers = new ArrayList<>();
	private ConsumptionObserver consumptionObserver;

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
				notifyOrderObservers(pizza);
				break;
			case "sashimi":
				PlatFactory sushiFactory = new SushiFactory();
				Ingredient arros = new Arros();
				Plat sushi = sushiFactory.crearPlat(arros);
				Restaurant.getInstance("El bistreau de DAMvi").afegirComanda(sushi);
				notifyOrderObservers(sushi);
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
			notifyConsumptionObservers(platCuinat, false, 0);
			return;
		}
		if (this.alergia != null && platCuinat.getNom().toLowerCase().contains(alergia.toLowerCase())) {
			this.marxa = true;
			System.out.println(this.nom + ": Soc alèrgic a aquest plat, marxo sense pagar.");
			Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(platCuinat);
			notifyConsumptionObservers(platCuinat, false, 0);
			return;
		}
		marxa = false;
		System.out.println(this.nom + " ha consumit el plat " + platCuinat.getNom());
		notifyConsumptionObservers(platCuinat, true, platCuinat.getCost());
		Restaurant.getInstance("El bistreau de DAMvi").afegirPlatBrut(platCuinat);
	}

	@Override
	public void registerConsumptionObserver(ConsumptionObserver observer) {
		// TODO Auto-generated method stub
		this.consumptionObserver = observer;
	}

	@Override
	public void removeConsumptionObserver(ConsumptionObserver observer) {
		// TODO Auto-generated method stub
		this.consumptionObserver = null;
	}

	@Override
	public void notifyConsumptionObservers(Plat plat, boolean paid, double amount) {
		// TODO Auto-generated method stub
		this.consumptionObserver.updateConsumption(plat, this.nom, paid, amount);
	}

	@Override
	public void registerOrderObserver(OrderObserver observer) {
		// TODO Auto-generated method stub
		this.orderObservers.add(observer);
	}

	@Override
	public void removeOrderObserver(OrderObserver observer) {
		// TODO Auto-generated method stub
		this.orderObservers.remove(observer);
	}

	@Override
	public void notifyOrderObservers(Plat plat) {
		// TODO Auto-generated method stub
		for(OrderObserver observer : this.orderObservers) {
			observer.updateOrder(plat, this.nom);
		}
	}
}