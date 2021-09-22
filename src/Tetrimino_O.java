import javax.swing.ImageIcon;

public class Tetrimino_O extends Tetrimino {

	public Tetrimino_O(Grid myGrid) {
		super(myGrid);
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/yellowCell.png")); //Cambiar color
		
		x = myGrid.getCell(0, 4, cellImage);
		y = myGrid.getCell(0, 5, cellImage);
		z = myGrid.getCell(1, 4, cellImage);
		w = myGrid.getCell(1, 5, cellImage);
		
		setTetriminoCellsAsTaken();
	}

	@Override
	public void moveToLeft() {
		referenceCell = x;
		
		boolean valid = (myGrid.checkMoveHorizontal(referenceCell.getXPosition(), referenceCell.getYPosition() - 1) &&
				myGrid.checkMoveHorizontal(referenceCell.getXPosition() + 1, referenceCell.getYPosition() - 1));
		
		if (valid) {
			
			setTetriminoCellsAsFree();
			
			x.setY(x.getYPosition() - 1);
			y.setY(y.getYPosition() - 1);
			w.setY(w.getYPosition() - 1);
			z.setY(z.getYPosition() - 1);
			
			setTetriminoCellsAsTaken();
		}
	
	}

	@Override
	public void moveToRight() {
		referenceCell = y;

		boolean valid = (myGrid.checkMoveHorizontal(referenceCell.getXPosition(), referenceCell.getYPosition() + 1) &&
				myGrid.checkMoveHorizontal(referenceCell.getXPosition() + 1, referenceCell.getYPosition() + 1));

		if (valid) {
			
			setTetriminoCellsAsFree();
			
			x.setY(x.getYPosition() + 1);
			y.setY(y.getYPosition() + 1);
			w.setY(w.getYPosition() + 1);
			z.setY(z.getYPosition() + 1);
			
			setTetriminoCellsAsTaken();
		}
	}

	@Override
	public void rotate() {
		// No rota
		
	}

	@Override
	public void moveDown() {
		referenceCell = z;
		
		boolean valid = (myGrid.checkMoveVertical(referenceCell.getXPosition() + 1, referenceCell.getYPosition()) &&
						myGrid.checkMoveVertical(referenceCell.getXPosition() + 1, referenceCell.getYPosition() + 1));
		
		if(valid) {
			
			setTetriminoCellsAsFree();
			
			x.setX(x.getXPosition() + 1);
			y.setX(y.getXPosition() + 1);
			z.setX(z.getXPosition() + 1);
			w.setX(w.getXPosition() + 1);
			
			setTetriminoCellsAsTaken();
			
		}
		
	}
	
	private void setTetriminoCellsAsFree() {
		
		x.setStateAsFree();
		y.setStateAsFree();
		z.setStateAsFree();
		w.setStateAsFree();
	}
	
	private void setTetriminoCellsAsTaken() {
		
		x.setStateAsTaken();
		y.setStateAsTaken();
		z.setStateAsTaken();
		w.setStateAsTaken();
	}

}
