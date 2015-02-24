package a4jedi;

public interface Person {
	
	int getCurrentHP();
	int getMaxHP();
	int getSkill();
	
	void eat(Food food) throws NoFoodException;
	Person.Status getStatus();
	void setStatus(Person.Status new_status);
	String getName();
	
	void special();
	
	public enum Status {
		// TODO Status fields
		HEALTHY, NOROVIRUS, DYSENTERY
	}
}