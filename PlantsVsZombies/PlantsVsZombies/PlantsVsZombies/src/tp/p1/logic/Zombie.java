package tp.p1.logic;

abstract public class Zombie extends GameObject {
	protected int resistence, speed,  harm, cycleCounter;
	protected String name;
	
	public Zombie(String name, int speed, int harm, int resistence) {
		this.name = name;
		this.speed = speed;
		this.harm = harm;
		this.resistence = resistence;
		cycleCounter = 0;
	}
	
	public String getInfo() {
		return name + ": Speed: "  +  speed + " Harm: " +  harm + " Resistence: " +  resistence;
	}
	
	public void Attacked(int damage) {
		resistence -= damage;
		if (resistence < 0)
			resistence = 0;
	}
	
	public int getNumOfLives() {
		return resistence;
	}
	
	public void setCycle(int cycles) {
		cycleCounter = cycles;
	}
	
	public void setLives(int lives) {
		resistence = lives;
	}
}

