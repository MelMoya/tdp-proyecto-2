import javax.swing.ImageIcon;

public class Tetrimino_T extends Tetrimino {


	public Tetrimino_T(Grid myGrid) {
		
		super(myGrid);			
		cellImage = new ImageIcon(TetrisGUI.class.getResource("/img/violetCell.png"));
		
	
		x = myGrid.getCell(0, 4, cellImage);
		y = myGrid.getCell(1, 3, cellImage);
		z = myGrid.getCell(1, 4, cellImage);
		w = myGrid.getCell(1, 5, cellImage);
		
		setTetriminoCellsAsTaken();
	}

	@Override
	public void moveToLeft() {
		boolean validMove = false;
		switch(currentAngle) {
			case 0: 
				
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()-1));
				break;
			case 90:
				validMove = ( myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition()-1) &&   myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()-1) 
							&& myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()-1));
				break;
			case 180: 
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()-1));
				break;
			case 270:
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()-1) &&   myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()-1) 
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
				
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()+1) &&  myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()+1));
				break;
			case 90:
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()+1) && myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()+1) 
							&& myGrid.checkMoveHorizontal(w.getXPosition(), w.getYPosition()+1));
				break;
			case 180: 
				validMove = ( myGrid.checkMoveHorizontal(x.getXPosition(), x.getYPosition()+1) && myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()+1));
				break;
			case 270:
				validMove = ( myGrid.checkMoveHorizontal(z.getXPosition(), z.getYPosition()+1) && myGrid.checkMoveHorizontal(y.getXPosition(), y.getYPosition()+1) 
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
		
		refPosX = z.getXPosition();
		refPosY = z.getYPosition();
		
		
		boolean validRotation = false;
								
			switch (currentAngle) {
				//FACTORIZAR CODIGO
				case 0: 
					
					validRotation = myGrid.checkMoveVertical(refPosX + 1, refPosY); 
					System.out.println("0 ValidRotation: "+validRotation);
					if (validRotation) {
										
						setTetriminoCellsAsFree();
							
						
						y = myGrid.getCell(x.getXPosition(), x.getYPosition(), cellImage);
						x = myGrid.getCell(w.getXPosition(), w.getYPosition(), cellImage);
						w = myGrid.getCell(refPosX+1, refPosY, cellImage);
						
						setTetriminoCellsAsTaken();
					}
						
					break;
				
				case 90:
					
					validRotation = myGrid.checkMoveHorizontal(refPosX, refPosY-1);
					System.out.println("90 ValidRotation: "+validRotation);
					if (validRotation) {
										
						setTetriminoCellsAsFree();
							
						
						y = myGrid.getCell(x.getXPosition(), x.getYPosition(), cellImage);
						x = myGrid.getCell(w.getXPosition(), w.getYPosition(), cellImage);
						w = myGrid.getCell(refPosX, refPosY-1, cellImage);
						
						setTetriminoCellsAsTaken();
					}
						
					break;
				
				case 180:
					
					validRotation = myGrid.checkMoveVertical(z.getXPosition()-1,z.getYPosition());
					System.out.println("180 ValidRotation: "+validRotation);
					if (validRotation) {
										
						setTetriminoCellsAsFree();

						y = myGrid.getCell(x.getXPosition(), x.getYPosition(), cellImage);
						x = myGrid.getCell(w.getXPosition(), w.getYPosition(), cellImage);
						w = myGrid.getCell(refPosX-1, refPosY, cellImage);	
						
						
						setTetriminoCellsAsTaken();
					}
						
					break;
				
				case 270:
					
					validRotation = myGrid.checkMoveHorizontal(refPosX, refPosY+1);
					System.out.println("270 ValidRotation: "+validRotation);
					if (validRotation) {
										
						setTetriminoCellsAsFree();

						y = myGrid.getCell(x.getXPosition(), x.getYPosition(), cellImage);
						x = myGrid.getCell(w.getXPosition(), w.getYPosition(), cellImage);
						w = myGrid.getCell(refPosX, refPosY+1, cellImage);
						
						setTetriminoCellsAsTaken();
					}
						
					break;
				
			}
			if (validRotation) {
				if (currentAngle<=180) {
					currentAngle+=90;
				}else
					currentAngle = 0;
			}
		}	

	@Override
	public void moveDown() {
		
		boolean validMove = false;
		switch(currentAngle) {		

			case 0:
				validMove = ( (myGrid.checkMoveVertical(y.getXPosition() + 1, y.getYPosition())) &&
						(myGrid.checkMoveVertical(z.getXPosition() + 1, z.getYPosition())) &&
						(myGrid.checkMoveVertical(w.getXPosition() + 1, w.getYPosition())) ); 
				break;
				
			case 90:
				validMove = (myGrid.checkMoveVertical(x.getXPosition()+1, x.getYPosition()) && myGrid.checkMoveVertical(w.getXPosition()+1, w.getYPosition()));
				break;
				
			case 180:
				
					validMove = (myGrid.checkMoveVertical(x.getXPosition()+1, x.getYPosition()) && myGrid.checkMoveVertical(w.getXPosition()+1, w.getYPosition()) 
							&& myGrid.checkMoveVertical(y.getXPosition()+1, y.getYPosition()));
				
				break;
				
			case 270:
				validMove = (myGrid.checkMoveVertical(x.getXPosition()+1, x.getYPosition()) && myGrid.checkMoveVertical(y.getXPosition()+1, y.getYPosition()));
		}
			if (validMove) {		
				
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

// FALTA CONTROL DE MOVIMIENTO EN EL FONDO, PERO ESO SE TIENE QUE CONTROLAR CON EL MOVEDOWN QUE SE HACE EN BASE DEL TIEMPO Y LA VELOCIDAD
	
}
