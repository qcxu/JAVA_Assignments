package person;

import supplies.Food;
import supplies.NoFoodException;

public abstract class PersonImpl implements Person{

	private Status status;
	protected int current_hp;
	protected int max_hp;
	protected int java_skill;
	private String name;
	
	public PersonImpl(Status status, int max_hp, 
			int java_skill, String name) {
		this.status = status;
		this.max_hp = max_hp;
		this.current_hp = this.max_hp;
		this.java_skill = java_skill;
		if (name == null) {
			throw new IllegalArgumentException();
		} else {
			this.name = name;
		}
	}
	
	@Override
	public int getCurrentHP() {
		// TODO Auto-generated method stub
		return this.current_hp;
	}

	@Override
	public int getMaxHP() {
		// TODO Auto-generated method stub
		return this.max_hp;
	}

	@Override
	public int getSkill() {
		// TODO Auto-generated method stub
		return this.java_skill;
	}

	@Override
	public void eat(Food food) throws NoFoodException {
		if (food == null) {
			throw new IllegalArgumentException("Food is null");
		} else {
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

	@Override
	public Status getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}

	@Override
	public void setStatus(Status new_status) {
		// TODO Auto-generated method stub
		this.status = new_status;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
