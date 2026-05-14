package overcooked_3;

import overcooked_3.abstractFactory.*;
import overcooked_3.decorators.ambient.AmbTempesta;
import overcooked_3.decorators.ambient.SobreLava;
import overcooked_3.factoryMethod.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Restaurant restaurant = Restaurant.getInstance("Restaurant Caòtic");

        AmbientBase baseAmbient = new AmbientBase();
        SobreLava lamaAmbient = new SobreLava(baseAmbient);
        AmbTempesta tempestAmbient = new AmbTempesta(lamaAmbient);
        restaurant.setAmbient(tempestAmbient);

        System.out.println("PRIMERA RONDA");
        System.out.println("Modificador desgaste: " + restaurant.getModificadorDesgastCuiner());

        PlatFactory pizzaFactory = new PizzaFactory();
        PlatFactory sushiFactory = new SushiFactory();

        RestaurantFactory italiaFactory = new ItaliaFactory();
        Cuiner cuinerItalia1 = italiaFactory.crearCuiner("Marco", 0);
        Ingredient ingredientItalia1 = italiaFactory.crearIngredient();
        Plat platItalia1 = pizzaFactory.crearPlat(ingredientItalia1);

        RestaurantFactory japoFactory = new JapoFactory();
        Cuiner cuinerJapo = japoFactory.crearCuiner("Yuki", 1);
        Ingredient ingredientJapo = japoFactory.crearIngredient();
        Plat platJapo = sushiFactory.crearPlat(ingredientJapo);

        Cuiner cuinerItalia2 = italiaFactory.crearCuiner("Giulia", 1);
        Ingredient ingredientItalia2 = italiaFactory.crearIngredient();
        Plat platItalia2 = pizzaFactory.crearPlat(ingredientItalia2);

        Client clientToni = new Client("Toni", "pizza");
        Client clientMaria = new Client("Maria", "sashimi");
        Client clientJoan = new Client("Paco", "pizza", "Tomaquet");

        restaurant.afegirComanda(platItalia1);
        restaurant.afegirComanda(platJapo);
        restaurant.afegirComanda(platItalia2);

        cuinerItalia1.cuinar(restaurant.getNom());
        clientToni.consumirPlat(platItalia1);

        cuinerJapo.cuinar(restaurant.getNom());
        clientMaria.consumirPlat(platJapo);

        cuinerItalia2.cuinar(restaurant.getNom());
        clientJoan.consumirPlat(platItalia2);

        System.out.println("\nCAMBIO DE AMBIENTE");

        AmbientBase ambientNou = new AmbientBase();
        AmbTempesta tempestaSola = new AmbTempesta(ambientNou);
        restaurant.setAmbient(tempestaSola);

        System.out.println("Modificador desgaste nuevo: " + restaurant.getModificadorDesgastCuiner());
        System.out.println("\nSEGUNDA RONDA");

        Cuiner cuinerItalia3 = italiaFactory.crearCuiner("Giulia", 1);
        Ingredient ingredientItalia3 = italiaFactory.crearIngredient();
        Plat platItalia3 = pizzaFactory.crearPlat(ingredientItalia3);

        Cuiner cuinerJapo2 = japoFactory.crearCuiner("Yuki", 1);
        Ingredient ingredientJapo2 = japoFactory.crearIngredient();
        Plat platJapo2 = sushiFactory.crearPlat(ingredientJapo2);

        Client clientAnna = new Client("Anna", "pizza");
        Client clientPau = new Client("Pau", "sashimi");

        restaurant.afegirComanda(platItalia3);
        restaurant.afegirComanda(platJapo2);

        cuinerItalia3.cuinar(restaurant.getNom());
        clientAnna.consumirPlat(platItalia3);

        cuinerJapo2.cuinar(restaurant.getNom());
        clientPau.consumirPlat(platJapo2);

        restaurant.iniciarRentatAutomatic();
    }
}
