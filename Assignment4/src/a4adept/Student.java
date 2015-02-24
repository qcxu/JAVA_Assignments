package a4adept;

public class Student extends PersonImpl{
	
	// Constructor
	public Student(String name) {
		
		super(Status.HEALTHY, (int) Math.round(Math.random() * 40) + 80,  
				(int) Math.round(Math.random() * 40) + 30, name);
		
	}
	
	// java skill level increases by 1
	@Override
	public void special() {
		this.java_skill += 1;
		
	}
}
