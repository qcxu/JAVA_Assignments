package a4adept;

public class ClothingImpl extends SuppliesImpl implements Clothing{
	private Warmth warmth;
	
	// Constructor
	protected ClothingImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name, Warmth warmth) {
		super(amount, weight_per_unit, price_per_unit, name);
		this.warmth = warmth;
	}
	
	// Return the status of warmth
	public Warmth getWarmth() {
		return this.warmth;
	}
	
	
	
}
