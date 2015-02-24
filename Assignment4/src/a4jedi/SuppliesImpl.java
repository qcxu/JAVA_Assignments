package a4jedi;

public abstract class SuppliesImpl implements Supplies{
	private int amount;
	private int weight_per_unit;
	private int price_per_unit;
	private String name;
	
	//Constructor
	public SuppliesImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name) {
		if (amount < 0 ) {
			throw new IllegalArgumentException();
		} else {
			this.amount = amount;
		}
		this.weight_per_unit = weight_per_unit;
		this.price_per_unit = price_per_unit;
		this.name = name;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		if (amount < 0 ) {
			throw new IllegalArgumentException();
		} else {
			this.amount = amount;
		}
		return;
	}
	
	public int getPoundsPerItem() {
		return this.weight_per_unit;
	}
	
	public int getTotalWeight() {
		return this.weight_per_unit * this.amount;
	}
	
	public int getPricePerItem() {
		return this.price_per_unit;
	}
	
	public String getName() {
		return this.name;
	}
}
