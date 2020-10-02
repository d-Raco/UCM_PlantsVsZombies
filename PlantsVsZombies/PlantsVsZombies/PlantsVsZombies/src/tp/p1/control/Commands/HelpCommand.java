package tp.p1.control.Commands;

import tp.p1.logic.Game;

public class HelpCommand extends NoParamsCommand {

	public HelpCommand() {
		super("help" , "[H]elp", "Prints this help message.");
	}
	
	public boolean execute(Game game) {
		System.out.println(game.getCommandHelp());
		return false;
	}
}
