package a4novice;

public class ClothingImpl extends SuppliesImpl implements Clothing{
	private int warmth;
	
	protected ClothingImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name, int warmth) {
		super(amount, weight_per_unit, price_per_unit, name);
		if (warmth == 1 || warmth == 2 || warmth == 3) {
			this.warmth = warmth;
		} else {
			throw new IllegalArgumentException("warmth is illegal");
		}
		
	}
	
	public int getWarmth() {
		return this.warmth;
	}
	
	
	
}
