
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class TetrisGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final static int rows = 21;
	private final static int columns = 10;
	private Logic myLogic;
	
	private ImageIcon grassIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(TetrisGUI.class.getResource("/img/cells/emptyCell.png")));
	private JPanel graphicPanel;
	private JPanel panel = new JPanel(); 
	private JLabel[][] graphicCells;
	private JLabel lblGameOver;
	private JLabel lblLines;
	private JLabel lblLinesText;
	private JLabel lblNextTetrimino;
	private JLabel lblRetry;
	private JLabel lblScore;
	private JLabel lblScoreText;
	private JLabel lblTime = new JLabel("0:0");
	private JLabel lblfinalResults;
	
	public TetrisGUI() {
	
		setUpWindow();
		setUpGrid();
		myLogic = new Logic(this);
		setUpLabels();
	
		refreshNextTetriminoLabel(myLogic.getNameOfNextTetrimino());
		
		super.setVisible(true);
		super.pack();
        setLocationRelativeTo(null);
        
        startListener();

	}
	
	private void setUpWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.BLACK);
        setMinimumSize(new Dimension(600, 800)); 
		setUndecorated(true);
		setResizable(false);

	}
	
	private void setUpGrid() {
		
		graphicPanel = new JPanel(new GridLayout(rows, columns, 0,0));
		graphicPanel.setBounds(30,36, 300,630);
		graphicCells = new JLabel[rows][columns];
		
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < columns; j++) {
				graphicCells[i][j] = new JLabel();
				graphicCells[i][j].setIcon(grassIcon);
				graphicPanel.add(graphicCells[i][j]);
			}
		
	
		setContentPane(panel);
        this.getContentPane().setBackground(Color.BLACK);
		panel.setLayout(null);
		
		lblGameOver = new JLabel("");
		lblGameOver.setVerticalAlignment(SwingConstants.TOP);
		lblGameOver.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameAssets/gameOverSign.png")));
		lblGameOver.setBounds(10, 307, 565, 130);
		lblGameOver.setVisible(false);
		panel.add(lblGameOver);	
		
		lblfinalResults = new JLabel("", SwingConstants.CENTER);
		lblfinalResults.setForeground(Color.RED);
		lblfinalResults.setFont(new Font("Agency FB", Font.PLAIN, 40));
		lblfinalResults.setBackground(Color.BLACK);
		lblfinalResults.setBounds(30, 459, 545, 100);
		panel.add(lblfinalResults);
		panel.add(graphicPanel);
  
	}
	
	private void setUpLabels() {
		
		JLabel lblClose = new JLabel("");
	    lblClose.addMouseMotionListener(new MouseMotionAdapter() {
	    	public void mouseDragged(MouseEvent arg0) {
	    		dispose();
	    		System.exit(EXIT_ON_CLOSE);
	        }
	    });
	    lblClose.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameAssets/close.png")));
	    lblClose.setBounds(550, 11, 46, 30);
	
		lblLines = new JLabel("0");
		lblLines.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblLines.setForeground(Color.WHITE);
		lblLines.setBounds(431, 459, 46, 33);
		
	    lblLinesText = new JLabel("Lines");
	    lblLinesText.setForeground(Color.WHITE);
	    lblLinesText.setFont(new Font("Agency FB", Font.PLAIN, 27));
	    lblLinesText.setBounds(373, 380, 125, 57);
	    
		lblNextTetrimino = new JLabel("");
	    lblNextTetrimino.setBounds(398, 163, 100, 100);
	    
	    JLabel lblNextTetriminoText = new JLabel("Next");
	    lblNextTetriminoText.setForeground(Color.WHITE);
	    lblNextTetriminoText.setFont(new Font("Agency FB", Font.PLAIN, 27));
	    lblNextTetriminoText.setBounds(373, 95, 125, 57);
	    
	    lblRetry = new JLabel("");
	    lblRetry.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameAssets/retry2.png")));
	    lblRetry.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent arg0) {
            	restartGame();
            }

			private void restartGame() {
				//parar y reiniciar el tiempo
				System.out.println("RESTART");
				lblScore.setText("0");
				lblLines.setText("0");
				lblGameOver.setVisible(false);
				lblRetry.setVisible(false);
				lblfinalResults.setVisible(false);
				myLogic.restartLogic();
				
			}
        });
	    lblRetry.setVisible(false);
	    lblRetry.setBounds(507, 11, 46, 30);
		
		lblScore = new JLabel("0");
		lblScore.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(431, 342, 46, 33);
		
		lblScoreText = new JLabel("Score");
	    lblScoreText.setFont(new Font("Agency FB", Font.PLAIN, 27));
	    lblScoreText.setForeground(Color.WHITE);
	    lblScoreText.setBounds(373, 274, 125, 57);
	    
	    lblTime.setForeground(Color.WHITE);
	    lblTime.setFont(new Font("Agency FB", Font.PLAIN, 24));
	    lblTime.setBounds(415, 566, 46, 33);
	    	                
	    JLabel lblTimeText = new JLabel("Time");
	    lblTimeText.setForeground(Color.WHITE);
	    lblTimeText.setFont(new Font("Agency FB", Font.PLAIN, 27));
	    lblTimeText.setBounds(373, 503, 125, 57);
	        
	    panel.add(lblClose);
	 	panel.add(lblLines);
	    panel.add(lblLinesText);
	    panel.add(lblNextTetrimino);
		panel.add(lblNextTetriminoText);
	    panel.add(lblRetry);
	 	panel.add(lblScore);
	 	panel.add(lblScoreText);
	 	panel.add(lblTime);
	 	panel.add(lblTimeText);
	}

	public void refreshNextTetriminoLabel(String nextTetriminoName) {
	 
		lblNextTetrimino.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/tetriminos/"+nextTetriminoName.charAt(nextTetriminoName.length()-1)+".png")));
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
	}

	public void refreshDataGUI(int s, int l) {
		lblScore.setText(String.valueOf(s));
		lblLines.setText(String.valueOf(l));
		
	}
	
	public void refreshTime(String time) {
		
		this.lblTime.setText(time);
	}

	public void showGameOver() {
		
		lblGameOver.setVisible(true);
		lblRetry.setVisible(true);	
	}
	
	public void showFinalResults(int s, int l, String time) {
		lblfinalResults.setOpaque(true);
		lblfinalResults.setText("Score: " + String.valueOf(s) + "    Lines: " + String.valueOf(l) + "    Time: " + time );
		lblfinalResults.setVisible(true);
	}
	
	public int getRows() {
		
		return rows;	
	}
	
	public int getColumns() {
		
		return columns;
	}

}
