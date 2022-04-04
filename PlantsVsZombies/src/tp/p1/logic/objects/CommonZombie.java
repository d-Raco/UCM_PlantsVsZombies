package tp.p1.logic.objects;

import tp.p1.logic.Zombie;

public class CommonZombie extends Zombie{
	public CommonZombie() {
		super("Common [Z]ombie", 2, 1, 5);
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
		return "Z[" + resistence + "]";
	}
	
	public String toDebugString() {
		return "Z[l:" + resistence + ",x:" + x + ",y:" + y + ",t:" + (speed - cycleCounter - 1) + "]"; 
	}
	
	public String toStringFile() {
		return "z:" + resistence + ":" + x + ":" + y + ":" + (speed - cycleCounter - 1);
	}
}
