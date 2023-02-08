package practice.week7;

public class CarEx {
	public static void main(String[] args) {
		
		Car myCar = new Car();
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색깔 : " + myCar.color);
		
		myCar.maxSpeed = 200;
		System.out.println("최고속도 : " + myCar.maxSpeed);
		
		
		myCar.speed = 60;
		
		System.out.println("속도 : " + myCar.speed);
	}
}
