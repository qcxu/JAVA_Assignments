 package a4adept;


public class FoodImpl extends SuppliesImpl implements Food{
	private int fill;
	private int expiration;
	
	//Constructor
	protected FoodImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name, int fill, int expiration) {
		super(amount, weight_per_unit, price_per_unit, name);
		this.fill = fill;
		this.expiration = expiration;
	}
	
	// Consume food and decrease amount by 1
	public void consume() throws NoFoodException {
		if (this.getAmount() == 0) {
			throw new NoFoodException();
		} else {
			setAmount(this.getAmount()-1);
		}
		return;
	}
	
	// Get the number of days till expiration
	public int getDaysTillExpiration() {
		return this.expiration;
	}
	
	// Decrease food expiration day by 1
	public void age() throws FoodExpiredException {
		if (this.getDaysTillExpiration() <= 0) {
			throw new FoodExpiredException();
		} else {
			this.expiration -= 1;
			if (this.expiration == 0) {
				throw new FoodExpiredException();
			}
		}
	}
	
	// Get the fill of the food
	public int getFill() {
		return this.fill;
	}

	
}
