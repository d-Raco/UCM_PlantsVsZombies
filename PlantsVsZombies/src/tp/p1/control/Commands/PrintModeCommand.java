package tp.p1.control.Commands;

import tp.p1.control.Command;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.logic.DebugPrinter;
import tp.p1.logic.Game;
import tp.p1.logic.ReleasePrinter;

public class PrintModeCommand extends Command {
	private String mode;
	private static final String InvalidArgument = "Unkown print mode: ";

	public PrintModeCommand(){
		super("printmode" , "[P]rintmode <mode>" , "Selects the print mode <Release | Debug>.");
	}
	
	public boolean execute(Game game) throws CommandParseException {
		switch (mode) {
		case "debug":
			game.setPrinter(new DebugPrinter());
			break;
		case "release":
			game.setPrinter(new ReleasePrinter());
			break;
		default: 
			throw new CommandParseException(InvalidArgument + mode);		
		}
		return false;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException { 
		Command command = null;
		if(!commandWords[0].isEmpty()) {
			if (commandWords[0].toLowerCase().equals(commandName) || commandWords[0].toLowerCase().equals(commandName.substring(0, 1))) {
				if (commandWords.length == 2) {
					command = this;
					mode = commandWords[1].toLowerCase();
				}
				else
					throw new CommandParseException(IncorrectLength1 + commandName + IncorrectLength2 + helpText);			}
		}
		return command;
	}
}
