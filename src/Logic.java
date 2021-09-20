import java.util.Random;

import javax.swing.ImageIcon;

import java.lang.reflect.*;
public class Logic {

	private static int rows = 21;
	private static int columns = 10;
	
	private int score;
	private int currentCompletedLines;
	private int speed;
	
	private TetrisGUI myGUI;
	private Tetrimino currentTetrimino;
	private Tetrimino nextTetrimino;
	private Time currentTime;
	private Grid myGrid;
	
	private String s [] = {"Tetimino_I"};
	
	
	public Logic(TetrisGUI myGUI) {
		score = 0;
		currentCompletedLines = 0;
		this.myGUI = myGUI;
		currentTime = new Time(this);
		myGrid = new Grid(rows, columns);
		currentTetrimino = createNewTetrimino();
		nextTetrimino = createNewTetrimino();
		
	}
	
	
	public Tetrimino createNewTetrimino() {
		
		
		return null;
		
	}
	
	public void addPoints(int lines) {
		
		score += 100 * lines;	
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
		
		currentTetrimino.moveToDown();
	}
	
	public void rotate() {
		
		currentTetrimino.rotate();
	}
	
	public void gameOver() {
		
	}
	
	public void refreshGUI(int x, int y, ImageIcon image) {
		
		myGUI.draw(x, y, image);
	}
	
	public int getCurrentScore() {
		
		return score;
	}
	
	public int getCurrentCompletedLines() {
		
		return currentCompletedLines;
	}
	
	
	
	

}
