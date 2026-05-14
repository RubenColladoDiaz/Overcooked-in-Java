package overcooked_3.decorators.ambient;

import overcooked_3.DecoradorAmbient;

public class SobreLava implements DecoradorAmbient {
	private DecoradorAmbient ambientDecorat;

	public SobreLava(DecoradorAmbient ambient) {
		this.ambientDecorat = ambient;
	}

	// doble desgast
	@Override
	public double getModificadorDesgastCuiner() {
		return ambientDecorat.getModificadorDesgastCuiner() * 2.0;
	}

	// 20% menys paciència
	@Override
	public double getModificadorPacienciaClient() {
		return ambientDecorat.getModificadorPacienciaClient() * 0.8;
	}
}
