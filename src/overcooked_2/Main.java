package overcooked_2;

import overcooked_2.abstractFactory.Cuiner;
import overcooked_2.abstractFactory.Ingredient;
import overcooked_2.abstractFactory.ItaliaFactory;
import overcooked_2.abstractFactory.JapoFactory;
import overcooked_2.abstractFactory.RestaurantFactory;
import overcooked_2.factoryMethod.PizzaFactory;
import overcooked_2.factoryMethod.PlatFactory;
import overcooked_2.factoryMethod.SushiFactory;

public class Main {
       public static void main(String[] args) throws InterruptedException {
              Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
              restaurant.obrirRestaurant();

              PlatFactory pizzaFactory = new PizzaFactory();
              PlatFactory sushiFactory = new SushiFactory();

              RestaurantFactory italiaFactory = new ItaliaFactory();
              Cuiner cuinerItalia = italiaFactory.crearCuiner("Dani", 0);
              Ingredient ingredientItalia = italiaFactory.crearIngredient();
              Plat platItalia = pizzaFactory.crearPlat(ingredientItalia);

              RestaurantFactory japoFactory = new JapoFactory();
              Cuiner cuinerJapones = japoFactory.crearCuiner("Marc", 0);
              Ingredient ingredientJapones = japoFactory.crearIngredient();
              Plat platJapones = sushiFactory.crearPlat(ingredientJapones);

              restaurant.afegirComanda(platItalia);
              restaurant.afegirComanda(platJapones);

              cuinerItalia.cuinar(restaurant.getNom());
              cuinerJapones.cuinar(restaurant.getNom());

              restaurant.iniciarRentatAutomatic();
       }
}