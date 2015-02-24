package a4adept;

public class BisonJerky extends FoodImpl{
	
	private static final int WEIGHT_PER_UNIT = 5;
	private static final int PRICE_PER_UNIT = 10;
	private static final int FILL = 6;
	private static final int EXPIRATION = 40;
	private static final String NAME = "bison jerky";
	
	//Constructor
	public BisonJerky(int amount) {
		super(amount, WEIGHT_PER_UNIT, PRICE_PER_UNIT, NAME, FILL, EXPIRATION);	
	}

}
