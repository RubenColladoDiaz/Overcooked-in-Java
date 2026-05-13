package overcooked_3;

public class AmbientBase implements DecoradorAmbient{
	@Override
	public double getModificadorDesgastCuiner() {
		return 1.0;
	}
	@Override
	public double getModificadorPacienciaClient() {
		return 1.0;
	}
}
