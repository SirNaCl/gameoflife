package life;

public class LifeBoard {
	boolean[][] board;
	int generation;
	

	/** Skapar en spelplan med rows rader och cols kolonner.
	    Spelplanen är från början tom, dvs alla rutorna är
	    tomma och generationsräknaren är 1. */	
	public LifeBoard(int rows, int cols) {
		board = new boolean[rows + 2][cols + 2];
		generation = 1;
		
	}

	/** Undersöker om det finns en individ i rutan med index row,col, 
	    Om index row,col hamnar utanför spelplanen returneras false. */
	public boolean get(int row, int col) {
		return board[row+1][col+1];
	}

	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		board[row+1][col+1] = val;
	}

	/** Tar reda på antalet rader. */
	public int getRows() {
		return board.length - 2;
	}

 	/** Tar reda på antalet kolonner. */
	public int getCols() {
		return board[0].length - 2;
	}

	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		return generation;
	}

	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		generation++;
	}
}
