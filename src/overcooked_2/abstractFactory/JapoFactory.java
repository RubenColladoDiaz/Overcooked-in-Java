package overcooked_2.abstractFactory;

public class JapoFactory implements RestaurantFactory {

	@Override
	public Cuiner crearCuiner(String nom, int sexe) {
		// TODO Auto-generated method stub
		return new CuinerSushi(nom, sexe);
	}

	@Override
	public Ingredient crearIngredient() {
		// TODO Auto-generated method stub
		return new Arros();
	}

}
