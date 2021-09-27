
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TetrisGUI extends JFrame {
	
	private static int rows = 21;
	private static int columns = 10;
	
	private JPanel graphicPanel;
	private JLabel[][] graphicCells;
	private ImageIcon grassIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(TetrisGUI.class.getResource("/img/emptyCell.png")));
	
//	private JLabel currentTime;
//	private JLabel score; 
//	private JLabel currentCompletedLines;
	private JLabel lblScoreDisplay;
	private JLabel lblLinesDisplay;
	private Logic myLogic;
	private JLabel lblScore;
	private JLabel lblLines;
	private JLabel lblGameOver;
	
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
		lblGameOver.setBounds(-20, 11, 610, 307);
		lblGameOver.setVisible(false);
		panel.add(lblGameOver);
		lblGameOver.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/gameOverSign.png")));
		lblScoreDisplay = new JLabel("0");
		lblScoreDisplay.setFont(new Font("Agency FB", Font.PLAIN, 17));
		lblScoreDisplay.setForeground(Color.WHITE);
		lblScoreDisplay.setBounds(431, 407, 46, 33);
		panel.add(lblScoreDisplay);

		panel.add(graphicPanel);
		
		lblLinesDisplay = new JLabel("0");
		lblLinesDisplay.setFont(new Font("Agency FB", Font.PLAIN, 17));
		lblLinesDisplay.setForeground(Color.WHITE);
		lblLinesDisplay.setBounds(431, 536, 46, 33);
		panel.add(lblLinesDisplay);
		

		
		super.pack();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        
        lblScore = new JLabel("Score");
        lblScore.setFont(new Font("Agency FB", Font.PLAIN, 21));
        lblScore.setForeground(Color.WHITE);
        lblScore.setBounds(373, 355, 125, 57);
        panel.add(lblScore);
        
        lblLines = new JLabel("Lines");
        lblLines.setForeground(Color.WHITE);
        lblLines.setFont(new Font("Agency FB", Font.PLAIN, 21));
        lblLines.setBounds(373, 468, 125, 57);
        panel.add(lblLines);
        
        JLabel lblClose = new JLabel("");
        lblClose.addMouseMotionListener(new MouseMotionAdapter() {
           public void mouseDragged(MouseEvent arg0) {
        	  dispose();
        	  System.exit(EXIT_ON_CLOSE);
           }
       });
        lblClose.setIcon(new ImageIcon(TetrisGUI.class.getResource("/img/close.png")));
        lblClose.setBounds(550, 11, 46, 30);
        panel.add(lblClose);
        
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
		lblScoreDisplay.setText(String.valueOf(s));
		lblLinesDisplay.setText(String.valueOf(l));
		
	}


	public void showGameOver() {
		lblGameOver.setVisible(true);
		
	}
}
