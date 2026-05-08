package overcooked_2.factoryMethod;

import overcooked_2.Ingredient;
import overcooked_2.Plat;

public class PizzaFactory extends PlatFactory {
	
	@Override
	public Plat crearPlat(Ingredient ingredient){
		return new Plat("Pizza amb "+ingredient.getNom());
	}

}
