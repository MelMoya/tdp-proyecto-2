import java.util.function.Supplier;

import javax.swing.ImageIcon;

public class Tetrimino_J extends Tetrimino implements Supplier<Tetrimino>{

	public Tetrimino_J(Grid myGrid) {
		super(myGrid);
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/blueCell.png"));
	}
	
	public void initializeTetrimino() {
		assignNewCellsToTetrimino(0, 5, 1, 5, 2, 5, 2, 4);		
		setTetriminoCellsAsTaken();
	}

	@Override
	public void moveToLeft() {
		
		refreshPositions();
		boolean valid = false;
		switch (currentAngle) {
		
		case 0:
			
			valid = myGrid.checkMoveHorizontal(xx, xy - 1) &&
					myGrid.checkMoveHorizontal(yx, yy - 1) &&
					myGrid.checkMoveHorizontal(wx, wy - 1);
			
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy - 1, yx, yy - 1, zx, zy - 1, wx, wy - 1);
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 90:
			
			valid = myGrid.checkMoveHorizontal(xx, xy - 1) &&
					myGrid.checkMoveHorizontal(yx, yy - 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy - 1, yx, yy - 1, zx, zy - 1, wx, wy - 1);		
				setTetriminoCellsAsTaken();
			}
			
			break;
		
		case 180:
			
			valid = myGrid.checkMoveHorizontal(xx, xy - 1) &&
					myGrid.checkMoveHorizontal(yx, yy - 1) &&
					myGrid.checkMoveHorizontal(zx, zy - 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy - 1, yx, yy - 1, zx, zy - 1, wx, wy - 1);
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 270:
			
			valid = myGrid.checkMoveHorizontal(xx, xy - 1) &&
					myGrid.checkMoveHorizontal(wx, wy - 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy - 1, yx, yy - 1, zx, zy - 1, wx, wy - 1);		
				setTetriminoCellsAsTaken();
			}
			
			break;
		}
		
	}

	@Override
	public void moveToRight() {
		
		refreshPositions();
		boolean valid = false;
		
		switch (currentAngle) {
		
		case 0:
			
			valid = myGrid.checkMoveHorizontal(xx, xy + 1) &&
					myGrid.checkMoveHorizontal(yx, yy + 1) &&
					myGrid.checkMoveHorizontal(zx, zy + 1);
			
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy + 1, yx, yy + 1, zx, zy + 1, wx, wy + 1);
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 90:
			
			valid = myGrid.checkMoveHorizontal(xx, xy + 1) &&
					myGrid.checkMoveHorizontal(wx, wy + 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy + 1, yx, yy + 1, zx, zy + 1, wx, wy + 1);
				setTetriminoCellsAsTaken();
			}
			
			break;
		
		case 180:
			
			valid = myGrid.checkMoveHorizontal(wx, wy + 1) &&
					myGrid.checkMoveHorizontal(yx, yy + 1) &&
					myGrid.checkMoveHorizontal(zx, zy + 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy + 1, yx, yy + 1, zx, zy + 1, wx, wy + 1);
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 270:
			
			valid = myGrid.checkMoveHorizontal(zx, zy + 1) &&
					myGrid.checkMoveHorizontal(wx, wy + 1);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx, xy + 1, yx, yy + 1, zx, zy + 1, wx, wy + 1);
				setTetriminoCellsAsTaken();
			}
			
			break;
		}
		
	}

	@Override
	public void rotate() {
		
		refreshPositions();
		boolean valid = false;

		switch (currentAngle) {
			
			case 0: 				
				valid = myGrid.checkMoveHorizontal(yx, yy - 1) &&
						myGrid.checkMoveHorizontal(yx, yy + 1);
				
				if (valid) {
									
					setTetriminoCellsAsFree();
					
					assignNewCellsToTetrimino(yx - 1, yy - 1, yx, yy - 1, yx, yy, yx, yy + 1);						
					setTetriminoCellsAsTaken();
					
					currentAngle = 90;
				}
					
				break;
					
			
			case 90:
				
				valid = myGrid.checkMoveVertical(yx + 1, yy) &&
						myGrid.checkMoveHorizontal(yx - 1, yy + 1);
				
				if (valid) {
									
					setTetriminoCellsAsFree();
					assignNewCellsToTetrimino(xx, xy, yx, yy, yx + 1, yy, yx - 1, yy + 1);					
					setTetriminoCellsAsTaken();
					
					currentAngle = 180;
				}
				
				break;
				
		case 180:
				
				valid = myGrid.checkMoveHorizontal(yx, yy - 1) &&
						myGrid.checkMoveHorizontal(yx + 1, yy + 1);
				
				if (valid) {
									
					setTetriminoCellsAsFree();
					assignNewCellsToTetrimino(yx, yy - 1, yx, yy, yx, yy + 1, yx + 1, yy + 1);	
					setTetriminoCellsAsTaken();
					
					currentAngle = 270;
				}
				
				break;
				
		case 270:
			valid = myGrid.checkMoveHorizontal(yx + 1, yy) &&
					myGrid.checkMoveHorizontal(yx - 1, yy + 1);
			
			if (valid) {
				
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(yx - 1, yy + 1, zx, zy, wx, wy, yx + 1, yy);				
				setTetriminoCellsAsTaken();
				
				currentAngle = 0;
			}
			
			break; 
				  
		}
		
	}

	@Override
	public boolean moveDown() {
		
		refreshPositions();
		boolean valid = false;
		
		switch (currentAngle) {
		
		case 0:
			
			valid = myGrid.checkMoveVertical(zx + 1, zy) &&
					myGrid.checkMoveVertical(wx + 1, wy);
			
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx + 1, xy, yx + 1, yy, zx + 1, zy, wx + 1, wy);
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 90:
			
			valid = myGrid.checkMoveVertical(zx + 1, zy) &&
					myGrid.checkMoveVertical(yx + 1, yy) &&
					myGrid.checkMoveVertical(wx + 1, wy);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx + 1, xy, yx + 1, yy, zx + 1, zy, wx + 1, wy);		
				setTetriminoCellsAsTaken();
			}
			
			break;
		
		case 180:
			
			valid = myGrid.checkMoveVertical(wx + 1, wy) &&
					myGrid.checkMoveVertical(zx + 1, zy);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx + 1, xy, yx + 1, yy, zx + 1, zy, wx + 1, wy);				
				setTetriminoCellsAsTaken();
			}
			
			break;
			
		case 270:
			
			valid = myGrid.checkMoveVertical(xx + 1, xy) &&
					myGrid.checkMoveVertical(yx + 1, yy) &&
					myGrid.checkMoveVertical(wx + 1, wy);
	
			if (valid) {
		
				setTetriminoCellsAsFree();
				assignNewCellsToTetrimino(xx + 1, xy, yx + 1, yy, zx + 1, zy, wx + 1, wy);
				setTetriminoCellsAsTaken();
			}
			
			break;
		}
		
		return valid;
		
	}


}
