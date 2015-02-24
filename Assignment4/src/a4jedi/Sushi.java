package a4jedi;

public class Sushi extends FoodImpl{
	private static final int WEIGHT_PER_UNIT = 3;
	private static final int PRICE_PER_UNIT = 15;
	private static final int FILL = 15;
	private static final int EXPIRATION = 2;
	private static final String NAME = "sushi";
	
	//Constructor
	public Sushi(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, FILL, EXPIRATION);	
	}
	
}
