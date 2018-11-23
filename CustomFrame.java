package MatrixClick_week5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomFrame extends JFrame {
	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnSub;
	private JPanel pnlGround;
	private  JPanel panel;

	// tao matrix
	private int[][] matrix = { { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 },
			{ 1, 0, 1, 2, 3 } };

	private JButton[][] buttons = new JButton[matrix.length][matrix[0].length];
	private EventObject e;

	// cap nhat data
	private void updateAllButtons() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				buttons[i][j].setText(String.valueOf(matrix[i][j]));
			}
		}

	}
	

	private void updateCe(int i, int j) {
		matrix[i][j]++;
	}

	// xu ly su kien
	// capnhat tang 1
	private void updateMatrixByAdd() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j]++;
			}
		}
	}

	// cap nhat giam 1
	private void updateMatrixBySub() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j]--;
			}
		}
	}



	public CustomFrame() {
		// xd cua so
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Demo");

		// tao panel
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		// add Button
		contentPane.setLayout(new BorderLayout());

		btnAdd = new JButton("+1");
		btnSub = new JButton("-1");
  
		// tao 2 cai thnah tren , duoi
		contentPane.add(btnAdd, BorderLayout.PAGE_START);
		contentPane.add(btnSub, BorderLayout.PAGE_END);

		pnlGround = new JPanel();
		pnlGround.setLayout(new GridLayout(5, 5));// tao bang 5*5

		contentPane.add(pnlGround, BorderLayout.CENTER);

		ActionListener al=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				int order = pnlGround.getComponentZOrder(button); 
				int row = (order) / matrix[0].length; 
				int col = (order) % matrix[0].length; 
			
				updateCe(row, col);
				updateAllButtons();
				
				 
			}
		};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				buttons[i][j] = new JButton(String.valueOf(matrix[i][j]));
				buttons[i][j].addActionListener(al);
				pnlGround.add(buttons[i][j]);
				
				

			}
		}
		
		
		// event1 : buttonAdd+1
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMatrixByAdd();
				updateAllButtons();
				
			}
		});

		//event2 buttonSub-1
		btnSub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMatrixBySub();
				updateAllButtons();
				
			}
		});

	}

	public static void main(String[] args) {
		CustomFrame cf = new CustomFrame();
		cf.setVisible(true);
	}

}
