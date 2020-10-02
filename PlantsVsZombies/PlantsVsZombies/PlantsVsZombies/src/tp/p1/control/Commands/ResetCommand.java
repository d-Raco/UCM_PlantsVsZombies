package tp.p1.control.Commands;

import tp.p1.logic.Game;

public class ResetCommand extends NoParamsCommand {

	public ResetCommand() {
		super("reset" , "[R]eset" , "Starts a new game.");
	}
	
	public boolean execute(Game game) {
		game.setReset();
		game.setExit();
		return false;
	}
}
