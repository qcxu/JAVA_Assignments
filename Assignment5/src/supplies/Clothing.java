package supplies;

public interface Clothing extends Supplies{
	
	Warmth getWarmth();
	
	public enum Warmth {
		// TODO Status fields
		LIGHT, MEDIUM, WARM
	}
	
}