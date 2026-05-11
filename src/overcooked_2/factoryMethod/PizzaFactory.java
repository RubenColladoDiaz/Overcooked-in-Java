package overcooked_2.factoryMethod;

import overcooked_2.Plat;
import overcooked_2.abstractFactory.Ingredient;

public class PizzaFactory extends PlatFactory {

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		return new Plat("Pizza amb " + ingredient.getNom());
	}

}
