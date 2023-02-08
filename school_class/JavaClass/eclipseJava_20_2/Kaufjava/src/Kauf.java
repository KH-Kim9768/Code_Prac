
public class Kauf {

	
	
	
	public double KaufCalc(double height, double weight) {
	
		
		return (weight/(height*height));
		
	}
	
	public String bmiResult(double r) {
		
		if (r >= 30) {
			return "고도비만";
		} else if (r >= 22 && r < 30) {
			return "비만";
		} else if (r >= 19 && r < 22) {
			return "과체중";
		} else if (r >= 15 && r < 19) {
			return "정상";
		} else if (r >= 13 && r < 15) {
			return "마름";
		} else if (r >= 10 && r < 13) {
			return "영양실조";
		} else
			return "왜소증";
	}
}
