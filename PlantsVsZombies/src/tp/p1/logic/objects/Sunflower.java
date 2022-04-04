package tp.p1.logic.objects;

import tp.p1.logic.Plant;

public class Sunflower extends Plant{
	public Sunflower() {
		super("[S]unflower", 20, 0, 2, 1);
	}
	
	public void update() {
		if (cycleCounter == cycles - 1) {
			 game.setSuncoins(getCost());
			 cycleCounter = 0;
		}
		else
			cycleCounter++;
	}
	
	public String toString() {
		return "S[" + numoflives + "]";
	}
	
	public String toDebugString() {
		return "S[l:" + numoflives + ",x:" + x + ",y:" + y + ",t:" + (cycles - cycleCounter - 1) + "]"; 
	}
	
	public String toStringFile() {
		return "s:" + numoflives + ":" + x + ":" + y + ":" + (cycles - cycleCounter - 1);
	}
}
