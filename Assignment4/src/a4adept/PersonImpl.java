package a4adept;

public class PersonImpl implements Person{

	private Status status;
	protected int current_hp;
	protected int max_hp;
	protected int java_skill;
	private String name;
	
	// Constructor
	protected PersonImpl(Status status, int max_hp, 
			int java_skill, String name) {
		this.status = status;
		this.max_hp = max_hp;
		this.current_hp = this.max_hp;
		this.java_skill = java_skill;
		// Check whether name is null
		if (name == null) {
			throw new IllegalArgumentException();
		} else {
			this.name = name;
		}
	}
	
	// Get current HP
	@Override
	public int getCurrentHP() {
		return this.current_hp;
	}

	// Get max HP
	@Override
	public int getMaxHP() {
		return this.max_hp;
	}

	// Get java skill level
	@Override
	public int getSkill() {
		return this.java_skill;
	}

	// Eat food
	@Override
	public void eat(Food food) throws NoFoodException {
		// Check whether food is null
		if (food == null) {
			throw new IllegalArgumentException("Food is null");
		} else {
			// Consume food and increase HP
			food.consume();
			if (this.max_hp <= (this.current_hp + food.getFill())) {
				this.current_hp = this.max_hp;
			} else if (this.current_hp + food.getFill() <= 0) {
				this.current_hp = 0;
			} else {
				this.current_hp += food.getFill();
			}
		}
		
	}

	// Get person's health status
	@Override
	public Status getStatus() {
		return this.status;
	}

	// Set person's health status
	@Override
	public void setStatus(Status new_status) {
		this.status = new_status;
	}

	// Get perons' name
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void special() {
	}


}
