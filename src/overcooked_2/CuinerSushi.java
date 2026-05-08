package overcooked_2;

public class CuinerSushi extends Cuiner {

	public CuinerSushi(String nom, int sexe) {
		super(nom, sexe);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();
		
		if(!plat.getNom().toLowerCase().contains("sashimi")) {
			System.out.println(this.getNom() + " es un cuiner de sushi. No pot cuinar res que no sigui sushi.");
			return;
		}
		
	    if (getSexe() == 0) {
	    	System.out.println("El cuiner de sushi " + getNom() + " està cuinant: " + plat);
	    } else {
	    	System.out.println("La cuinera de sushi " + getNom() + " està cuinant: " + plat);
	    }
	    System.out.println(plat+" cuinat i consumit.");
	    Restaurant.getInstance(nomRestaurant).afegirPlatBrut(plat);
	}
}