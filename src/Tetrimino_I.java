import javax.swing.ImageIcon;

public class Tetrimino_I extends Tetrimino{
	
	public Tetrimino_I(Grid myGrid) {
		
		super(myGrid);			
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/yellowCell.png"));
	
		x = myGrid.getCell(0, 3, cellImage);
		y = myGrid.getCell(0, 4, cellImage);
		z = myGrid.getCell(0, 5, cellImage);
		w = myGrid.getCell(0, 6, cellImage);
		
		w.setStateAsTaken();
		y.setStateAsTaken();
		z.setStateAsTaken();
		x.setStateAsTaken();
	}

	@Override
	public void moveToLeft() {
		

		if (currentAngle == 0)
			
			referenceCell = x;
		
			if (myGrid.checkMoveHorizontal(referenceCell.getXPosition(), referenceCell.getYPosition() - 1)) {
			
				w.setStateAsFree();
			
				w.setY(w.getYPosition() - 1);
				x.setY(x.getYPosition() - 1);
				y.setY(y.getYPosition() - 1);
				z.setY(z.getYPosition() - 1);
			
				x.setStateAsTaken();
		 }
	
		
	
	}

	@Override
	public void moveToRight() {

	}

	@Override
	public void rotate() {
		
		boolean validRotation = false;
		

		switch (currentAngle) {

			
			
			case 0: 
					
					setTetriminoCellsAsFree();
					
					validRotation = myGrid.checkMoveVertical(z.getXPosition() - 2, z.getYPosition()) &&
									myGrid.checkMoveVertical(z.getXPosition() - 1, z.getYPosition()) &&
									myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition()) ;
					
					if (validRotation) {
											
						x.setX(z.getXPosition() - 2);
						x.setY(z.getYPosition());
						y.setX(z.getXPosition() - 1);
						y.setY(z.getYPosition());
						w.setX(z.getXPosition() + 1);
						w.setY(z.getYPosition());		
					}
					
					setTetriminoCellsAsTaken();
		}
		
		
		if (currentAngle <= 270)
			currentAngle += 90;
		else
			currentAngle = 0;
		

	}

	@Override
	public void moveDown() {
		
		boolean validMove = false;
		
		if (currentAngle == 0)		
		
		validMove = ((myGrid.checkMoveVertical(x.getXPosition() + 1, x.getYPosition())) &&
					(myGrid.checkMoveVertical(y.getXPosition() + 1, y.getYPosition())) &&
					(myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition())) &&
					(myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition())));
		
		if (validMove) {		
			
			x.setStateAsFree();
			y.setStateAsFree();
			z.setStateAsFree();
			w.setStateAsFree();
			
			x.setX(x.getXPosition() +1);
			y.setX(y.getXPosition() + 1);
			z.setX(z.getXPosition() + 1);
			w.setX(w.getXPosition() + 1);
			
			x.setStateAsTaken();
			y.setStateAsTaken();
			z.setStateAsTaken();
			w.setStateAsTaken();
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
