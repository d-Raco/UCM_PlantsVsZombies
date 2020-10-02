package tp.p1.logic;

public class Board {
	private GameObjectList plantList, zombieList;
	private int plantsMax = 28, zombiesMax = 10;
	
	public Board() {
		plantList = new GameObjectList(plantsMax);
		zombieList = new GameObjectList(zombiesMax);
	}
	
	public void addPlant(Plant plant, int x, int y, Game game) {
		plantList.add(plant, x, y, game);
	}
	
	public void addZombie(Zombie zombie, int x, int y, Game game) {
		zombieList.add(zombie, x, y, game);
	}
	
	public void update() {
		for(int i = 0; i < plantList.getCounter(); i++) {
			plantList.update(i);
		}
		zombieList.erase();
		
		for(int j = 0; j < zombieList.getCounter(); j++) {
			zombieList.update(j);
		}
		plantList.erase();
	}
	
	public void plantAttacked(int num, int damage) {
		plantList.Attacked(num, damage);
	}
	
	public void zombieAttacked(int num, int damage) {
		zombieList.Attacked(num, damage);
	}

	public int getCounterPlants() {
		return plantList.getCounter();
	}
	
	public int getCounterZombies() {
		return zombieList.getCounter();
	}
	
	public int getPlantX(int num) {
		return plantList.getX(num);
	}
	
	public int getPlantY(int num) {
		return plantList.getY(num);
	}
	
	public int getZombieX(int num) {
		return zombieList.getX(num);
	}
	
	public int getZombieY(int num) {
		return zombieList.getY(num);
	}

	public int getCost(Plant plant) {
		return plantList.getCost(plant);
	}
	
	public String stringPlant(int num) {
		return plantList.toString(num);
	}
	
	public String stringZombie(int num) {
		return zombieList.toString(num);
	}
	
	public String stringDebugPlant(int num) {
		return plantList.toDebugString(num);
	}
	
	public String stringDebugZombie(int num) {
		return zombieList.toDebugString(num);
	}
	
	public String storePlants(int num) {
		return plantList.toStringFile(num);
	}
	
	public String storeZombies(int num) {
		return zombieList.toStringFile(num);
	}
	
	public void setZombieLives(int lives) {
		zombieList.setLives(lives);
	}
	
	public void setPlantLives(int lives) {
		plantList.setLives(lives);
	}
	
	public void setZombieCycles(int cycles) {
		zombieList.setCycle(cycles);
	}

	public void setPlantCycles(int cycles) {
		plantList.setCycle(cycles);;
	}
	
	public void initializeCounterPlants() {
		plantList.initializeCounter();
	}
	
	public void initializeCounterZombie() {
		zombieList.initializeCounter();
	}
}
