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
	}

	@Override
	public void moveToLeft() {
		
		
		boolean validMove = false;
	
		switch (currentAngle) {
			
			case 0:
			case 180:
				
				if (currentAngle == 0)
					validMove = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() - 1);
				else
					validMove = myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() - 1);
				
				if (validMove) {
			
					setTetriminoCellsAsFree();
					
					x = myGrid.getCell(x.getXPosition(), x.getYPosition() -1, cellImage);
					y = myGrid.getCell(y.getXPosition(), y.getYPosition() -1, cellImage);
					z = myGrid.getCell(z.getXPosition(), z.getYPosition() -1, cellImage);
					w = myGrid.getCell(w.getXPosition(), w.getYPosition() -1, cellImage);
			
					setTetriminoCellsAsTaken();
				}
				
				break;
				
			case 90:
			case 270:
				
				validMove = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() - 1) &&
							myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition() - 1) &&
							myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() - 1) &&
							myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() - 1); 
					
				if (validMove) {
					
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
		
		boolean validMove = false;
	
		switch (currentAngle) {
			
			case 0:
			case 180:
				System.out.println("xd");
				if (currentAngle == 0)
					validMove = myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() + 1);
				else
					validMove = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() + 1);
				
				if (validMove) {
			
					setTetriminoCellsAsFree();
					
					x = myGrid.getCell(x.getXPosition(), x.getYPosition() +1, cellImage);
					y = myGrid.getCell(y.getXPosition(), y.getYPosition() +1, cellImage);
					z = myGrid.getCell(z.getXPosition(), z.getYPosition() +1, cellImage);
					w = myGrid.getCell(w.getXPosition(), w.getYPosition() +1, cellImage);
			
					setTetriminoCellsAsTaken();
				}
				
				break;
				
			case 90:
			case 270:
				
				validMove = myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition() + 1) &&
							myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition() + 1) &&
							myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition() + 1) &&
							myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition() + 1); 
					
				if (validMove) {
					
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
		
		boolean validRotation = false;

		switch (currentAngle) {
			
			case 0: 
				refPosX = z.getXPosition();
				refPosY = z.getYPosition();
				z.setImage(cellImage2);
				
			//	System.out.println(myGrid.getCell(refPosX-2, refPosY+2, cellImage).getCurrentState());
				validRotation = refPosX > 1 && myGrid.checkMoveVertical(refPosX - 2, refPosY) &&
											   myGrid.checkMoveVertical(refPosX - 1, refPosY) &&
								 			   myGrid.checkMoveVertical(refPosX + 1, refPosY);
			//	System.out.println(validRotation);
				if (validRotation) {
									
					setTetriminoCellsAsFree();
					
					x = myGrid.getCell(refPosX - 2, refPosY, cellImage);
					y = myGrid.getCell(refPosX - 1, refPosY, cellImage);
					w = myGrid.getCell(refPosX + 1, refPosY, cellImage);;	
						
					setTetriminoCellsAsTaken();
					
					currentAngle = 90;
				}
					
				break;
					
			
			case 90:
				
				refPosX = z.getXPosition();
				refPosY = z.getYPosition();
				
				validRotation = myGrid.checkMoveHorizontal(refPosX, refPosY + 1) &&
								myGrid.checkMoveHorizontal(refPosX, refPosY - 1) && 
								myGrid.checkMoveHorizontal(refPosX, refPosY - 2);
				
				if (validRotation) {
					
					setTetriminoCellsAsFree();
			
					x = myGrid.getCell(refPosX, refPosY + 1, cellImage);
					y = myGrid.getCell(refPosX, refPosY - 1, cellImage);
					w = myGrid.getCell(refPosX, refPosY - 2, cellImage);;	
						
					
					setTetriminoCellsAsTaken();
					
					currentAngle = 180;
				}
				
				break;
				
		case 180:
				
				refPosX = y.getXPosition();
				refPosY = y.getYPosition();
			
				validRotation = myGrid.checkMoveVertical(refPosX - 2, refPosY) &&
								myGrid.checkMoveVertical(refPosX - 1, refPosY) && 
								myGrid.checkMoveVertical(refPosX + 1, refPosY);
				
				if (validRotation) {
					
					setTetriminoCellsAsFree();
		
					x = myGrid.getCell(refPosX - 2, refPosY, cellImage);
					z = myGrid.getCell(refPosX - 1, refPosY, cellImage);
					w = myGrid.getCell(refPosX + 1, refPosY, cellImage);;	
								
					setTetriminoCellsAsTaken();
					
					currentAngle = 270;
				}
				
				break;
				
		case 270:

			refPosX = y.getXPosition();
			refPosY = y.getYPosition();
			
			validRotation = myGrid.checkMoveHorizontal(refPosX, refPosY - 1) &&
							myGrid.checkMoveHorizontal(refPosX, refPosY + 1) &&
							myGrid.checkMoveHorizontal(refPosX, refPosY + 2);
			
			if (validRotation) {
				
				setTetriminoCellsAsFree();
	
				x = myGrid.getCell(refPosX, refPosY - 1, cellImage);
				z = myGrid.getCell(refPosX, refPosY + 1, cellImage);
				w = myGrid.getCell(refPosX, refPosY + 2, cellImage);;	
				
				setTetriminoCellsAsTaken();
				
				currentAngle = 0;
			}
			
			break; 
				  
		}
		
		// Si lo pones aca afuera el angulo va cambiando por mas que no pueda girarlo
//		if (currentAngle <= 180)
//			currentAngle += 90;
//		else
//			currentAngle = 0;
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
			
			setTetriminoCellsAsFree();
			
			x = myGrid.getCell(x.getXPosition() + 1, x.getYPosition(), cellImage);
			y = myGrid.getCell(y.getXPosition() + 1, y.getYPosition(), cellImage);
			z = myGrid.getCell(z.getXPosition() + 1, z.getYPosition(), cellImage);
			w = myGrid.getCell(w.getXPosition() + 1, w.getYPosition(), cellImage);

			
			/*x.setX(x.getXPosition() + 1);
			y.setX(y.getXPosition() + 1);
			z.setX(z.getXPosition() + 1);
			w.setX(w.getXPosition() + 1);*/
			
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
