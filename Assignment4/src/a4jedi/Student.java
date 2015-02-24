package a4jedi;

public class Student extends PersonImpl{
	
	public Student(String name) {
		
		super(Status.HEALTHY, (int) Math.round(Math.random() * 40) + 80,  
				(int) Math.round(Math.random() * 40) + 30, name);
		
	}
	
	@Override
	public void special() {
		this.java_skill += 1;
		
	}
}
