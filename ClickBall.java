package ClickTheBall_week6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ClickBall extends JFrame {

	private int maxCol = 4;
	private int maxRow = 4;
	private int row = 2;
	private int col = 2;

	private JPanel contentPane;

	private JButton btn1, btn2, btn3, btn4;

	private JButton[][] buttons;

	private JPanel pnlGround;

	protected void moveRight() {
		// TODO Auto-generated method stub
		removeBall();
		if (col < maxCol)
			col++;
		addBall();

	}

	protected void moveLeft() {
		removeBall();
		if (col > 0) {
			col--;
		}
		addBall();
	}

	protected void moveDown() {
		removeBall();
		if (row < maxRow)
			row++;
		addBall();
	}

	protected void moveUp() {
		removeBall();
		if (row > 0)
			row--;
		addBall();
	}

	private void addBall() {
		buttons[row][col].setText("O");
	}

	private void removeBall() {
		buttons[row][col].setText("");
	}

	public ClickBall() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BallMoving");

		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		btn1 = new JButton("Up");
		btn2 = new JButton("Down");
		btn3 = new JButton("Left");
		btn4 = new JButton("Right");

		contentPane.add(btn1, BorderLayout.PAGE_START);
		contentPane.add(btn2, BorderLayout.PAGE_END);
		contentPane.add(btn3, BorderLayout.WEST);
		contentPane.add(btn4, BorderLayout.EAST);

		pnlGround = new JPanel();
		pnlGround.setLayout(new BorderLayout());
		contentPane.add(pnlGround, BorderLayout.CENTER);

		JPanel pane = new JPanel();// pane la cai de setGround
		pane.setLayout(new GridLayout(maxRow + 1, maxCol + 1));
		pane.setBorder(new TitledBorder("Ground"));
		pnlGround.add(pane, BorderLayout.CENTER);
		buttons = new JButton[maxRow + 1][maxCol + 1];

		for (int i = 0; i <= maxRow; i++) {
			for (int j = 0; j <= maxCol; j++) {
				buttons[i][j] = new JButton();

				if (i == 2 && j == 2) {
					buttons[i][j].setText("0");
				}
				pane.add(buttons[i][j]);
			}
		}
		ActionListener up=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveUp();
				
			}
		};
		btn1.addActionListener(up);
		ActionListener down=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveDown();
				
			}
		};
		btn2.addActionListener(down);
		
		ActionListener left=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveLeft();
				
			}
		};
		btn3.addActionListener(left);
		ActionListener right=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveRight();
				
				
			}
		};
		btn4.addActionListener(right);
	}

	public static void main(String[] args) {
		ClickBall cb = new ClickBall();
		cb.setVisible(true);
	}

}
