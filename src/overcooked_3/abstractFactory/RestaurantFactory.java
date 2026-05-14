package overcooked_3.abstractFactory;

public interface RestaurantFactory {

    Cuiner crearCuiner(String nom, int sexe);

    Ingredient crearIngredient();

}
