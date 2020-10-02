package tp.p1.logic.objects;

import tp.p1.logic.Zombie;

public class Sporty extends Zombie{
	public Sporty() {
		super("Spo[R]ty zombie", 1, 1, 2);
	}
	
	public void update() {
		 if (game.emptyTile(x, y - 1))
			 y--;
		 else
			 game.ZombieZombs(x, y, harm);
	}
	
	public String toString() {
		return "R[" + resistence + "]";
	}
	
	public String toDebugString() {
		return "R[l:" + resistence + ",x:" + x + ",y:" + y + ",t:" + cycleCounter + "]"; 
	}
	
	public String toStringFile() {
		return "r:" + resistence + ":" + x + ":" + y + ":" + cycleCounter;
	}
}
