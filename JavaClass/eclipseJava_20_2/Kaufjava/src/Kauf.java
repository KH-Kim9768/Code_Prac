
public class Kauf {

	
	
	
	public double KaufCalc(double height, double weight) {
	
		
		return (weight/(height*height));
		
	}
	
	public String bmiResult(double r) {
		
		if (r >= 30) {
			return "����";
		} else if (r >= 22 && r < 30) {
			return "��";
		} else if (r >= 19 && r < 22) {
			return "��ü��";
		} else if (r >= 15 && r < 19) {
			return "����";
		} else if (r >= 13 && r < 15) {
			return "����";
		} else if (r >= 10 && r < 13) {
			return "�������";
		} else
			return "�ּ���";
	}
}
