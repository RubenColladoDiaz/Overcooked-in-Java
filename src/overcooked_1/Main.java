package overcooked_1;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
       restaurant.obrirRestaurant();
       
       Plat macarrons = new Plat("macarrons");
       Plat espaguetis = new Plat("espaguetis");
       Plat raviolis = new Plat("raviolis");
       Plat hamburguesa = new Plat("hamburguesa");
       Plat pa = new Plat("pa");
       
       Cuiner marc = new Cuiner("Marc", 0);
       Cuiner ana = new Cuiner("Ana", 1);
       
       restaurant.afegirComanda(macarrons);
       restaurant.afegirComanda(espaguetis);
       restaurant.afegirComanda(raviolis);
       restaurant.afegirComanda(hamburguesa);
       restaurant.afegirComanda(pa);
       
       marc.cuinar();
       marc.cuinar();
       marc.cuinar();
       ana.cuinar();
       ana.cuinar();

       restaurant.iniciarRentatAutomatic();
	}
}
