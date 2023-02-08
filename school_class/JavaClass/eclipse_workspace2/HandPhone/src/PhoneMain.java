
public class PhoneMain {
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("아이폰", "블랙", "인스타");
		
		System.out.println("모델 : " + sp.model);
		System.out.println("색상 : " + sp.color);//부모클래스 CellPhone
		
		System.out.println("인터넷 : " + sp.internet);//자식클래스 SmartPhone
		
		
		
		sp.powerOn();
		sp.bell();
		sp.sendVoice("여보세요");
		sp.receiveVoice("안녕");
		sp.sendVoice("반가워");
		sp.powerOff();//부모클래스 CellPhone
		
		sp.turnOn();//자식클래스 SmartPhone
		sp.change("페이스북");
		sp.turnOff();
		
		
		
	}
}
