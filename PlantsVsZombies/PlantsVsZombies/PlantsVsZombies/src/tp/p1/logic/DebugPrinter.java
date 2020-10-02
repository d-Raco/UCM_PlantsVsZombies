package tp.p1.logic;

public class DebugPrinter extends BoardPrinter {
	public void encodeGame(Game game) {
		index = game.getCounterPlants() + game.getCounterZombies();
		board = new String[1][index];
		
		for(int i = 0; i < game.getCounterPlants(); i++) {
			board[0][i] = game.stringDebugPlant(i);
		}
		
		for(int i = 0; i < game.getCounterZombies(); i++) {
			board[0][i + game.getCounterPlants()] = game.stringDebugZombie(i);
		}
	}
	
	public String printGame(Game game) {
		return "Level: "	+ game.getLevel() + "\n" + "Seed: " + game.getSeed() + "\n" + BoardToString(18);
	}
}
