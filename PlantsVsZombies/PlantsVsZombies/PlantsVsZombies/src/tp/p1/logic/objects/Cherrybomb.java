package tp.p1.logic.objects;

import tp.p1.logic.Plant;

public class Cherrybomb extends Plant{
	public Cherrybomb() {
		super("[C]herrybomb", 50, 10, 2, 2);
	}
	
	public void update() {
		if (cycleCounter == cycles - 1) {
			 game.explode(x, y, harm);
			 Attacked(numoflives);
		}
		else
			cycleCounter++;
	}
	
	public String toString() {
		return "C[" + numoflives + "]";
	}
	
	public String toDebugString() {
		return "C[l:" + numoflives + ",x:" + x + ",y:" + y + ",t:" + (cycles - cycleCounter - 1) + "]"; 
	}
	
	public String toStringFile() {
		return "c:" + numoflives + ":" + x + ":" + y + ":" + (cycles - cycleCounter - 1);
	}
}
