package tp.p1.control.Commands;

import java.io.*;

import tp.p1.control.Command;
import tp.p1.util.MyStringUtils;
import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.control.Exceptions.FileContentsException;
import tp.p1.logic.Game;

public class LoadCommand extends Command{
	private String fileName;
	public static final String FoundFile = "File not found.";
	public static final String wrongPrefixMsg = "unknown game attribute: ";
	public static final String lineTooLongMsg = "too many words on line commencing: ";
	public static final String lineTooShortMsg = "missing data on line commencing: ";
	
	public LoadCommand() {
		super("load", "[Lo]ad <filename>", "Load the state of the game from a file.");
	}

	public boolean execute(Game game) throws IOException, CommandExecuteException {
		  // This will reference one line at a time
        String[] line = new String[32], aux, prefix = {"cycle", "sunCoins", "level", "remZombies", "plantList", "zombieList"};
        int counter = 0, i = 0;
		boolean isList;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
        //getFileName() String fileName = user input
		try {
            // FileReader reads text files in the default encoding.
           fileReader = new FileReader(fileName);
          
            // Always wrap FileReader in BufferedReader.
           bufferedReader = new BufferedReader(fileReader);
           bufferedReader.readLine();
           bufferedReader.readLine();
            while (counter < 6) {
            	if (counter == 4 || counter == 5)
            		isList = true;
            	else 
            		isList = false;
            	aux = loadLine(bufferedReader, prefix[counter], isList);
        		for (int j = 0; j < aux.length; j++) {
            		line[i] = aux[j];
            		i++;
        		}
        		counter++;
            }   
            game.load(line);
                  
        } catch(FileContentsException ex) {
            System.out.println(ex.getMessage() + ". "); 
            throw new CommandExecuteException(FoundFile);
        } catch(IOException ex) {
            throw new CommandExecuteException(FoundFile);

            // Or we could just do this: 
            // ex.printStackTrace();
        } finally {
        	if (line != null)  bufferedReader.close();  
        }
		System.out.println("Game successfully loaded from file " + fileName + ".");//filename.dat
		return false;
    }
	
	public Command parse(String[] commandWords) throws CommandParseException, FileContentsException {
		Command command = null;
		if(!commandWords[0].isEmpty()) {
			String aux = commandWords[1].substring(0, commandWords[1].length() - 4);
			if (commandWords[0].toLowerCase().equals(commandName) || commandWords[0].toLowerCase().equals(commandName.substring(0, 2))) {
				if (commandWords.length == 2) {
					if(MyStringUtils.isValidFilename(aux) && MyStringUtils.fileExists(aux) && MyStringUtils.isReadable(aux) && commandWords[1].substring(commandWords[1].length() - 4, commandWords[1].length()).equals(".dat")) {
						command = this;
						fileName = aux;
					}
					else 
						throw new FileContentsException(FoundFile);
				}
				else
					throw new CommandParseException(IncorrectLength1 + commandName + IncorrectLength2 + helpText);
			}
		}
		return command;
	}
			
	public String[] loadLine(BufferedReader inStream, String prefix, boolean isList) throws IOException, FileContentsException {
		
		String[] words;
		String line = inStream.readLine().trim();
		
		// absence of the prefix is invalid
		if (!line.startsWith(prefix + ":") )
			throw new FileContentsException(wrongPrefixMsg + prefix);
		
		// cut the prefix and the following colon off the line then trim it to get attribute contents
		String contentString = line.substring(prefix.length()+1).trim();
			
		// the attribute contents are not empty
		if (!contentString.equals("")) {
			if (!isList ) {
				// split non−list attribute contents into words
				// using 1−or−more−white−spaces as separator
				words = contentString.split ("\\s+");
		
				// a non−list attribute with contents of more than one word is invalid
		
				if (words.length != 1)
					throw new FileContentsException(lineTooLongMsg + prefix);
			} else
				// split list attribute contents into words
				// using comma+0−or−more−white−spaces as separator
				words = contentString.split (",\\s*");
		
			// the attribute contents are empty
		} else {
			// a non−list attribute with empty contents is invalid
			if (!isList)
				throw new FileContentsException(lineTooShortMsg + prefix);
		// a list attribute with empty contents is valid; use a zero−length array to store its words
			words = new String[0];
		}
		return words;
	}
}
