package overcooked_4.observers;

import overcooked_3.Plat;

public interface ConsumptionObserver {
	   void updateConsumption(Plat plat, String clientName, boolean paid, double amount);
}