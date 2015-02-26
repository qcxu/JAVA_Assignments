 package supplies;


public abstract class FoodImpl extends SuppliesImpl implements Food{
	private int fill;
	private int expiration;
	
	//Constructor
	public FoodImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name, int fill, int expiration) {
		super(amount, weight_per_unit, price_per_unit, name);
		this.fill = fill;
		this.expiration = expiration;
	}
	
	public void consume() throws NoFoodException {
		if (this.getAmount() == 0) {
			throw new NoFoodException();
		} else {
			setAmount(this.getAmount()-1);
		}
		return;
	}
	
	
	public int getDaysTillExpiration() {
		return this.expiration;
	}
	
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
	
	public int getFill() {
		return this.fill;
	}

	
}
