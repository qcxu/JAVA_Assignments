package a5novice;

import supplies.*;

public class Main {

	public static void main(String[] args) {
		Supplies ramen = new Ramen(2);
		Supplies burrito = new Burrito(3);
		Supplies coffee = new Coffee(1);
		Supplies red = new RedBison(1);
		Supplies fleece = new Fleece(4);
		Supplies tshirt = new TShirt(5);
		Supplies buttonUp = new ButtonUp(2);
		
		Knapsack k = new KnapsackImpl();
		k.add(ramen);
		k.add(burrito);
		k.add(coffee);
		k.add(red);
		k.add(fleece);
		k.add(tshirt);
		k.add(buttonUp);
		int weight = k.getTotalWeight();
		System.out.println(weight);
		Supplies[] supplies = k.getSupplies();
		for (int i=0; i<supplies.length; i++) {
			System.out.println(supplies[i].toString());
		}
		Food[] esupplies = k.getEdibleSupplies();
		for (int i=0; i<esupplies.length; i++) {
			System.out.println(esupplies[i].toString());
		}

	}

}
