package a4novice;

public class Main {
	public static void main(String[] args) {
	Supplies b = new BisonJerky(-5);
	System.out.println(b.getName());
	System.out.println(b.getAmount());
	b.setAmount(4);
	System.out.println(b.getPoundsPerItem());
	System.out.println(b.getPricePerItem());
	System.out.println(b.getTotalWeight());
	if (b instanceof FoodImpl) {
		System.out.println("true");
	}
	System.out.println(b.getAmount());
	}
}
