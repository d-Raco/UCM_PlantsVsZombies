package tp.p1.logic;

import java.util.Random;
import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.util.PlantFactory;
import tp.p1.util.ZombieFactory;

public class Game {
	private int cycleCount = 0;
	private boolean exit = false, reset = false;
	private ZombieManager zombmanag;
	private SuncoinManager suncoinmanag;
	private GamePrinter printer;
	private Random r;
	private Board board;
	private String seed, level, help;
	private static final String InvalidPosition = ") is an invalid position.";
	private static final String Suncoins = "not enough suncoins available";
	
	public Game(Level level, GamePrinter printer) {
		this.printer = printer;
		r = new Random();
		Mode(level);
	}

	public Game(Level level, int seed, GamePrinter printer) {
		this.seed = "" + seed;
		this.printer = printer;
		System.out.println("Seed used: " + seed);
		r = new Random(seed);
		Mode(level);
	}
	
	private void Mode(Level level) {
		this.level = "" + level;
		zombmanag  = new ZombieManager(level, r);
		suncoinmanag = new SuncoinManager();
		board = new Board();
	}
	
	public boolean isFinished() {
		for (int i = 0; i < board.getCounterZombies() && !exit; i++) {
			if (board.getZombieY(i) == 0) {
				exit = true;
				System.out.println("\n ****** Game over!: Zombies win ******");
			}
		}
		if (!exit) {
			if(zombmanag.getZombiesLeftToAppear() == 0 && board.getCounterZombies() == 0) {
				exit = true;
				System.out.println("\n ****** Game over!: User wins ******");
			}
		}
		return exit;
	}
	
	public void update() {
		board.update();
		addZombie();
		cycleCount++;
	}
	
	public String toString() {
		System.out.println("Number of cycles: " + cycleCount);
		System.out.println("Sun coins: " + suncoinmanag.getSuncoins());
		System.out.println("Remaining zombies: " + zombmanag.getZombiesLeftToAppear());
		printer.encodeGame(this);
		return printer.printGame(this);
	}
	
	public boolean emptyTile(int x , int y) {
		boolean empty = true;
		for(int i = 0; i < board.getCounterPlants(); i++) {
			if(board.getPlantX(i) == x && board.getPlantY(i) == y) 
				empty = false;
		}
		
		for(int k = 0; k < board.getCounterZombies(); k++) {
			if(board.getZombieX(k) == x && board.getZombieY(k) == y) 
				empty = false;
		}
		return empty;
	}
	
	public boolean addPlantToGame(Plant plant, String xstr, String ystr) throws CommandExecuteException {
		boolean planted = false;
		
		int x = Integer.parseInt(xstr), y = Integer.parseInt(ystr);
		if (suncoinmanag.getSuncoins() >= board.getCost(plant)) {
			if (x >= 0 && x < 4 && y >= 0 && y < 7 && emptyTile(x, y)) {
				suncoinmanag.setSuncoins(-board.getCost(plant));
				board.addPlant(plant, x, y, this);
				planted = true;
			}
			else
				throw new CommandExecuteException("(" + x + ", " + y + InvalidPosition);
		}
		else
			throw new CommandExecuteException(Suncoins);
		return planted;
	}
	
	public void addZombie() {
		if(zombmanag.isZombieAdded()) {
			if(emptyTile(0, 7) || emptyTile(1, 7) || emptyTile(2, 7) || emptyTile(3, 7)) {
				int tile = zombmanag.RandomTile();
				while(!emptyTile(tile, 7)) {
					tile = zombmanag.RandomTile();
				}
				board.addZombie(ZombieFactory.getZombie(r), tile, 7, this);
			}
		}
	}
	
	public void PeaShoots(int x, int y, int damage) {
		boolean found = false;
		for(int i = 0; i < board.getCounterZombies() && !found; i++) {
			if(board.getZombieX(i) == x && board.getZombieY(i) > y) {
				board.zombieAttacked(i, damage);
				found = true;
			}
		}	
	}
	
