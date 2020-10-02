package tp.p1.logic;

abstract public class GameObject {
	protected int x, y;
	protected Game game;
	
	abstract public void update();
	
	abstract public String getInfo();
	
	abstract public int getNumOfLives();
	
	abstract public void Attacked(int damage);
	
	abstract public String toString();
	
	abstract public void setCycle(int cycles);
	
	abstract public void setLives(int lives);
	
	abstract public String toDebugString();
	
	abstract public String toStringFile();

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
