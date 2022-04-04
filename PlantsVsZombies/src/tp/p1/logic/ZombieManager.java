package tp.p1.logic;

import java.util.Random;

public class ZombieManager {
	private int zombiesLeftToAppear;
	private double frequence;
	private Random r;
	
	public ZombieManager(Level level, Random r) {
		this.r = r;
		
		switch(level) {
		case EASY:
			zombiesLeftToAppear = 3;
			frequence = 0.1;
			break;
		case HARD:
			zombiesLeftToAppear = 5;
			frequence = 0.2;
			break;
		case INSANE:
			zombiesLeftToAppear = 10;
			frequence = 0.3;
			break;
		default:
		}
	}
	
	public boolean isZombieAdded() {
		boolean ok = false;
		if (zombiesLeftToAppear > 0 && r.nextInt(10) < frequence * 10) {
			zombiesLeftToAppear--;
			ok = true;
		}
		return ok;
	}
	
	public int RandomTile() {
		return r.nextInt(4);
	}
	
	public int getZombiesLeftToAppear() {
		return zombiesLeftToAppear;
	}
	
	public void setZombiesLeftToAppear(int zombies) {
		zombiesLeftToAppear = zombies;
	}
}
