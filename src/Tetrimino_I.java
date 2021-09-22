import javax.swing.ImageIcon;

public class Tetrimino_I extends Tetrimino{
	
	public Tetrimino_I(Grid myGrid) {
		
		super(myGrid);			
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/yellowCell.png"));
		cellImage2 = new ImageIcon(TetrisGUI.class.getResource("/img/redCell.png"));
	
		x = myGrid.getCell(0, 3, cellImage);
		y = myGrid.getCell(0, 4, cellImage);
		z = myGrid.getCell(0, 5, cellImage);
		w = myGrid.getCell(0, 6, cellImage);
		
		w.setStateAsTaken();
		y.setStateAsTaken();
		z.setStateAsTaken();
		x.setStateAsTaken();
		z.setImage(cellImage2);
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
				
				refPosX = z.getXPosition();
				refPosY = z.getYPosition();
				
				validRotation = myGrid.checkMoveVertical(refPosX - 2, refPosY) &&
								myGrid.checkMoveVertical(refPosX - 1, refPosY) &&
								myGrid.checkMoveVertical(refPosX + 1, refPosY);
					
				if (validRotation) {
									
					setTetriminoCellsAsFree();
						
					x.setX(refPosX - 2);
					x.setY(refPosY);
					y.setX(refPosX - 1);
					y.setY(refPosY);
					w.setX(refPosX + 1);
					w.setY(refPosY);	
						
					setTetriminoCellsAsTaken();
				}
					
				break;
					
			
			case 90:
				
				refPosX = z.getXPosition();
				refPosY = z.getYPosition();
				
				validRotation = myGrid.checkMoveHorizontal(refPosX, refPosY + 1) &&
								myGrid.checkMoveHorizontal(refPosX, refPosY ) &&
								myGrid.checkMoveHorizontal(refPosX, refPosY - 1) && 
								myGrid.checkMoveHorizontal(refPosX, refPosY - 2);
				
				if (validRotation) {
					
					setTetriminoCellsAsFree();
		
					x.setX(refPosX);
					x.setY(refPosY - 2);
					y.setX(refPosX);
					y.setY(refPosY - 1);
					w.setX(refPosX);
					w.setY(refPosY + 1);	
					
					setTetriminoCellsAsTaken();
				}
				
				break;
				
		case 180:
				
				refPosX = y.getXPosition();
				refPosY = y.getYPosition();
			
				validRotation = myGrid.checkMoveVertical(refPosX - 2, refPosY) &&
								myGrid.checkMoveVertical(refPosX - 1, refPosY) &&
								myGrid.checkMoveVertical(refPosX, refPosY) && 
								myGrid.checkMoveVertical(refPosX + 1, refPosY);
				
				if (validRotation) {
					
					setTetriminoCellsAsFree();
		
					x.setX(refPosX - 2);
					x.setY(refPosY);
					z.setX(refPosX - 1);	
					z.setY(refPosY );	
					w.setX(refPosX + 1);
					w.setY(refPosY);	
					
					setTetriminoCellsAsTaken();
				}
				
				break;
				
		case 270:

			refPosX = y.getXPosition();
			refPosY = y.getYPosition();
			
			validRotation = myGrid.checkMoveHorizontal(refPosX, refPosY - 1) &&
							myGrid.checkMoveHorizontal(refPosX, refPosY + 1) &&
							myGrid.checkMoveHorizontal(refPosX, refPosY) && 
							myGrid.checkMoveHorizontal(refPosX, refPosY + 2);
			
			if (validRotation) {
				
				setTetriminoCellsAsFree();
	
				x.setX(refPosX);
				x.setY(refPosY- 1);
				z.setX(refPosX);
				z.setY(refPosY   + 1);
				w.setX(refPosX);
				w.setY(refPosY + 2);	
				
				setTetriminoCellsAsTaken();
			}
			
			break; 
				  
		}
		
		
		
		if (currentAngle <= 180)
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
					(myGrid.checkMoveVertical(refPosY + 1, z.getYPosition())) &&
					(myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition())));
		
		if (validMove) {		
			
			setTetriminoCellsAsFree();
			
			x.setX(x.getXPosition() +1);
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
