package overcooked_2.abstractFactory;

import overcooked_2.Plat;
import overcooked_2.Restaurant;

public class CuinerPizza extends Cuiner {

	public CuinerPizza(String nom, int sexe) {
		super(nom, sexe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();

		if (!plat.getNom().toLowerCase().contains("pizza")) {
			System.out.println(this.getNom() + " es pizzer. No pot cuinar res que no sigui pizza.");
			return;
		}

		if (getSexe() == 0) {
			System.out.println("El cuiner de pizza " + getNom() + " està cuinant: " + plat);
		} else {
			System.out.println("La cuinera de pizza " + getNom() + " està cuinant: " + plat);
		}
		System.out.println(plat + " cuinat i consumit.");
		Restaurant.getInstance(nomRestaurant).afegirPlatBrut(plat);
	}
}