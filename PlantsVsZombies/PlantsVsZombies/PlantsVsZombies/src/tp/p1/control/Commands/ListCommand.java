package tp.p1.control.Commands;

import tp.p1.logic.Game;

public class ListCommand extends NoParamsCommand{

	public ListCommand() {
		super("list" , "[L]ist" , "Prints list of available plants and zombies.");
	}
	
	public boolean execute(Game game) {
		System.out.println(game.infoAvailablePlants());
		return false;
	}
}
