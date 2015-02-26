package a5novice;

import supplies.*;

public class KnapsackImpl implements Knapsack {

	private FoodPouch foodPorch;
	private PowerUpPouch powerUpPorch;
	private ClothingPouch clothingPorch;
	
	public KnapsackImpl(){
		foodPorch = new FoodPouch();
		powerUpPorch = new PowerUpPouch();
		clothingPorch = new ClothingPouch();
	}
	
	@Override
	public void add(Food item) {
		if (!(item instanceof supplies.PowerUp)) {
			this.foodPorch.add(item);	
		} else {
			this.powerUpPorch.add(item);
		}
		return;	
	}

	@Override
	public void add(PowerUp item) {
		this.powerUpPorch.add(item);
		return;
	}

	@Override
	public void add(Clothing item) {
		this.clothingPorch.add(item);
		return;
	}

	@Override
	public void add(Supplies item) {
		if (item instanceof PowerUp) {
			this.powerUpPorch.add(item);
		} else if (item instanceof Food) {
			this.foodPorch.add(item);
		} else {
			this.clothingPorch.add(item);
		}
		return;
		
	}

	@Override
	public int getTotalWeight() {
		
		return this.foodPorch.getTotalWeight() 
				+ this.powerUpPorch.getTotalWeight()
				+ this.clothingPorch.getTotalWeight();
	}

	@Override
	public Supplies[] getSupplies() {
		int total_qty = this.foodPorch.getItems().length
						+ this.powerUpPorch.getItems().length 
						+ this.clothingPorch.getItems().length;
		Supplies[] total_supplies = new Supplies[total_qty];
		System.arraycopy(this.foodPorch.getItems(), 0, total_supplies, 0, 
				this.foodPorch.getItems().length);
		System.arraycopy(this.powerUpPorch.getItems(), 0, total_supplies, 
				this.foodPorch.getItems().length, this.powerUpPorch.getItems().length);
		System.arraycopy(this.clothingPorch.getItems(), 0, total_supplies, 
				this.foodPorch.getItems().length + this.powerUpPorch.getItems().length, 
				this.clothingPorch.getItems().length);
		return total_supplies;
	}

	@Override
	public Food[] getEdibleSupplies() {
		int total_edible_qty = this.foodPorch.getItems().length
				+ this.powerUpPorch.getItems().length;
		Food[] total_edible_supplies = new Food[total_edible_qty];
		System.arraycopy(this.foodPorch.getItems(), 0, total_edible_supplies, 0, 
				this.foodPorch.getItems().length);
		System.arraycopy(this.powerUpPorch.getItems(), 0, total_edible_supplies, 
				this.foodPorch.getItems().length, this.powerUpPorch.getItems().length);
		return total_edible_supplies;
	}

}
