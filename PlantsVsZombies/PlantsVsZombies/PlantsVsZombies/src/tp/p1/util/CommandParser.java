package tp.p1.util;

import tp.p1.control.Commands.*;
import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.control.Exceptions.FileContentsException;
import tp.p1.control.*;

public class CommandParser {
	private static
	Command[] availableCommands = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new ZombieListCommand(),
		new PrintModeCommand(),
		new SaveCommand(),
		new LoadCommand(),
		new NoneCommand(), 
	};
	
	public Command parseCommand(String [] words) throws CommandParseException, FileContentsException, CommandExecuteException {
		Command command = null;
		for(int i = 0; i < 10 && command == null; i++) {
			if (availableCommands[i].parse(words) != null) 
				command = availableCommands[i].parse(words);
		}
		return command;
	}
	
	public String commandHelp() {
		String helpstr = "";
		for(int i = 0; i < availableCommands.length; i++)
			helpstr += availableCommands[i].helpText() + "\n";
		return helpstr;
	}
}
