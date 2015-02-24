package a4jedi;

public class Coffee extends PowerUpImpl{
	private static final int WEIGHT_PER_UNIT = 1;
	private static final int PRICE_PER_UNIT = 5;
	private static final int FILL = 0;
	private static final int DURATION = 1;
	private static final int EXPIRATION = 100;
	private static final String NAME = "coffee";
	
	//Constructor
	public Coffee(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, FILL, 
				EXPIRATION, DURATION);	
	}
	
}
