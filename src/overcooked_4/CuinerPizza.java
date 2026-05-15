package overcooked_4;

import overcooked_3.Plat;
import overcooked_3.decorators.ingredients.FormatgeExtra;
import overcooked_3.decorators.ingredients.Pepperoni;

public class CuinerPizza extends Cuiner {

	public CuinerPizza(String nom, int sexe) {
		super(nom, sexe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();

		if (this.estat <= 30) {
			System.out.println(this.getNom() + " rebutja el plat per poc estat.");
			Restaurant.getInstance(nomRestaurant).afegirComanda(plat);
			this.estat += 10;
			return;
		}

		if (!plat.getNom().toLowerCase().contains("pizza")) {
			System.out.println(this.getNom() + " es pizzer. No pot cuinar res que no sigui pizza.");
			return;
		}

		if (getSexe() == 0) {
			System.out.println("El cuiner de pizza " + getNom() + " està cuinant: " + plat);
			plat = new Pepperoni(plat);
		} else {
			System.out.println("La cuinera de pizza " + getNom() + " està cuinant: " + plat);
		}
		plat = new FormatgeExtra(plat);

		if (this.estat > 0) {
			double modificador = Restaurant.getInstance(nomRestaurant).getModificadorDesgastCuiner();
			double desgasteBase = 5.0;
			this.estat -= desgasteBase * modificador;
		}
		System.out.println(plat + " cuinat.");
	}

	@Override
	public void updateOrder(Plat plat, String clientName) {
		// TODO Auto-generated method stub
		if(plat.getNom().toLowerCase().contains("pizza")) {
			cuinar("El bistreau de DAMvi");
		}
	}
}