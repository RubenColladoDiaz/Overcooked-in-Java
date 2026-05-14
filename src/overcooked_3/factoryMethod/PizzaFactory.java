package overcooked_3.factoryMethod;

import overcooked_3.Plat;
import overcooked_3.PlatBasic;
import overcooked_3.abstractFactory.Ingredient;

public class PizzaFactory extends PlatFactory {

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		return new PlatBasic("Pizza amb " + ingredient.getNom());
	}

}
