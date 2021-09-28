import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;
import javax.swing.ImageIcon;

public class Logic {
	
	private Grid myGrid;
	private TetrisGUI myGUI;
	private Tetrimino currentTetrimino;
	private Tetrimino nextTetrimino;
	private Time myTime;
	
	private boolean gameOver = false;
	private int counter = 0;
	private int currentCompletedLines = 0;
	private String currentTime = "0:0";
	private int score = 0;
	private int speed = 1;
	private int step = 1000;


	public Logic(TetrisGUI myGUI) {
			
		this.myGUI = myGUI;
		myTime = new Time(this, step);
		myTime.start();
		myGrid = new Grid(myGUI.getRows(), myGUI.getColumns(), this);
		currentTetrimino = createNewTetrimino();
		currentTetrimino.initializeTetrimino();
		nextTetrimino = createNewTetrimino();	
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
		
		switch (lines) {
			
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
		myGUI.refreshDataGUI(score, currentCompletedLines);
	}
	
	public void increaseSpeed() {
		
		if (speed < 9 && step - 50 > 50 ) {
			speed++;
			step -= 50;
			myTime.setStep(step);
		}
		
	}
	
	public void moveToLeft() {
		
		if (!gameOver)
			currentTetrimino.moveToLeft();
	}
	
	public void moveToRight() {
		
		if (!gameOver)
			currentTetrimino.moveToRight();
	}
	
	public void moveToDown() {
		counter++;
		if (counter == 10) {
			increaseSpeed();
			counter = 0;
		}
		
		int removedLines = 0;
	 
		if (!gameOver && !currentTetrimino.moveDown()) {
			
			if (!checkIfCanContinue()) {
				removedLines = myGrid.removeLines();
				currentTetrimino = nextTetrimino;
				nextTetrimino = createNewTetrimino();
				myGUI.refreshNextTetriminoLabel(nextTetrimino.getClass().getName());
				currentTetrimino.initializeTetrimino();
				currentCompletedLines += removedLines;
				addPoints(removedLines);
			}
			
			else 		
				gameOver();	
			
	  }
		

	}
	
	private boolean checkIfCanContinue() {
		
		boolean stop = false;
		for (int j = 0; j < myGUI.getColumns() && !stop; j++)
			stop = myGrid.getCell(0, j).getCurrentState() == true;
		
		return stop;		
	}
	
	public void rotate() {
		
		if (!gameOver)
			currentTetrimino.rotate();
	}
	
	public void rotateIZQ() {

		if (!gameOver)
			currentTetrimino.rotateIZQ();
	}
	
	public void gameOver() {	
		
		currentTetrimino = null;
		nextTetrimino = null;
		gameOver = true;
		myTime.stopTime();
		myGUI.showGameOver();
	}
	
	public void refreshGUI(int y, int x, ImageIcon image) {
		myGUI.draw(x, y, image);
	}
	
	public void refreshData(int s,int l) {
		myGUI.refreshDataGUI(s,l);
	}
	
	public void restartLogic() {
		currentCompletedLines = 0;
		gameOver = false;
		counter = 0;
		score = 0;
		speed = 1;
		step = 1000;
		myGrid.restartGrid();
		currentTetrimino = createNewTetrimino();
		nextTetrimino = createNewTetrimino();
		currentTetrimino.initializeTetrimino();
		//RESTART TIMER
	}
	
	
	public int getCurrentScore() {
		
		return score;
	}
	
	public int getCurrentCompletedLines() {
		
		return currentCompletedLines;
	}

	public int getSpeed() {
		return speed;
	}

	public String getNameOfNextTetrimino() {
		
		return nextTetrimino.getClass().getName();
		
	}
	
//	public String getCurrentTime() {
//		
//		int seconds = (int) (this.currentTime / 1000);
//		
//		int minutes = (int) seconds / 60;
//		
//		return minutes + ":" + seconds;
//	}

	public void setTime(String time) {
		
		this.currentTime = time;
		
		myGUI.refreshTime(currentTime);
	}

	
}
