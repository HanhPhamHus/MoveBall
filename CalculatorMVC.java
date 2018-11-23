package MVC;

public class CalculatorMVC {
	public static void main(String[] args) {
		CalculatorView theView=new CalculatorView();
		
		CaculatorModel theModel=new CaculatorModel();
		
		CalculatorContronler theControler=new CalculatorContronler(theView, theModel);
		
		theView.setVisible(true);
	}
}
