package a4novice;

public class Burrito extends FoodImpl{
	
	private static final int WEIGHT_PER_UNIT = 5;
	private static final int PRICE_PER_UNIT = 7;
	private static final int FILL = 10;
	private static final int EXPIRATION = 5;
	private static final String NAME = "burrito";
	
	//Constructor
	public Burrito(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, FILL, EXPIRATION);	
	}
}