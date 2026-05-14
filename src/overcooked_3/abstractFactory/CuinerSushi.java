package overcooked_3.abstractFactory;

import overcooked_3.Plat;
import overcooked_3.Restaurant;

public class CuinerSushi extends Cuiner {

	public CuinerSushi(String nom, int sexe) {
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

		if (!plat.getNom().toLowerCase().contains("sashimi")) {
			System.out.println(this.getNom() + " es un cuiner de sushi. No pot cuinar res que no sigui sushi.");
			return;
		}

		if (getSexe() == 0) {
			System.out.println("El cuiner de sushi " + getNom() + " està cuinant: " + plat);
		} else {
			System.out.println("La cuinera de sushi " + getNom() + " està cuinant: " + plat);
		}

		if (this.estat > 0) {
			double modificador = Restaurant.getInstance(nomRestaurant).getModificadorDesgastCuiner();
			double desgasteBase = 5.0;
			this.estat -= desgasteBase * modificador;
		}

		System.out.println(plat + " cuinat.");
	}
}