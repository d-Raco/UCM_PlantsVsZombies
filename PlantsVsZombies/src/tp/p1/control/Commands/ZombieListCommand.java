package tp.p1.control.Commands;

import tp.p1.logic.Game;

public class ZombieListCommand extends NoParamsCommand{
	
	public ZombieListCommand() {
		super("zombielist", "[Z]ombielist", "Prints the list of zombies.");
	}
	
	public boolean execute(Game game) {
		System.out.println(game.infoAvailableZombies());
		return false;
	}
}
