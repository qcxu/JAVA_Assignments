package a4adept;

public class Brogrammer extends PersonImpl{
	
	// Constructor
	public Brogrammer(String name) {
		
		super(Status.HEALTHY, (int) Math.round(Math.random() * 70) + 110, 
				(int) Math.round(Math.random() * 30) + 10, name);
		
	}
	
	// Status recover to health
	@Override
	public void special() {
		this.setStatus(Status.HEALTHY);
	}
	
}
