package tp.p1.control.Commands;

import java.io.*;
import tp.p1.util.MyStringUtils;
import tp.p1.control.Command;
import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class SaveCommand extends Command {
	private String fileName;
	private static final String FileName = "Invalid filename: the filename contains invalid characters";
	
	public SaveCommand() {
		super("save", "[S]ave <filename>", "Save the state of the game to a file.");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            bufferedWriter.write("Plants Vs Zombies v3.0");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("cycle: " + game.getCycle());
            bufferedWriter.newLine();
            bufferedWriter.write("sunCoins: " + game.getSunCoins());
            bufferedWriter.newLine();
            bufferedWriter.write("level: " + game.getLevel());
            bufferedWriter.newLine();
            bufferedWriter.write("remZombies: " + game.getZombLeftToApperar());
            bufferedWriter.newLine();
            bufferedWriter.write("plantList: " + game.storePlants());
			bufferedWriter.newLine();
			bufferedWriter.write("zombieList: " + game.storeZombies());
         
            // Always close files.
            bufferedWriter.close();
        } catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
		System.out.println("Game successfully saved to file " + fileName+ ".dat; use the load command to reload it.");
		return false;
    }
	
	public Command parse(String[] commandWords) throws CommandParseException, CommandExecuteException {
		Command command = null;
		if(!commandWords[0].isEmpty()) {
			if (commandWords[0].equals(commandName) || commandWords[0].equals(commandName.substring(0, 1))) {
				if (commandWords.length == 2) {
					if(MyStringUtils.isValidFilename(commandWords[1])) {
						command = this;
						fileName = commandWords[1];
					}
					else
			            throw new CommandExecuteException(FileName);
				}
				else
					throw new CommandParseException(IncorrectLength1 + commandName + IncorrectLength2 + helpText);
			}
		}
		return command;
	}
}	
