import javax.swing.ImageIcon;

public class Tetrimino_Z extends Tetrimino {
	public Tetrimino_Z(Grid myGrid) {
		super(myGrid);		
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/redCell.png"));
		x = myGrid.getCell(0, 3, cellImage);
		y = myGrid.getCell(0, 4, cellImage);
		z = myGrid.getCell(1, 4, cellImage);
		w = myGrid.getCell(1, 5, cellImage);
		
		setTetriminoCellsAsTaken();
	}

	@Override
	public void moveToLeft() {
		boolean validMove = false;
		switch(currentAngle) {
			case 0: 				
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition()-1));
				break;
			case 90:
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()-1) 
							&& myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()-1));
				break;
			case 180: 
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()-1));
				break;
			case 270:
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition()-1) 
						&& myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()-1));
				break;
		}	
		if (validMove) {
			setTetriminoCellsAsFree();				
			x = myGrid.getCell(x.getXPosition(), x.getYPosition() -1, cellImage);
			y = myGrid.getCell(y.getXPosition(), y.getYPosition() -1, cellImage);
			z = myGrid.getCell(z.getXPosition(), z.getYPosition() -1, cellImage);
			w = myGrid.getCell(w.getXPosition(), w.getYPosition() -1, cellImage);			
			setTetriminoCellsAsTaken();
		}
	}

	@Override
	public void moveToRight() {
		boolean validMove = false;
		switch(currentAngle) {
			case 0: 				
				validMove = ( myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()+1) &&   myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()+1));
				break;
			case 90:
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()+1) &&   myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition()+1) 
							&& myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()+1));
				break;
			case 180: 
				validMove = ( myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()+1) &&   myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition()+1));
				break;
			case 270:
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()+1) &&   myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()+1) 
						&& myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()+1));
				break;
		}	
		if (validMove) {
			setTetriminoCellsAsFree();				
			x = myGrid.getCell(x.getXPosition(), x.getYPosition() +1, cellImage);
			y = myGrid.getCell(y.getXPosition(), y.getYPosition() +1, cellImage);
			z = myGrid.getCell(z.getXPosition(), z.getYPosition() +1, cellImage);
			w = myGrid.getCell(w.getXPosition(), w.getYPosition() +1, cellImage);			
			setTetriminoCellsAsTaken();
		}
	}

	@Override
	public void rotate() {
		boolean block1 = false;
		boolean block2 = false;
		boolean block3 = false;
		boolean Flag = false;
		switch (currentAngle) {
			case 0:
				refPosX = z.getXPosition();
				refPosY = z.getYPosition();	
				block1 = myGrid.checkMoveVertical(refPosX + 1, refPosY - 1) && myGrid.checkMoveHorizontal(refPosX + 1, refPosY - 1);
				block2 = myGrid.checkMoveVertical(refPosX, refPosY - 1) && myGrid.checkMoveHorizontal(refPosX, refPosY - 1);
				if(block1 && block2) {
					setTetriminoCellsAsFree();
					x = myGrid.getCell(refPosX + 1, refPosY - 1, cellImage);
					y = myGrid.getCell(refPosX, refPosY - 1, cellImage);
					w = myGrid.getCell(refPosX - 1, refPosY, cellImage);	
					setTetriminoCellsAsTaken();
					Flag = true;
				}
				break;
			case 90:
				refPosX = z.getXPosition();
				refPosY = z.getYPosition();	
				block1 = myGrid.checkMoveVertical(refPosX - 1, refPosY - 1) && myGrid.checkMoveHorizontal(refPosX - 1, refPosY - 1);
				block2 = myGrid.checkMoveVertical(refPosX, refPosY + 1) && myGrid.checkMoveHorizontal(refPosX, refPosY + 1);
				if(block1 && block2) {
					setTetriminoCellsAsFree();
					x = myGrid.getCell(refPosX - 1, refPosY - 1, cellImage);
					y = myGrid.getCell(refPosX, refPosY, cellImage);
					z = myGrid.getCell(refPosX - 1, refPosY, cellImage);
					w = myGrid.getCell(refPosX, refPosY + 1, cellImage);	
					setTetriminoCellsAsTaken();
					Flag = true;
				}
				break;
			case 180:
				refPosX = y.getXPosition();
				refPosY = y.getYPosition();	
				block1 = myGrid.checkMoveVertical(refPosX, refPosY - 1) && myGrid.checkMoveHorizontal(refPosX, refPosY - 1);
				block2 = myGrid.checkMoveVertical(refPosX + 1, refPosY - 1) && myGrid.checkMoveHorizontal(refPosX, refPosY - 1);
				if(block1 && block2) {
					setTetriminoCellsAsFree();
					x = myGrid.getCell(refPosX -1 , refPosY, cellImage);
					z = myGrid.getCell(refPosX, refPosY - 1, cellImage);
					w = myGrid.getCell(refPosX + 1, refPosY - 1, cellImage);	
					setTetriminoCellsAsTaken();
					Flag = true;
				}
				break;
			case 270:
				refPosX = y.getXPosition();
				refPosY = y.getYPosition();	
				block1 = myGrid.checkMoveVertical(refPosX - 1, refPosY - 1) && myGrid.checkMoveHorizontal(refPosX - 1, refPosY - 1);
				block2 = myGrid.checkMoveVertical(refPosX , refPosY + 1) && myGrid.checkMoveHorizontal(refPosX, refPosY + 1);
				if(block1 && block2) {
					setTetriminoCellsAsFree();
					x = myGrid.getCell(refPosX - 1, refPosY - 1, cellImage);
					y = myGrid.getCell(refPosX - 1 , refPosY, cellImage); 
					w = myGrid.getCell(refPosX , refPosY + 1, cellImage);
					z = myGrid.getCell(refPosX, refPosY, cellImage);
					setTetriminoCellsAsTaken();
					Flag = true;
				}
				break;
				
		}
		if (Flag) {
			if (currentAngle<=180) {
				currentAngle+=90;
			}else
				currentAngle = 0;
		}
	}

	@Override
	public void moveDown() {
		boolean block1 = false;
		boolean block2 = false;
		boolean block3 = false;
		switch(currentAngle) {		
			case 0:
				block1 = myGrid.checkMoveVertical(x.getXPosition() + 1, x.getYPosition());
				block2 = myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition());
				block3 = myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition());
				break;			
			case 90:
				block1 = myGrid.checkMoveVertical(x.getXPosition() + 1, x.getYPosition());
				block2 = myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition());
				block3 = true;
				break;				
			case 180:				
				block1 = myGrid.checkMoveVertical(x.getXPosition() + 1, x.getYPosition());
				block2 = myGrid.checkMoveVertical(y.getXPosition() + 1, y.getYPosition());
				block3 = myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition());				
				break;				
			case 270:
				block1 = myGrid.checkMoveVertical(y.getXPosition() + 1, y.getYPosition());
				block2 = myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition());
				block3 = true;
				break;
				
		}
			if (block1 && block2 && block3) {						
				setTetriminoCellsAsFree();				
				x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
				y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
				z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
				w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);				
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
