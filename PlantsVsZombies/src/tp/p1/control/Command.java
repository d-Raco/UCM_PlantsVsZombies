package tp.p1.control;

import java.io.IOException;

import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.control.Exceptions.FileContentsException;
import tp.p1.logic.Game;

abstract public class Command {
	protected String helpText;
	private String helpInfo;
	protected final String commandName;
	protected static final String IncorrectLength1 = "Incorrect number of arguments for ";
	protected static final String IncorrectLength2 = " command: ";
	
	public Command(String commandText, String commandTextMsg, String helpTextMsg){
		commandName = commandText;
		helpText = commandTextMsg;
		helpInfo = helpTextMsg;
	}
	// Some commands may generate an error in the execute or parse methods.
	// In the absence of exceptions , they must the tell  the controller  not to print  the board
	abstract public boolean execute(Game game) throws CommandParseException, CommandExecuteException, IOException, FileContentsException;
	
	abstract public Command parse(String[] commandWords) throws CommandParseException, FileContentsException, CommandExecuteException;
	
	public String helpText(){
		return "  " + helpText + ": " + helpInfo;
	}
}
