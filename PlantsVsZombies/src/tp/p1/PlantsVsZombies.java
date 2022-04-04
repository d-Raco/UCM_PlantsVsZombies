package tp.p1;

import java.io.IOException;
import java.util.Scanner;
import tp.p1.control.Controller;
import tp.p1.control.Exceptions.CommandExecuteException;
import tp.p1.control.Exceptions.CommandParseException;
import tp.p1.control.Exceptions.FileContentsException;
import tp.p1.logic.GamePrinter;
import tp.p1.logic.Game;
import tp.p1.logic.Level;
import tp.p1.logic.ReleasePrinter;

public class PlantsVsZombies {
	private static final String Usage = "Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]";
	private static final String LevelStr = ": level must be one of: EASY, HARD, INSANE";
	private static final String Seed = ": the seed must be a number";
	
	public static void main(String[] args) throws CommandParseException, FileContentsException, IOException {
		Scanner scann = new Scanner(System.in);
		GamePrinter printer = new ReleasePrinter();
		boolean reset = false;
		Level level;
		
		try {
			if (args.length > 0 && args.length < 3) {
				switch(args[0]) {
				case "EASY":
					level = Level.EASY;
					break;
				case "HARD":
					level = Level.HARD;
					break;
				case "INSANE":
					level = Level.INSANE;
					break;
				default: throw new CommandParseException(Usage + LevelStr);
				}
			}
			else
				throw new CommandParseException(Usage);
			
			if (args.length == 1)  {
				do {
				Game game = new Game(level, printer);
				Controller controller = new Controller(game, scann);
				reset = controller.run();
				} while (reset);
			}
			else if (args.length == 2) {
				do {
				Game game = new Game(level, Integer.parseInt(args[1]), printer);
				Controller controller = new Controller(game, scann);
				reset = controller.run();
				} while (reset);
			}
		} catch (NumberFormatException e){
			System.out.format(Usage + Seed);
	    } 
	}
}
