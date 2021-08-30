package practice.week9;

public class Calcu {
	
	public void powerOn() {
		System.out.println("전원 On!");
	}
	
	public int plus(int x, int y) {
		int result = x+y;
		return result;
	}
	
	public double divide(int x, int y) {
		double result = (double)x/(double)y;
		return result;
	}
	
	public void powerOff() {
		System.out.println("전원 Off");
	}
	
	public double avg(int x, int y) {
		double result = (x+y)/2;
		
		return result;
	}
	
	public void exe() {
		double result = avg(7,10);
		System.out.println("결과 : " + result);
	}
}
