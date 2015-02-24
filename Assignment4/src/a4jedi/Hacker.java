package a4jedi;

public class Hacker extends PersonImpl{
	
	private boolean beast_mode;
	
	public Hacker(String name) {
		
		super(Status.HEALTHY, (int) Math.round(Math.random() * 40) + 60, 
				(int) Math.round(Math.random() * 40) + 60, name);
		this.beast_mode = false;
		
	}
	
	@Override
	public void eat(Food food) throws NoFoodException {
		if (food == null) {
			throw new IllegalArgumentException("Food is null");
		} else {
			food.consume();
			if (this.max_hp <= (this.current_hp - food.getFill())) {
				this.current_hp = this.max_hp;
			} else if (this.current_hp - food.getFill() <= 0) {
				this.current_hp = 0;
			} else {
				this.current_hp -= food.getFill();
			}
			
		}
		
	}
	
	@Override
	public void special() {
		this.beast_mode = true;
	}
	
	public boolean getBeastModeStatus() {
		return this.beast_mode;
	}

}
