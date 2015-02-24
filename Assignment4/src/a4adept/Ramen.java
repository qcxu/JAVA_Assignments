package a4adept;

public class Ramen extends FoodImpl{
	private static final int WEIGHT_PER_UNIT = 1;
	private static final int PRICE_PER_UNIT = 1;
	private static final int FILL = 1;
	private static final int EXPIRATION = 1000;
	private static final String NAME = "ramen noodles";
	
	//Constructor
	public Ramen(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, FILL, EXPIRATION);	
	}
	
}
