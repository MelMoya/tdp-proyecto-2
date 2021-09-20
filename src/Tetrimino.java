
public abstract class Tetrimino {
	
	protected int actualAngle;
	protected Grid myGrid;
	
	protected Cell w;
	protected Cell x;
	protected Cell y;
	protected Cell z;
		
	
	public Tetrimino(Grid myGrid) {
		actualAngle = 0;
		this.myGrid = myGrid;
	}
	
	
	public abstract boolean moveToLeft();
	
	public abstract boolean moveToRight();
	
	public abstract boolean rotate();
	
	public abstract boolean moveToDown();
	
	public int getAngle() {
		
		return actualAngle;
	}
	
		
}
