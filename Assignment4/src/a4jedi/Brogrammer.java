package a4jedi;

public class Brogrammer extends PersonImpl{
	
	public Brogrammer(String name) {
		
		super(Status.HEALTHY, (int) Math.round(Math.random() * 70) + 110, 
				(int) Math.round(Math.random() * 30) + 10, name);
		
	}
	
	@Override
	public void special() {
		this.setStatus(Status.HEALTHY);
	}
	
}
