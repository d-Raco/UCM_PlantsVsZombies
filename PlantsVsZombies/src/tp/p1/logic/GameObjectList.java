package tp.p1.logic;

public class GameObjectList {
	private GameObject [] objects;
	private int counter = 0;
	
	public GameObjectList(int maxObjects) {
		objects = new GameObject [maxObjects];
	}
	
	public void add(GameObject obj, int x, int y, Game game) {
		obj.setGame(game);
		obj.setX(x);
		obj.setY(y);
		objects[counter] = obj;
		counter++;
	}
	
	public void erase() {
		boolean dead = false;
		int numofdead = 0;
		for(int i = 0; i < counter; i++) {
			if (objects[i].getNumOfLives() == 0) {
				numofdead++;
				objects[i] = objects[i + 1];
				if (objects[i] != null && objects[i].getNumOfLives() == 0)
					numofdead++;
				dead = true;
			}
			else if(dead) {
				objects[i] = objects[i + 1];
			}
		}

		for(int j = 0; j < numofdead; j++) {
			objects[counter] = null;
			if(counter != 0)
				counter--;
		}
		
		if(numofdead != 0)
			erase();
	}
	
	public void update(int index) {
		objects[index].update();
	}
	
	public void Attacked(int num, int damage) {
		objects[num].Attacked(damage);
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void initializeCounter() {
		counter = 0;
	}
	
	public int getX(int num) {
		return objects[num].getX();
	}
	
	public int getY(int num) {
		return objects[num].getY();
	}

	public int getCost(Plant plant) {
		return plant.getCost();
	}
	
	public void setCycle(int cycles) {
		objects[counter - 1].setCycle(cycles);
	}
	
	public void setLives(int lives) {
		objects[counter - 1].setLives(lives);;
	}
	
	public String toString(int num) {
		return "" + objects[num];
	}
	
	public String toDebugString(int num) {
		return objects[num].toDebugString();
	}
	
	public String toStringFile(int num) {
		return objects[num].toStringFile();
	}
}
