import javax.swing.ImageIcon;

public class Tetrimino_O extends Tetrimino {

	public Tetrimino_O(Grid myGrid) {
		super(myGrid);
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/yellowCell.png")); //Cambiar color
	}
	
	public void initializeTetrimino() {
		
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
			
			x = myGrid.getCell(x.getXPosition(), x.getYPosition() - 1, cellImage);
			y = myGrid.getCell(y.getXPosition(), y.getYPosition() - 1, cellImage);
			z = myGrid.getCell(z.getXPosition(), z.getYPosition() - 1, cellImage);
			w = myGrid.getCell(w.getXPosition(), w.getYPosition() - 1, cellImage);
			
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
			
			x = myGrid.getCell(x.getXPosition(), x.getYPosition() + 1, cellImage);
			y = myGrid.getCell(y.getXPosition(), y.getYPosition() + 1, cellImage);
			z = myGrid.getCell(z.getXPosition(), z.getYPosition() + 1, cellImage);
			w = myGrid.getCell(w.getXPosition(), w.getYPosition() + 1, cellImage);
			
			setTetriminoCellsAsTaken();
		}
	}

	@Override
	public void rotate() {
		// No rota
		
	}

	@Override
	public boolean moveDown() {
		referenceCell = z;
		
		boolean valid = (myGrid.checkMoveVertical(referenceCell.getXPosition() + 1, referenceCell.getYPosition()) &&
						myGrid.checkMoveVertical(referenceCell.getXPosition() + 1, referenceCell.getYPosition() + 1));
		
		if(valid) {
			
			setTetriminoCellsAsFree();
			
			x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
			y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
			z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
			w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);

			
			setTetriminoCellsAsTaken();
			
		}
		
		return valid;
	}

	
}
