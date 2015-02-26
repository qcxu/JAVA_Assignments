package a5novice;

import java.util.List;
import java.util.ArrayList;

import supplies.Supplies;

public class ClothingPouch implements Pouch {

	private List<Supplies> items;
	
	public ClothingPouch() {
		items = new ArrayList<Supplies>();
	}
	
	@Override
	public void add(Supplies item) {
		if (!(item instanceof supplies.Clothing)) {
			throw new IllegalArgumentException("Only clothing should go in a clothing pouch.");
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
	
	@Override
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
