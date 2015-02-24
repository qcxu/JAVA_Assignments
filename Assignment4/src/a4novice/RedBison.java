package a4novice;

public class RedBison extends PowerUpImpl{
	private static final int WEIGHT_PER_UNIT = 2;
	private static final int PRICE_PER_UNIT = 7;
	private static final int FILL = -10;
	private static final int DURATION = 5;
	private static final int EXPIRATION = 100;
	private static final String NAME = "Red Bison";
	
	//Constructor
	public RedBison(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, FILL,
				EXPIRATION, DURATION);	
	}
	
}
