package life;

public class LifeController {
	static int event;
	
	public static void main(String[] args) {
		LifeBoard board = new LifeBoard(13, 13);
		LifeView window = new LifeView(board);
		Life life = new Life(board);
		window.drawBoard();
		
		while (true) {	
			switch(window.getCommand()) {
			case 1: life.flip(window.getRow(), window.getCol()); break;
			case 2: life.nextGeneration(); break;
			case 3: System.exit(0);
			}
			
			window.update();
		}
	}
}
