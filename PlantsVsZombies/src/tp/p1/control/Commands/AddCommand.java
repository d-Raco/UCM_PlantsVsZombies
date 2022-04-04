package tp.p1.control.Commands;

import tp.p1.control.Command;
import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.logic.Game;
import tp.p1.logic.Plant;
import tp.p1.util.PlantFactory;

public class AddCommand extends Command {
	private String x, y;
	private String PlantName;
	private static final String UnknownName = "Unknown plant name: ";
	private static final String InvalidArgument = "Invalid argument for add command, number expected: ";
	private static final String Failed = "Failed to add ";
	
	public AddCommand() {
		super("add", "[A]dd <plant> <x> <y>", "Adds a plant in position x, y");
	}
	
	public boolean execute(Game game) throws CommandParseException, CommandExecuteException {
		boolean print;
		Plant plant = PlantFactory.getPlant(PlantName);
		if (plant != null) {
			try {
				print = game.addPlantToGame(plant, x, y);
			} catch (CommandExecuteException ex) {
				throw new CommandExecuteException(Failed + PlantName + ": " + ex.getMessage());
			}  catch (NumberFormatException e){
		 	    throw new CommandParseException(InvalidArgument + helpText); 
		    } 
		}
		else 
			throw new CommandParseException(UnknownName + PlantName);
		return print;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException { 
		Command command = null;
		if(!commandWords[0].isEmpty()) {
			if (commandWords[0].toLowerCase().equals(commandName) || commandWords[0].toLowerCase().equals(commandName.substring(0, 1))) {
				if (commandWords.length == 4) {
					command = this;
					PlantName = commandWords[1].toLowerCase();
					x = commandWords[2];
					y = commandWords[3];
				}
				else
					throw new CommandParseException(IncorrectLength1 + commandName + IncorrectLength2 + helpText);
			}
		}
		return command;
	}
}
