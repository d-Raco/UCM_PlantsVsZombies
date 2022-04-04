package tp.p1.control;

import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.control.Exceptions.FileContentsException;
import tp.p1.logic.Game;
import java.io.IOException;
import java.util.Scanner;

import tp.p1.util.CommandParser;

public class Controller {
	private Game game;
	private Scanner scanner;
	private String prompt = "Command > ", unknownCommandMsg = "Unknown command. Use ’help’ to see the available commands\n";
	private CommandParser CommandParser;
	
	public Controller(Game game, Scanner scann) {
		this.game = game;
		this.scanner = scann;
		CommandParser = new CommandParser();
		setCommandHelp();
	}
	
	public boolean run() throws FileContentsException, IOException {
		while (!game.isFinished()){
			System.out.print(prompt);
			String[] words = scanner.nextLine().trim(). split ("\\s+");
			try {
				Command command = CommandParser.parseCommand(words);
				if (command != null) {
					if (command.execute(game)) 
						printGame();
				} else
				System.out.println(unknownCommandMsg);
			} catch (CommandParseException | CommandExecuteException | FileContentsException ex) {
				System.out.format(ex.getMessage() + "%n%n");
			}
		}
		return game.getReset();
	}
	
	public void printGame() {
		game.update();
		System.out.println(game.toString());
	}
	
	public void setCommandHelp() {
		game.setHelp(CommandParser.commandHelp());
	}
}