package a5novice;

import java.util.List;
import java.util.ArrayList;

import supplies.Food;
import supplies.Supplies;

public class FoodPouch implements Pouch {

	private List<Supplies> items;
	
	public FoodPouch() {
		items = new ArrayList<Supplies>();
	}
	
	@Override
	public void add(Supplies item) {
		if (!(item instanceof supplies.Food)) {
			throw new IllegalArgumentException("Only food should go in a food pouch.");
		} else if (item instanceof supplies.PowerUp) {
			throw new IllegalArgumentException("Only food should go in a food pouch.");
		}
		
		items.add(item);
		return;
	}
	
	
	
	// Complete this class to implement the rest of the Pouch interface
	@Override
	public int getTotalWeight() {
		int total_weight = 0;
		for (Supplies item : items) {
			total_weight += item.getTotalWeight();
		}
		return total_weight;
	}
	
	public Supplies[] getItems() {
		int qty = items.size();
		Supplies[] supplies = new Supplies[qty];
		int idx = 0;
		for (Supplies item : items) {
			supplies[idx] = item;
			idx += 1;
		}
		return supplies;	
	}
}
