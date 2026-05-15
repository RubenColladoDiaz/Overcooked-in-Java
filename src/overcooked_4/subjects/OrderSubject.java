package overcooked_4.subjects;

import overcooked_3.Plat;
import overcooked_4.observers.OrderObserver;

public interface OrderSubject {
	   void registerOrderObserver(OrderObserver observer);
	   void removeOrderObserver(OrderObserver observer);
	   void notifyOrderObservers(Plat plat);
}