package overcooked_3;

import overcooked_3.decorators.ambient.AmbTempesta;
import overcooked_3.decorators.ambient.SobreLava;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance("Restaurant");
        restaurant.setAmbient(new SobreLava(restaurant));
        restaurant.setAmbient(new AmbTempesta(restaurant));
        restaurant.obrirRestaurant();
    }
}
