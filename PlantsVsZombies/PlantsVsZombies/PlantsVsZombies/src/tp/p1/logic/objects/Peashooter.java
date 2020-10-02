package tp.p1.logic.objects;

import tp.p1.logic.Plant;

public class Peashooter extends Plant{
	public Peashooter() {
		super("[P]eashooter", 50, 1, 1, 3);
	}
	
	public void update() {
		game.PeaShoots(x, y, harm);
	}
	
	public String toString() {
		return "P[" + numoflives + "]";
	}
	
	public String toDebugString() {
		return "P[l:" + numoflives + ",x:" + x + ",y:" + y + ",t:" + cycleCounter + "]"; 
	}
	
	public String toStringFile() {
		return "p:" + numoflives + ":" + x + ":" + y + ":" + cycleCounter;
	}
}