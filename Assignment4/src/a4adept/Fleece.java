package a4adept;

public class Fleece extends ClothingImpl{
	private static final int WEIGHT_PER_UNIT = 10;
	private static final int PRICE_PER_UNIT = 100;
	private static final Warmth WARMTH = Warmth.WARM;
	private static final String NAME = "fleece";
	
	//Constructor
	public Fleece(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, WARMTH);	
	}

}
