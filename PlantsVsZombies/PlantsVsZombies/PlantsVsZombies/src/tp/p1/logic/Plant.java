package tp.p1.logic;

abstract public class Plant extends GameObject {
	protected int numoflives, cycles, harm, cycleCounter;
	private int cost;
	protected String name;
	
	public Plant(String name, int cost, int harm, int cycles, int numoflives) {
		this.name = name;
		this.cost = cost;
		this.harm = harm;
		this.cycles = cycles;
		this.numoflives = numoflives;
		cycleCounter = 0;
	}
	
	public String getInfo() {
		return name + ": Cost: "  +  cost + " suncoins  Harm: " +  harm;
	}
	
	public void Attacked(int damage) {
		numoflives -= damage;
	}
	
	public int getNumOfLives() {
		return numoflives;
	}

	public int getCost() {
		return cost;
	}
	
	public void setCycle(int cycles) {
		cycleCounter = cycles;
	}
	
	public void setLives(int lives) {
		numoflives = lives;
	}
}
