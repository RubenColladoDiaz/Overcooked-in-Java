package overcooked_3.decorator;

import overcooked_3.Plat;

public abstract class PlatDecorator implements Plat {
	
	protected Plat platDecorat;
	
	public PlatDecorator(Plat plat) {
		this.platDecorat = plat;
	}
	@Override
	public String getNom() {
		return platDecorat.getNom();
	}
	@Override
	public double getTempsPreparacio() {
		return platDecorat.getTempsPreparacio();
	}
	@Override
	public double getCost() {
		return platDecorat.getCost();
	}
	@Override
	public String toString() {
		return "PlatDecorator [platDecorat=" + platDecorat + "]";
	}
}
