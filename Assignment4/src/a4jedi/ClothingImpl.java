package a4jedi;

public abstract class ClothingImpl extends SuppliesImpl implements Clothing{
	private Warmth warmth;
	
	public ClothingImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name, Warmth warmth) {
		super(amount, weight_per_unit, price_per_unit, name);
		this.warmth = warmth;
	}
	
	public Warmth getWarmth() {
		return this.warmth;
	}
	
	
	
}
