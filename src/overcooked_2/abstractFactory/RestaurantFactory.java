package overcooked_2.abstractFactory;

public interface RestaurantFactory {

    Cuiner crearCuiner(String nom, int sexe);

    Ingredient crearIngredient();

}
