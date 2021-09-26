import java.util.function.Supplier;

import javax.swing.ImageIcon;

public abstract class Tetrimino implements Supplier<Tetrimino> {
	
	protected int currentAngle = 0;
	protected ImageIcon cellImage;
	protected Grid myGrid;
	
	protected Cell w;
	protected Cell x;
	protected Cell y;
	protected Cell z;
	
	protected int xx;
	protected int xy;
	protected int yx;
	protected int yy;
	protected int zx;
	protected int zy;
	protected int wx;
	protected int wy;
	
	public Tetrimino(Grid myGrid) {
		this.myGrid = myGrid;
	}
	
	public abstract void initializeTetrimino();
	
	public abstract void moveToLeft();
	
	public abstract void moveToRight();
	
	public abstract void rotate();
	
	public abstract boolean moveDown();
	
	public int getAngle() {
		
		return currentAngle;
	}
	
//	public abstract void rotateIZQ();
	
	public void rotateIZQ() {
		rotate();
		rotate();
		rotate();
	}
	
	protected void setTetriminoCellsAsFree() {
		
		x.setStateAsFree();
		y.setStateAsFree();
		z.setStateAsFree();
		w.setStateAsFree();
	}
	
	protected void setTetriminoCellsAsTaken() {
		
		x.setStateAsTaken();
		y.setStateAsTaken();
		z.setStateAsTaken();
		w.setStateAsTaken();
	}
	
	
	protected void assignNewCellsToTetrimino(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
			
		x = myGrid.getCell(x1, y1, cellImage);
		y = myGrid.getCell(x2, y2, cellImage);
		z = myGrid.getCell(x3, y3, cellImage);
		w = myGrid.getCell(x4, y4, cellImage);
	}
	
	protected void refreshPositions() {
		
		xx = x.getXPosition();
		xy = x.getYPosition();
		yx = y.getXPosition();
		yy = y.getYPosition();
		zx = z.getXPosition();
		zy = z.getYPosition();
		wx = w.getXPosition();
		wy = w.getYPosition();
	}
	
	@Override
	public Tetrimino get() {
		return this;
	}
		
}
