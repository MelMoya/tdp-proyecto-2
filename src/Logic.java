import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.swing.ImageIcon;

public class Logic {
	
	private int score = 0;
	private int currentCompletedLines = 0;
	private int speed = 1;
	private int step = 1000;
	
	private TetrisGUI myGUI;
	private Tetrimino currentTetrimino;
	private Tetrimino nextTetrimino;
	private Time currentTime;
	private Grid myGrid;
	
	public Logic(TetrisGUI myGUI) {
	
			
		this.myGUI = myGUI;
		myGrid = new Grid(myGUI.getRows(), myGUI.getColumns(), this);
		currentTetrimino = createNewTetrimino();
		currentTetrimino.initializeTetrimino();
		nextTetrimino = createNewTetrimino();	
		currentTime = new Time(this, step);
		currentTime.start();
	}
	
	
	public Tetrimino createNewTetrimino() {
	
		 ArrayList<Supplier<Tetrimino>> availableTetriminos = new ArrayList<>();
		 availableTetriminos.add(new Tetrimino_I(myGrid));
		 availableTetriminos.add(new Tetrimino_J(myGrid));
		 availableTetriminos.add(new Tetrimino_L(myGrid));	 	
		 availableTetriminos.add(new Tetrimino_O(myGrid));
		 availableTetriminos.add(new Tetrimino_S(myGrid));
		 availableTetriminos.add(new Tetrimino_T(myGrid));
		 availableTetriminos.add(new Tetrimino_Z(myGrid));
		 
		 Random r = new Random();
		 
		 return (Tetrimino) availableTetriminos.get(r.nextInt(availableTetriminos.size()));
	}
	
	public void addPoints(int lines) {
		int multiplier = 0;
		switch(lines) {
			case 1: 
				multiplier = 1;
				break;
			case 2: 
				multiplier = 2;
				break;
			case 3:
				multiplier = 5;
				break;
			case 4:
				multiplier = 8;
				break;
		}
		score += 100 * multiplier;	
		System.out.println(score);
	}
	
	public void increaseSpeed() {
		
		if (speed < 9 ) {
			speed++;
			step -= 100;
			currentTime.setStep(step);
		}
		
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

	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	
}
