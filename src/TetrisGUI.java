import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class TetrisGUI extends JFrame {
	
	private JPanel graphicPanel;
	private JLabel[][] graphicCells;
	private ImageIcon grassIcon = new ImageIcon("img/emptyCell.png"); 
	
	private JLabel currentTime;
	private JLabel score; 
	private JLabel currentCompletedLines;
	private Logic myLogic;
	
	public TetrisGUI() {
	
		graphicPanel = new JPanel(new GridLayout(21, 10, 0, 0));
		graphicCells = new JLabel[21][10];
		
		for (int i = 0; i < 21; i++) 
			for (int j = 0; j < 10; j++) {
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
	}
	
	public void draw(int x, int y, ImageIcon image) {
		
		
	}
}
