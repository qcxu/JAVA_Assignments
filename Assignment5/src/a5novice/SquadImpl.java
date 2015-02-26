package a5novice;

import person.Person;

public class SquadImpl implements Squad{

	private int num_players;
	private Knapsack knapsack;
	private Person[] players;
	
	public SquadImpl(int num_players, Knapsack knapsack) {
		if (num_players < 1 || knapsack == null) {
			throw new IllegalArgumentException("num_players or knapsack illegal.");
		}
		this.num_players = num_players;
		this.knapsack = knapsack;
		for (int i=0; i<num_players; i++) {
			players[i] = null;
		}
		
	}
	
	@Override
	public int getNumPlayers() {
		return this.num_players;
	}

	@Override
	public Person getPlayer(int num) {
		if (num < 0 || num >= this.num_players) {
			throw new IllegalArgumentException("num is out of range.");
		}
		return players[num];
	}

	@Override
	public void setPlayer(int num, Person player) {
		if (num < 0 || num >= this.num_players) {
			throw new IllegalArgumentException("num is out of range.");
		}
		players[num] = player;
		return;
	}

	@Override
	public Knapsack getKnapsack() {
		return this.knapsack;
	}
	
}
