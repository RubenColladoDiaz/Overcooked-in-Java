package overcooked_3.decorators.ambient;

import overcooked_3.DecoradorAmbient;

public class AmbTempesta implements DecoradorAmbient {

    private DecoradorAmbient ambientDecorat;

    public AmbTempesta(DecoradorAmbient ambientDecorat) {
        this.ambientDecorat = ambientDecorat;
    }

    // 10% de desgast
    @Override
    public double getModificadorDesgastCuiner() {
        return ambientDecorat.getModificadorDesgastCuiner() * 1.10;
    }

    // 10% menys paciència
    @Override
    public double getModificadorPacienciaClient() {
        return ambientDecorat.getModificadorPacienciaClient() * 0.1;
    }

}
