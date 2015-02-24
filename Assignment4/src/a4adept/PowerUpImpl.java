package a4adept;

public class PowerUpImpl extends FoodImpl implements PowerUp{

	private int duration;
	
	protected PowerUpImpl(int amount, int weight_per_unit, 
			int price_per_unit, String name, int fill, 
			int expiration, int duration) {
		super(amount, weight_per_unit, price_per_unit, name, fill, expiration);
		this.duration = duration;
	}
	
	public int getDuration() {
		return this.duration;
	}
}
