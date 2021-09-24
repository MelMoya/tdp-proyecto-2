import javax.swing.ImageIcon;

public class Tetrimino_L extends Tetrimino {

	public Tetrimino_L(Grid myGrid) {
		super(myGrid);
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/orangeCell.png"));
		
		x = myGrid.getCell(0, 4, cellImage);
		y = myGrid.getCell(1, 4, cellImage);
		z = myGrid.getCell(2, 4, cellImage);
		w = myGrid.getCell(2, 5, cellImage);
		
		setTetriminoCellsAsTaken();
	}

	@Override
	public void moveToLeft() {
		
		boolean valid = false;
		switch (currentAngle) {
		
		case 0:
			
			valid = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() - 1) &&
					myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition() - 1) &&
					myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() - 1);
			
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() - 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() - 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() - 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() - 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 90:
			
			valid = myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() - 1) &&
					myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition() - 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() - 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() - 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() - 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() - 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
		
		case 180:
			
			valid = myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() - 1) &&
					myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition() - 1) &&
					myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() - 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() - 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() - 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() - 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() - 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 270:
			
			valid = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() - 1) &&
					myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() - 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() - 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() - 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() - 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() - 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
		}
		
	}

	@Override
	public void moveToRight() {
		
		boolean valid = false;
		
		switch (currentAngle) {
		
		case 0:
			
			valid = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() + 1) &&
					myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition() + 1) &&
					myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() + 1);
			
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() + 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() + 1, cellImage);
				z = myGrid.getCell(w.getXPosition(), w.getYPosition(), cellImage);
				w = myGrid.getCell(z.getXPosition(), z.getYPosition() + 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 90:
			
			valid = myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() + 1) &&
					myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() + 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() + 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() + 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() + 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() + 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
		
		case 180:
			
			valid = myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() + 1) &&
					myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() + 1) &&
					myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() + 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() + 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() + 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() + 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() + 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 270:
			
			valid = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() + 1) &&
					myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() + 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition(), x.getYPosition() + 1, cellImage);
				y = myGrid.getCell(y.getXPosition(), y.getYPosition() + 1, cellImage);
				z = myGrid.getCell(z.getXPosition(), z.getYPosition() + 1, cellImage);
				w = myGrid.getCell(w.getXPosition(), w.getYPosition() + 1, cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
		}
		
	}

	@Override
	public void rotate() {
		boolean valid = false;

		switch (currentAngle) {
			
			case 0: 
				refPosX = y.getXPosition();
				refPosY = y.getYPosition();
				
				valid = myGrid.checkMoveHorizontal(refPosX, refPosY + 1) &&
						myGrid.checkMoveHorizontal(refPosX, refPosY + 2);
				
				if (valid) {
									
					setTetriminoCellsAsFree();
					
					x = myGrid.getCell(refPosX, refPosY + 1, cellImage);
					w = myGrid.getCell(refPosX, refPosY + 2, cellImage);
						
					setTetriminoCellsAsTaken();
					
					currentAngle = 90;
				}
					
				break;
					
			
			case 90:
				
				refPosX = x.getXPosition();
				refPosY = x.getYPosition();
				
				valid = myGrid.checkMoveVertical(refPosX + 1, refPosY) &&
						myGrid.checkMoveVertical(refPosX + 2, refPosY);
				
				if (valid) {
									
					setTetriminoCellsAsFree();
					
					w = myGrid.getCell(refPosX + 1, refPosY, cellImage);
					z = myGrid.getCell(refPosX + 2, refPosY, cellImage);
						
					setTetriminoCellsAsTaken();
					
					currentAngle = 180;
				}
				
				break;
				
		case 180:
				
				refPosX = w.getXPosition();
				refPosY = w.getYPosition();
				
				valid = myGrid.checkMoveHorizontal(refPosX, refPosY - 1) &&
						myGrid.checkMoveHorizontal(refPosX, refPosY - 2);
				
				if (valid) {
									
					setTetriminoCellsAsFree();
					
					y = myGrid.getCell(refPosX, refPosY - 1, cellImage);
					z = myGrid.getCell(refPosX, refPosY - 2, cellImage);
						
					setTetriminoCellsAsTaken();
					
					currentAngle = 270;
				}
				
				break;
				
		case 270:

			refPosX = y.getXPosition();
			refPosY = y.getYPosition();
			
			valid = myGrid.checkMoveVertical(refPosX - 2, refPosY) &&
					myGrid.checkMoveVertical(refPosX - 1, refPosY);
			
			if (valid) {
				
				setTetriminoCellsAsFree();
	
				x = myGrid.getCell(refPosX - 2, refPosY, cellImage);
				y = myGrid.getCell(refPosX - 1, refPosY, cellImage);
				z = myGrid.getCell(refPosX, refPosY, cellImage);
				
				setTetriminoCellsAsTaken();
				
				currentAngle = 0;
			}
			
			break; 
				  
		}
		
	}

	@Override
	public boolean moveDown() {
		boolean valid = false;
		
		switch (currentAngle) {
		
		case 0:
			
			valid = myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition()) &&
					myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition());
			
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
				y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
				z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
				w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 90:
			
			valid = myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition()) &&
					myGrid.checkMoveVertical(x.getXPosition() + 1, x.getYPosition()) &&
					myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition());
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
				y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
				z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
				w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
		
		case 180:
			
			valid = myGrid.checkMoveVertical(y.getXPosition() + 1, y.getYPosition()) &&
					myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition());
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
				y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
				z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
				w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);
				
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 270:
			
			valid = myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition()) &&
					myGrid.checkMoveVertical(y.getXPosition() + 1, y.getYPosition()) &&
					myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition());
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				
				x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
				y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
				z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
				w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);
		
				setTetriminoCellsAsTaken();
			}
			
			break;
		}
		
		return valid;
		
	}
	

}
