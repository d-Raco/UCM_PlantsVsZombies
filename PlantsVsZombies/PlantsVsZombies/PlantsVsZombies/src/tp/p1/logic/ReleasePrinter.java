package tp.p1.logic;

public class ReleasePrinter extends BoardPrinter {	
	public void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {
				board[i][j] =  space;
			}
		}
		
		for(int i = 0; i < game.getCounterPlants(); i++) {
			board[game.getPlantX(i)][game.getPlantY(i)] = game.stringPlant(i);
		}
		
		for(int i = 0; i < game.getCounterZombies(); i++) {
			board[game.getZombieX(i)][game.getZombieY(i)] = game.stringZombie(i);
		}
	}
	
	public String printGame(Game game) {
		return BoardToString(7);
	}
}
