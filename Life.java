package life;

public class Life {
	LifeBoard board;
	
	
	public Life(LifeBoard board) {
		this.board = board;
	}
	
	//Byter värde på rutan på plats (row,col)
	public void flip(int row, int col) {
		if(board.get(row, col)) {
			board.put(row, col, false);
		}
		else {
			board.put(row, col, true);
		}
	}
	public void nextGeneration() {
		int neighbours;
		
		//skapar en vektor som agerar som en kö åt de som ska flippas efter att alla ytor har kontrollerats
		boolean[][]	toBeFlipped = new boolean[board.getRows()][board.getCols()];
		
		
		//Går igenom varje ruta genom att gå rad för rad
		for (int row = 0; row < board.getRows(); row++) {
			for(int col = 0; col < board.getCols(); col++) {
				neighbours = countNeighbours(row, col);
				//Om rutan är bebodd
				if (board.get(row, col)) {
					//Dödsfallen
					if (neighbours < 2 || 3 < neighbours) {
						toBeFlipped[row][col] = true; 
					}
				}
				//Om rutan är tom
				else {
					//Födelsefallet
					if(neighbours == 3) {
						toBeFlipped[row][col] = true; 
					}
				}
			}
		}
		flipArray(toBeFlipped);
		board.increaseGeneration();
	}
	//Returnerar antalet grannar en ruta har. 
	private int countNeighbours(int refRow, int refCol) {
		//Börjar räknaren på -1 eftersom metoden räknar med referensrutan
		int neighbours = 0; 
		
		for (int row = -1; row <= 1; row++) {
			for (int col = -1; col <= 1; col++) {
				if(board.get(refRow + row, refCol + col)) {
					neighbours++;
				}
			}
		}
		if (board.get(refRow, refCol))
			return neighbours-1;
		
		else{
			return neighbours;
		}
	}
	
	//Anropar flip på alla rutor i kön
	private void flipArray(boolean[][]toBeFlipped) {
		for (int row = 0; row < board.getRows(); row++) {
			for(int col = 0; col < board.getCols(); col++) {
				if(toBeFlipped[row][col]) {
					flip(row, col);
				}
			}
		}
	}
}
