
public class Grid {

	private int rows;
	private int columns;
	private Cell cellGrid [][];
	
	public Grid(int rows, int columns) {
		
		cellGrid = new Cell [rows][columns];
		
		for (int i = 0; i < rows; i++) 
			for (int j = 0; i < columns; j++) {
				cellGrid[i][j].setX(i);
				cellGrid[i][j].setY(j);
				cellGrid[i][j].setStateAsFree();
			}
			
	}
	
	public void clearRow(int y) {
		for (int i = 0; i < rows; i++)
			for (int j = y + 1; j < columns; j++) {
				cellGrid[i][j] = cellGrid[i][j-1];
				
			}
	}
	
	public void occupyCell(Cell cell) {
		cell.setStateAsTaken();
	}
	
	public void releaseCell(Cell cell) {
		cell.setStateAsFree();
	}
	
	// falta hacer
	public boolean checkFullRow(Cell [] cell) {
		return true;
	}
	
	
	
	
	
}
