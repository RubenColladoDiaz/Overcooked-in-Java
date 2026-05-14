package overcooked_3.abstractFactory;

public class ItaliaFactory implements RestaurantFactory {

	@Override
	public Cuiner crearCuiner(String nom, int sexe) {
		// TODO Auto-generated method stub
		return new CuinerPizza(nom, sexe);
	}

	@Override
	public Ingredient crearIngredient() {
		// TODO Auto-generated method stub
		return new Tomaquet();
	}

}
