package tp.p1.logic;

import tp.p1.util.MyStringUtils;

abstract public class BoardPrinter implements GamePrinter{
	protected static int dimX = 4, dimY = 8;
	protected int index;
	protected String[][] board;
	final String space = " ";
	
	public String BoardToString(int cellSize) {
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		if(cellSize == 7) {	
			str.append(lineDelimiter);
			for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
			}
		}
		
		else if(cellSize == 18) {
			rowDelimiter = MyStringUtils.repeat(hDelimiter, (index * (cellSize + 1)) - 1);
			lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
			str.append(lineDelimiter);
			str.append(margin).append(vDelimiter);
			for(int i=0; i< index; i++)
				str.append( MyStringUtils.centre(board[0][i], cellSize)).append(vDelimiter);
			str.append(lineDelimiter);
		}
		return str.toString();
	}
	
	abstract public void encodeGame(Game game);
}
