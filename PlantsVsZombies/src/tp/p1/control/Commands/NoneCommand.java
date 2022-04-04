package tp.p1.control.Commands;

import tp.p1.control.Command;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class NoneCommand extends Command {

	public NoneCommand() {
		super("none", "[None]" , "Update the game without any user action.");
	}
	
	public boolean execute(Game game) {
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		if(!commandWords[0].isEmpty()) {
			if (commandWords[0].toLowerCase().equals(commandName) || commandWords[0].toLowerCase().equals(commandName.substring(0, 1))) {
				if (commandWords.length == 1)
					command = this;
				else
					throw new CommandParseException(IncorrectLength1 + commandName + IncorrectLength2 + helpText);
			}
		}
		else
			command = this;
		return command;
	}
}
