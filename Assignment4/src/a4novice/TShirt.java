package a4novice;

public class TShirt extends ClothingImpl{
	private static final int WEIGHT_PER_UNIT = 1;
	private static final int PRICE_PER_UNIT = 20;
	private static final int WARMTH = 1;
	private static final String NAME = "t-shirt";
	
	//Constructor
	public TShirt(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, WARMTH);	
	}
}