	public void explode(int x, int y, int damage) {
		for (int i = x - 1; i <= x + 1 ; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				for (int k = 0; k < board.getCounterZombies(); k++) {
					if (board.getZombieX(k) == i && board.getZombieY(k) == j)
						board.zombieAttacked(k, damage);
				}
			}
		}
	}
	
	public void ZombieZombs(int x, int y, int damage) {
		for(int i = 0; i < board.getCounterPlants(); i++) {
			if(board.getPlantX(i) == x && board.getPlantY(i) == y - 1)
				board.plantAttacked(i, damage);
		}
	}
	
	public int getCycle() {
		return cycleCount;
	}
	
	public String infoAvailablePlants() {
		return PlantFactory.infoAvilablePlants();
	}
	
	public String infoAvailableZombies() {
		return ZombieFactory.infoAvailableZombies();
	}
	
	public void setHelp(String help) {
		this.help = help;
	}
	
	public String getCommandHelp() {
		return help;
	}
	
	public boolean getReset() {
		return reset;
	}
	
	public String getSeed() {
		return seed;
	}
	
	public String getLevel() {
		return level;
	}
	
	public int getCounterPlants() {
		return board.getCounterPlants();
	}
	
	public int getCounterZombies() {
		return board.getCounterZombies();
	}
	
	public int getPlantX(int num) {
		return board.getPlantX(num);
	}
	
	public int getPlantY(int num) {
		return board.getPlantY(num);
	}
	
	public int getZombieX(int num) {
		return board.getZombieX(num);
	}
	
	public int getZombieY(int num) {
		return board.getZombieY(num);
	}
	
	public void setPrinter(GamePrinter printer) {
		this.printer = printer;
	}
	
	public void setSuncoins(int suncoins) {
		suncoinmanag.setSuncoins(suncoins);
	}
	
	public void setExit() {
		exit = true;
	}
	
	public void setReset() {
		reset = true;
	}
	
	public String stringPlant(int num) {
		return board.stringPlant(num);
	}
	
	public String stringZombie(int num) {
		return board.stringZombie(num);
	}
	
	public String stringDebugPlant(int num) {
		return board.stringDebugPlant(num);
	}
	
	public String stringDebugZombie(int num) {
		return board.stringDebugZombie(num);
	}
	
	public int getSunCoins() {
		return suncoinmanag.getSuncoins();
	}
	
	public int getZombLeftToApperar() {
		return zombmanag.getZombiesLeftToAppear();
	}
	
	public String storePlants() {
		String aux = "";
		for(int i = 0; i < getCounterPlants() - 1; i++) {
			aux += board.storePlants(i) + ", ";
		}
		aux += board.storePlants(getCounterPlants() - 1);
		return aux;
	}
	
	public String storeZombies() {
		String aux = "";
		for(int i = 0; i < getCounterZombies() - 1; i++) {
			aux += board.storeZombies(i) + ", ";
		}
		aux += board.storeZombies(getCounterZombies() - 1);
		return aux;
	}

	public void load(String[] line) {
		board.initializeCounterPlants();
		board.initializeCounterZombie();
		cycleCount = Integer.parseInt(line[0]);
		suncoinmanag.setSuncoins(Integer.parseInt(line[1]));
		level = line[2];
        zombmanag.setZombiesLeftToAppear(Integer.parseInt(line[3]));
        for(int i = 4; i < line.length && line[i] != null; i++) {
        	if (PlantFactory.getPlant(line[i].charAt(0) + "") != null) {
        		board.addPlant(PlantFactory.getPlant(line[i].charAt(0) + ""), Character.getNumericValue(line[i].charAt(4)), Character.getNumericValue(line[i].charAt(6)), this);
        		board.setPlantLives(Character.getNumericValue(line[i].charAt(2)));
        		board.setPlantCycles(Character.getNumericValue(line[i].charAt(8)));
        	}
        	else {
        		board.addZombie(ZombieFactory.getZombie(line[i].charAt(0) + ""), Character.getNumericValue(line[i].charAt(4)), Character.getNumericValue(line[i].charAt(6)), this);
            	board.setZombieLives(Character.getNumericValue(line[i].charAt(2)));
        		board.setZombieCycles(Character.getNumericValue(line[i].charAt(8)));
        	}
        }
	}
}
