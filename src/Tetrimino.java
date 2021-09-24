import javax.swing.ImageIcon;

public abstract class Tetrimino {
	
	protected int currentAngle;
	protected ImageIcon cellImage;
	protected ImageIcon cellImage2;
	protected Grid myGrid;
	
	protected Cell w;
	protected Cell x;
	protected Cell y;
	protected Cell z;
	protected Cell referenceCell;
	
	protected int refPosX;
	protected int refPosY;
	
	public Tetrimino(Grid myGrid) {
		currentAngle = 0;
		this.myGrid = myGrid;
	}
	
	
	public abstract void moveToLeft();
	
	public abstract void moveToRight();
	
	public abstract void rotate();
	
	public abstract void moveDown();
	
	public int getAngle() {
		
		return currentAngle;
	}
	
	public void rotateIZQ() {
		rotate();
		rotate();
		rotate();
	}
	
		
}
