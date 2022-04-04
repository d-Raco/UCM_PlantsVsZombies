package tp.p1.control.Commands;

import tp.p1.control.Command;
import tp.p1.control.Exceptions.CommandParseException;

abstract class NoParamsCommand extends Command {
	private static final String NoArgs = " command has no arguments";

	public NoParamsCommand(String commandText, String commandTextMsg, String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		if(!commandWords[0].isEmpty()) {
			if (commandWords[0].toLowerCase().equals(commandName) || commandWords[0].toLowerCase().equals(commandName.substring(0, 1))) {
				if (commandWords.length == 1)
					command = this;
				else
					throw new CommandParseException(commandName + NoArgs);
			}
		}
		return command;
	}
}
