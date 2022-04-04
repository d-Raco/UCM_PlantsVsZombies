package tp.p1.logic.objects;

import tp.p1.logic.Zombie;

public class Buckethead extends Zombie{
	public Buckethead() {
		super("[B]uckethead zombie", 4, 1, 8);
	}
	
	public void update() {
		if (cycleCounter == speed - 1){
			 if(game.emptyTile(x, y - 1))
				 y--;
			 else
				 game.ZombieZombs(x, y, harm);
			 cycleCounter = 0;
		}
		else
			cycleCounter++;
	}
	
	public String toString() {
		return "B[" + resistence + "]";
	}
	
	public String toDebugString() {
		return "B[l:" + resistence + ",x:" + x + ",y:" + y + ",t:" + (speed - cycleCounter - 1) + "]"; 
	}
	
	public String toStringFile() {
		return "b:" + resistence + ":" + x + ":" + y + ":" + (speed - cycleCounter - 1);
	}
}
