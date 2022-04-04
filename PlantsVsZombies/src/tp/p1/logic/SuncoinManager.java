package tp.p1.logic;

public class SuncoinManager {
	private int suncoins = 50;
	
	public int getSuncoins() {
		return suncoins;
	}

	public void setSuncoins(int suncoins) {
		this.suncoins += suncoins;
	}
}
