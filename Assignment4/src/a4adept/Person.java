package a4adept;

public interface Person {
	
	// Get current HP
	int getCurrentHP();
	
	// Get the max HP
	int getMaxHP();
	
	// Get the java skill level
	int getSkill();
	
	// Eat food, consume food and increase HP
	void eat(Food food) throws NoFoodException;
	
	// Get the person's health status
	Person.Status getStatus();
	
	// Set the person's health status
	void setStatus(Person.Status new_status);
	
	// Get the person's name
	String getName();
	
	// Apply special skill
	void special();
	
	// Health status fields
	public enum Status {
		HEALTHY, NOROVIRUS, DYSENTERY
	}
}