import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.swing.ImageIcon;

public class Logic {
	
	private int score;
	private int currentCompletedLines;
	private int speed;
	
	private TetrisGUI myGUI;
	private Tetrimino currentTetrimino;
	private Tetrimino nextTetrimino;
	private Time currentTime;
	private Grid myGrid;
	
	public Logic(TetrisGUI myGUI) {
	
			
		this.myGUI = myGUI;
		score = 0;
		currentCompletedLines = 0;
		myGrid = new Grid(myGUI.getRows(), myGUI.getColumns(), this);
		currentTetrimino = createNewTetrimino();
		currentTetrimino.initializeTetrimino();
		nextTetrimino = createNewTetrimino();	
		currentTime = new Time(this);
		currentTime.start();
	
	}
	
	
	public Tetrimino createNewTetrimino() {
	
		 ArrayList<Supplier<Tetrimino>> bonuses = new ArrayList<>();
		 bonuses.add(new Tetrimino_I(myGrid));
		 bonuses.add(new Tetrimino_J(myGrid));
		 bonuses.add(new Tetrimino_L(myGrid));	 	
		 bonuses.add(new Tetrimino_O(myGrid));
		 bonuses.add(new Tetrimino_S(myGrid));
		 bonuses.add(new Tetrimino_T(myGrid));
		 bonuses.add(new Tetrimino_Z(myGrid));
		 
		 
		 Random r = new Random();
		 
		 return (Tetrimino) bonuses.get(r.nextInt(bonuses.size()));
	}
	
	public void addPoints(int lines) {
		
		score += 100 * lines;	
		System.out.println(score);
	}
	
	public void increaseSpeed() {
		
		speed++;
	}
	
	public void moveToLeft() {
		
		currentTetrimino.moveToLeft();
	}
	
	public void moveToRight() {
		
		currentTetrimino.moveToRight();
	}
	
	public void moveToDown() {
	
		int removedLines = 0;
		if (!currentTetrimino.moveDown()) {
			removedLines = myGrid.removeLines();
			currentTetrimino = nextTetrimino;
			nextTetrimino = createNewTetrimino();
			currentTetrimino.initializeTetrimino();
			currentCompletedLines += removedLines;
			addPoints(removedLines);
		}
		
	}
	
	public void rotate() {
		
		currentTetrimino.rotate();
	}
	
	public void gameOver() {
		
	}
	
	public void refreshGUI(int y, int x, ImageIcon image) {
	//	System.out.println(currentTime.getElapsedTime() / 600);
		myGUI.draw(x, y, image);
	}
	
	public int getCurrentScore() {
		
		return score;
	}
	
	public int getCurrentCompletedLines() {
		
		return currentCompletedLines;
	}


	public void rotateIZQ() {
		currentTetrimino.rotateIZQ();
		
	}
	
}
