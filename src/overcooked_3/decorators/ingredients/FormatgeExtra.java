package overcooked_3.decorators.ingredients;

import overcooked_3.Plat;
import overcooked_3.decorator.PlatDecorator;

public class FormatgeExtra extends PlatDecorator{
	
	public FormatgeExtra(Plat platDecorat) {
		super(platDecorat);
	}
	
	// modifica descripció
	@Override
	public String getNom() {
		return platDecorat.getNom() + " amb formatge extra";
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