package practice.week7;

public class CarEx {
	public static void main(String[] args) {
		
		Car myCar = new Car();
		System.out.println("����ȸ�� : " + myCar.company);
		System.out.println("�𵨸� : " + myCar.model);
		System.out.println("���� : " + myCar.color);
		
		myCar.maxSpeed = 200;
		System.out.println("�ְ�ӵ� : " + myCar.maxSpeed);
		
		
		myCar.speed = 60;
		
		System.out.println("�ӵ� : " + myCar.speed);
	}
}
