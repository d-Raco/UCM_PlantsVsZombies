package tp.p1.control.Commands;

import tp.p1.logic.Game;

public class ExitCommand extends NoParamsCommand {

	public ExitCommand() {
		super("exit", "[E]xit", "Terminates the program.");
	}
	
	public boolean execute(Game game) {
		game.setExit();
		System.out.println("\n ****** Game over!: User exit ******");
		return false;
	}
}
