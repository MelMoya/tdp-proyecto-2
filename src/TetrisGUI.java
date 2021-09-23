import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisGUI extends JFrame {
	
	private static int rows = 21;
	private static int columns = 10;
	
	private JPanel graphicPanel;
	private JLabel[][] graphicCells;
	private ImageIcon grassIcon = new ImageIcon("img/emptyCell.png"); 
	
	private JLabel currentTime;
	private JLabel score; 
	private JLabel currentCompletedLines;
	private Logic myLogic;
	
	public TetrisGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		graphicPanel = new JPanel(new GridLayout(rows, columns, 0, 0));
		graphicCells = new JLabel[rows][columns];
		
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < columns; j++) {
				graphicCells[i][j] = new JLabel();
				graphicCells[i][j].setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/emptyCell.png")));
				graphicPanel.add(graphicCells[i][j]);
			}
		
	//	currentTime.setText("0");
	//	score.setText("0");
	//	currentBrokenLines.setText("0");
		
		setContentPane(graphicPanel);
		
		super.pack();
		super.setVisible(true);
		myLogic = new Logic(this);
		
		this.addKeyListener(new KeyListener(){
            @Override
               public void keyPressed(KeyEvent e) {
                   if(e.getKeyCode() == KeyEvent.VK_DOWN){
                       myLogic.moveToDown();
                   }
                   
                   if(e.getKeyCode() == KeyEvent.VK_LEFT){
                       myLogic.moveToLeft();
                   }
                   
                   if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                       myLogic.moveToRight();
                   }
                   
                   if(e.getKeyCode() == KeyEvent.VK_UP) {
                	   myLogic.rotate();
                   }
                   
                   if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	   myLogic.moveToRight();
                   }
               }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}


       });
	}
	
	
	public void draw(int y, int x, ImageIcon image) {
		
		if (image != null) 
			graphicCells[x][y].setIcon(image);
		else 
			graphicCells[x][y].setIcon(grassIcon);

		System.out.println("X:"+x+" Y:"+y);
	}
	
	
	public int getRows() {
		
		return rows;	
	}
	
	public int getColumns() {
		
		return columns;
	}
	
	
}
