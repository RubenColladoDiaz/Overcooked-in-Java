package overcooked_3.decorators.ingredients;

import overcooked_3.Plat;
import overcooked_3.decorator.PlatDecorator;

public class Pepperoni extends PlatDecorator {

    public Pepperoni(Plat plat) {
        super(plat);
        // TODO Auto-generated constructor stub
    }

    // modifica descripció
    @Override
    public String getNom() {
        return platDecorat.getNom() + " amb pepperoni";
    }

    // afegeix 1 segon extra
    @Override
    public double getTempsPreparacio() {
        return platDecorat.getTempsPreparacio() + 1.0;
    }

    // afegeix 1.5 euros extra
    @Override
    public double getCost() {
        return platDecorat.getCost() + 1.5;
    }

}
