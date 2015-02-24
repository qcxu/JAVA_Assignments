package a4adept;

public interface Clothing extends Supplies{
	
	// Return the status of warmth
	Warmth getWarmth();
	
	//Warmth status fields
	public enum Warmth {
		LIGHT, MEDIUM, WARM
	}
	
}