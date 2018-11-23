package MVC;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {
	private JTextField fistNumber = new JTextField(10);
	private JLabel additionLable = new JLabel("+");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculatorButton = new JButton("Calculate");
	private JTextField calcSolution = new JTextField(10);

	public CalculatorView() {
		// TODO Auto-generated constructor stub
		JPanel calcPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);

		calcPanel.add(fistNumber);
		calcPanel.add(additionLable);
		calcPanel.add(secondNumber);
		calcPanel.add(calculatorButton);
		calcPanel.add(calcSolution);

		this.add(calcPanel);

	}

	public int getFistNumber() {
		return Integer.parseInt(fistNumber.getText());
	}

	public int getSecondNumber() {
		return Integer.parseInt(secondNumber.getText());
	}

	public int getCalcSolution() {
		return Integer.parseInt(calcSolution.getText());
	}

	public void setCalcSolution(int solution) {
		calcSolution.setText(Integer.toString(solution));
	}

	void addCalculateListener(ActionListener listenForCalcButton) {
		calculatorButton.addActionListener(listenForCalcButton);
	}
	void displayErrorMessage(String errorMessage ) {
		JOptionPane.showMessageDialog(this, "error");
	
	}
}
// giao dien, mvc
