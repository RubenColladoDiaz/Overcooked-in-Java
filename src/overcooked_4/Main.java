package overcooked_4;

import overcooked_2.abstractFactory.ItaliaFactory;
import overcooked_2.abstractFactory.JapoFactory;
import overcooked_2.abstractFactory.RestaurantFactory;
import overcooked_3.AmbientBase;
import overcooked_3.decorators.ambient.AmbTempesta;
import overcooked_3.decorators.ambient.SobreLava;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurant restaurant = Restaurant.getInstance("Restaurant");
		restaurant.obrirRestaurant();
		
		AmbientBase ambientBase = new AmbientBase();
		SobreLava sobreLava = new SobreLava(ambientBase);
		AmbTempesta ambTempesta = new AmbTempesta(sobreLava);
		restaurant.setAmbient(ambTempesta);
		
		Client client1 = new Client("Pepe", "pizza", "formatge");
		Client client2 = new Client("Antonio", "pizza");
		
		RestaurantFactory italiaFactory = new ItaliaFactory();
		RestaurantFactory japoFactory = new JapoFactory();
	}

}
