package practice.week9;

public class CalcuMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calcu cc = new Calcu();
		cc.powerOn();
		
		int res1 = cc.plus(5, 6);
		
		System.out.println("5 + 6 = " + res1);
		
		double res2 = cc.divide(10, 2);
		System.out.println("10 / 2 = " + res2);
		
		cc.powerOff();
		
		cc.exe();
		
	}

}
