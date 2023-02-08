
public class SmartPhone extends CellPhone{
	
	String internet;
	
	public SmartPhone(String model, String color, String internet) {
		this.model = model;
		this.color = color;
		this.internet = internet;
	}
	
	void turnOn() {
		System.out.println("인터넷 접속 : " + internet + " 채팅 시작");
		
	}
	
	void change(String internet) {
		this.internet = internet;
		System.out.println("인터넷 변경 : " + internet + " 채팅 시작");
	}
	
	void turnOff() {
		System.out.println("인터넷 접속 종료");
		
	}
	
	

}
