
public class SmartPhone extends CellPhone{
	
	String internet;
	
	public SmartPhone(String model, String color, String internet) {
		this.model = model;
		this.color = color;
		this.internet = internet;
	}
	
	void turnOn() {
		System.out.println("���ͳ� ���� : " + internet + " ä�� ����");
		
	}
	
	void change(String internet) {
		this.internet = internet;
		System.out.println("���ͳ� ���� : " + internet + " ä�� ����");
	}
	
	void turnOff() {
		System.out.println("���ͳ� ���� ����");
		
	}
	
	

}
