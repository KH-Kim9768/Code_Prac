
public class CellPhone {
	
	String model;
	String color;
	
	void powerOn() {
		System.out.println("���� On");
		
	}
	
	
	void powerOff() {
		System.out.println("���� Off");
		
	}
	
	void bell() {
		System.out.println("���� �︳�ϴ�.");
		
	}
	
	void sendVoice(String message) {
		System.out.println("��: " + message);
	}
	
	void receiveVoice(String message) {
		System.out.println("���� : " + message);
		
	}
	
	void hangUp() {
		System.out.println("��ȭ ����.");
		
	}

}
