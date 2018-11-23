package MVC;

public class CaculatorModel {
	private int calculationValue;
	public void addTwoNumbers(int fistNumber,int secondNumner) {
			calculationValue=fistNumber+secondNumner;
	}
	public int getCalculationValue() {
		return calculationValue;
	}
}
