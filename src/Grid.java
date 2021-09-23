import javax.swing.ImageIcon;

public class Grid {

	private int rows;
	private int columns;
	
	private Cell cellGrid [][];
	private Logic myLogic;
	
	public Grid(int rows, int columns, Logic myLogic) {
		
		this.rows = rows;
		this.columns = columns;
		
		this.myLogic = myLogic;
		cellGrid = new Cell [rows][columns];
	
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < columns; j++) {
				cellGrid[i][j] = new Cell(i,j, null, this);
			}
			
	}
	
	public void clearRow(int y) {
		for (int i = 0; i < rows; i++)
			for (int j = y + 1; j < columns; j++) {
				cellGrid[i][j] = cellGrid[i][j-1];
				
			}
	}
	
	public void occupyCell(Cell cell) {

		myLogic.refreshGUI(cell.getXPosition(), cell.getYPosition(), cell.getImage());
	}
	
	public void releaseCell(Cell cell) {

		myLogic.refreshGUI(cell.getXPosition(), cell.getYPosition(), null);
	}
	
	// falta hacer
	public boolean checkFullRow(Cell [] cell) {
		return true;
	}
	
	public boolean checkMoveHorizontal(int x, int y) {
		
		

	//	System.out.println("bool:" + ((y >= 0 && y < columns)));
	//	System.out.println("YYY:"+y);
		return (y >= 0 && y < columns) && (cellGrid[x][y].getCurrentState() == false) ? true : false;
		
		
	}
	
	public boolean checkMoveVertical(int x, int y) {
		
		

	//	System.out.println("bool:" + ((y >= 0 && y < columns)));

		return (x >= 0 && x < rows) && (cellGrid[x][y].getCurrentState() == false) ? true : false;
		
		
	}
	

	public Cell getCell(int x, int y, ImageIcon cellImage) {

		cellGrid[x][y].setImage(cellImage);
		return cellGrid[x][y];
	}
	
	public Cell getCell(int x, int y) {

		return cellGrid[x][y];
	}
	
	
	
	
	
}
