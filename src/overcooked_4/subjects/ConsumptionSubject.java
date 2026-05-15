package overcooked_4.subjects;

import overcooked_3.Plat;
import overcooked_4.observers.ConsumptionObserver;

public interface ConsumptionSubject {
	   void registerConsumptionObserver(ConsumptionObserver observer);
	   void removeConsumptionObserver(ConsumptionObserver observer);
	   void notifyConsumptionObservers(Plat plat, boolean paid, double amount);
}