import java.util.Random;

import javax.swing.ImageIcon;

import java.lang.reflect.*;
public class Logic {

	
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
		this.myGUI = myGUI;
		score = 0;
		currentCompletedLines = 0;
		currentTime = new Time(this);
		myGrid = new Grid(myGUI.getRows(), myGUI.getColumns(), this);
		currentTetrimino = createNewTetrimino();
		//nextTetrimino = createNewTetrimino();
		
	}
	
	
	public Tetrimino createNewTetrimino() {
		
		//Tetrimino t1 = new Tetrimino_I(myGrid);
		Tetrimino t1 = new Tetrimino_T(myGrid);
		
		return t1;
		
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
		
		currentTetrimino.moveDown();
	}
	
	public void rotate() {
		
		currentTetrimino.rotate();
	}
	
	public void gameOver() {
		
	}
	
	public void refreshGUI(int y, int x, ImageIcon image) {
		
		myGUI.draw(x, y, image);
	}
	
	public int getCurrentScore() {
		
		return score;
	}
	
	public int getCurrentCompletedLines() {
		
		return currentCompletedLines;
	}
	
	
	
	

}
