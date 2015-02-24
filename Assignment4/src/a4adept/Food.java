package a4adept;

public interface Food extends Supplies{
	
	// Consume food and decrease amount by 1
	void consume() throws NoFoodException;
	
	// Get the number of days till expiration
	int getDaysTillExpiration();
	
	// Decrease food expiration day by 1
	void age() throws FoodExpiredException;
	
	// Get the fill of the food
	int getFill();

}