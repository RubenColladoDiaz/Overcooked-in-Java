package overcooked_4.observers;

import overcooked_3.Plat;

public interface OrderObserver {
	void updateOrder(Plat plat, String clientName);
}