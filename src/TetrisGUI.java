import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisGUI extends JFrame {
	
	private static int rows = 21;
	private static int columns = 10;
	
	private JPanel graphicPanel;
	private JLabel[][] graphicCells;
	private ImageIcon grassIcon = new ImageIcon(TetrisGUI.class.getResource("/img/emptyCell.png"));
	
//	private JLabel currentTime;
//	private JLabel score; 
//	private JLabel currentCompletedLines;
	private JLabel lblScore;
	private JLabel lblLines;
	private Logic myLogic;
	
	public TetrisGUI() {

		this.setSize(500, 1200);
        this.setMinimumSize(new Dimension(600, 800));
  
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		graphicPanel = new JPanel(new GridLayout(rows, columns, 0,0));
		graphicPanel.setBounds(182, 11, 229, 450);
		graphicCells = new JLabel[rows][columns];
		
		JPanel panel = new JPanel(); 
		graphicPanel.setPreferredSize(new Dimension(229,450));
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < columns; j++) {
				graphicCells[i][j] = new JLabel();
				graphicCells[i][j].setIcon(grassIcon);
				graphicPanel.add(graphicCells[i][j]);
			}
		
		
		setContentPane(panel);
		panel.setLayout(null);
		lblScore = new JLabel("0");
		lblScore.setBounds(31, 59, 46, 14);
		panel.add(lblScore);

		panel.add(graphicPanel);
		
		lblLines = new JLabel("0");
		lblLines.setBounds(31, 99, 46, 14);
		panel.add(lblLines);
		

		
		super.pack();
        this.setLocationRelativeTo(null);
		super.setVisible(true);
		myLogic = new Logic(this);
		startListener();
	}


	private void startListener() {
		this.addKeyListener(new KeyListener(){
			@Override
		
			
			public void keyPressed(KeyEvent e) {                 
              
				if (e.getKeyCode() == KeyEvent.VK_DOWN) 
                    myLogic.moveToDown();
                    
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                	myLogic.moveToLeft();
   
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
                    myLogic.moveToRight();
                
                if (e.getKeyCode() == KeyEvent.VK_UP) 
                	myLogic.rotate();
                
                if (e.getKeyCode() == KeyEvent.VK_Z) 
                	myLogic.rotateIZQ();
                   
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

		//System.out.println("X:"+x+" Y:"+y);
	}
	
	
	public int getRows() {
		
		return rows;	
	}
	
	public int getColumns() {
		
		return columns;
	}


	public void refreshDataGUI(int s, int l) {
		lblScore.setText(String.valueOf(s));
		lblLines.setText(String.valueOf(l));
		
	}
}
