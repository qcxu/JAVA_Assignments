package a4adept;

public class SuppliesImpl implements Supplies{
	private int amount;
	private int weight_per_unit;
	private int price_per_unit;
	private String name;
	
	//Constructor
	protected SuppliesImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name) {
		// Check whether the amount is greater than or equal to 0
		if (amount < 0 ) {
			throw new IllegalArgumentException();
		} else {
			this.amount = amount;
		}
		this.weight_per_unit = weight_per_unit;
		this.price_per_unit = price_per_unit;
		this.name = name;
	}
	
	// Get amount of food
	public int getAmount() {
		return this.amount;
	}
	
	// Set amount of food
	public void setAmount(int amount) {
		if (amount < 0 ) {
			throw new IllegalArgumentException();
		} else {
			this.amount = amount;
		}
		return;
	}
	
	// Get weight per unit
	public int getPoundsPerItem() {
		return this.weight_per_unit;
	}
	
	// Get total weight
	public int getTotalWeight() {
		return this.weight_per_unit * this.amount;
	}
	
	// Get price per unit
	public int getPricePerItem() {
		return this.price_per_unit;
	}
	
	// Get food name
	public String getName() {
		return this.name;
	}
}
