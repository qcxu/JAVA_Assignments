package a4jedi;

public class ButtonUp extends ClothingImpl{
	private static final int WEIGHT_PER_UNIT = 5;
	private static final int PRICE_PER_UNIT = 50;
	private static final Warmth WARMTH = Warmth.MEDIUM;
	private static final String NAME = "button-up";
	
	//Constructor
	public ButtonUp(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, WARMTH);	
	}
	
	
}
