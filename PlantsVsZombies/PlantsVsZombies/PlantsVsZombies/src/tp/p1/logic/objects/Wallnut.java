package tp.p1.logic.objects;

import tp.p1.logic.Plant;

public class Wallnut extends Plant{
	public Wallnut() {
		super("[W]all-nut", 50, 0, 0, 10);
	}
	
	public void update() {
		
	}
	
	public String toString() {
		return "W[" + numoflives + "]";
	}
	
	public String toDebugString() {
		return "W[l:" + numoflives + ",x:" + x + ",y:" + y + ",t:" + cycleCounter + "]"; 
	}
	
	public String toStringFile() {
		return "w:" + numoflives + ":" + x + ":" + y + ":" + cycleCounter;
	}
}