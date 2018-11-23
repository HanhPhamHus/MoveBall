package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorContronler {
	private CalculatorView theView;
	private CaculatorModel theModel;

	public CalculatorContronler(CalculatorView theView, CaculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.addCalculateListener(new CaculateListener());

	}

	class CaculateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int fistNumber,secondNumber;
			
			try {
			fistNumber= theView.getFistNumber();
			secondNumber=theView.getSecondNumber();
			
			theModel.addTwoNumbers(fistNumber, secondNumber);
			theView.setCalcSolution(theModel.getCalculationValue());
			}
			
			catch(NumberFormatException ex) {
				theView.displayErrorMessage("error");
				
			}
				
		}

	}
}
