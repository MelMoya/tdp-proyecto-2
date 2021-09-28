
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TetrisGUI extends JFrame {
	
	private static int rows = 21;
	private static int columns = 10;
	
	private JPanel graphicPanel;
	private JLabel[][] graphicCells;
	private ImageIcon grassIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(TetrisGUI.class.getResource("/img/cells/emptyCell.png")));
	
//	private JLabel currentTime;
//	private JLabel score; 
//	private JLabel currentCompletedLines;
	private JLabel lblScore;
	private JLabel lblLines;
	private Logic myLogic;
	private JLabel lblScoreText;
	private JLabel lblLinesText;
	private JLabel lblGameOver;
	private JLabel lblRetry;
	
	public TetrisGUI() {
		setForeground(Color.BLACK);
		setUndecorated(true);
		this.setSize(500, 1200);
        this.setMinimumSize(new Dimension(600, 800));
  
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		graphicPanel = new JPanel(new GridLayout(rows, columns, 0,0));
		graphicPanel.setBounds(30,36, 300,630);
		graphicCells = new JLabel[rows][columns];
		
		JPanel panel = new JPanel(); 
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < columns; j++) {
				graphicCells[i][j] = new JLabel();
				graphicCells[i][j].setIcon(grassIcon);
				graphicPanel.add(graphicCells[i][j]);
			}
		
		
		setContentPane(panel);
		panel.setLayout(null);
		
		lblGameOver = new JLabel("");
		lblGameOver.setVerticalAlignment(SwingConstants.TOP);
		lblGameOver.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameAssets/gameOverSign.png")));
		lblGameOver.setBounds(10, 307, 565, 130);
		lblGameOver.setVisible(false);
		panel.add(lblGameOver);
		lblScore = new JLabel("0");
		lblScore.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(431, 342, 46, 33);
		panel.add(lblScore);

		panel.add(graphicPanel);
		
		lblLines = new JLabel("0");
		lblLines.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblLines.setForeground(Color.WHITE);
		lblLines.setBounds(431, 459, 46, 33);
		panel.add(lblLines);
		

		
		super.pack();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        
        lblScoreText = new JLabel("Score");
        lblScoreText.setFont(new Font("Agency FB", Font.PLAIN, 27));
        lblScoreText.setForeground(Color.WHITE);
        lblScoreText.setBounds(373, 274, 125, 57);
        panel.add(lblScoreText);
        
        lblLinesText = new JLabel("Lines");
        lblLinesText.setForeground(Color.WHITE);
        lblLinesText.setFont(new Font("Agency FB", Font.PLAIN, 27));
        lblLinesText.setBounds(373, 380, 125, 57);
        panel.add(lblLinesText);
        
        JLabel lblClose = new JLabel("");
        lblClose.addMouseMotionListener(new MouseMotionAdapter() {
           public void mouseDragged(MouseEvent arg0) {
        	  dispose();
        	  System.exit(EXIT_ON_CLOSE);
           }
       });
        lblClose.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameAssets/close.png")));
        lblClose.setBounds(550, 11, 46, 30);
        panel.add(lblClose);
        
        JLabel lblNextTetriminoText = new JLabel("Next");
        lblNextTetriminoText.setForeground(Color.WHITE);
        lblNextTetriminoText.setFont(new Font("Agency FB", Font.PLAIN, 27));
        lblNextTetriminoText.setBounds(373, 95, 125, 57);
        panel.add(lblNextTetriminoText);
        
        JLabel lblNextTetrimino = new JLabel("");
        lblNextTetrimino.setBounds(398, 163, 100, 100);
        panel.add(lblNextTetrimino);
        lblNextTetrimino.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/tetriminos/Z.png")));
        
        JLabel lblTimeText = new JLabel("Time");
        lblTimeText.setForeground(Color.WHITE);
        lblTimeText.setFont(new Font("Agency FB", Font.PLAIN, 27));
        lblTimeText.setBounds(373, 503, 125, 57);
        panel.add(lblTimeText);
        
        JLabel lblTime = new JLabel("00:00");
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(new Font("Agency FB", Font.PLAIN, 24));
        lblTime.setBounds(415, 566, 46, 33);
        panel.add(lblTime);
        
        lblRetry = new JLabel("");
        lblRetry.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameAssets/retry2.png")));
        lblRetry.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent arg0) {
            	
//				Launcher launch = new Launcher();
//            	dispose();
//            	System.exit(EXIT_ON_CLOSE);
//            	new TetrisGUI();
            }
        });
        lblRetry.setVisible(false);
        lblRetry.setBounds(507, 11, 46, 30);
        panel.add(lblRetry);
        
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


	public void showGameOver() {
		lblGameOver.setVisible(true);
		lblRetry.setVisible(true);
		
	}
}
