
public class PhoneMain {
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("������", "��", "�ν�Ÿ");
		
		System.out.println("�� : " + sp.model);
		System.out.println("���� : " + sp.color);//�θ�Ŭ���� CellPhone
		
		System.out.println("���ͳ� : " + sp.internet);//�ڽ�Ŭ���� SmartPhone
		
		
		
		sp.powerOn();
		sp.bell();
		sp.sendVoice("��������");
		sp.receiveVoice("�ȳ�");
		sp.sendVoice("�ݰ���");
		sp.powerOff();//�θ�Ŭ���� CellPhone
		
		sp.turnOn();//�ڽ�Ŭ���� SmartPhone
		sp.change("���̽���");
		sp.turnOff();
		
		
		
	}
}
