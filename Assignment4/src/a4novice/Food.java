package a4novice;

public interface Food extends Supplies{
	
	void consume() throws NoFoodException;
	
	int getDaysTillExpiration();
	
	void age() throws FoodExpiredException;
	
	int getFill();

}