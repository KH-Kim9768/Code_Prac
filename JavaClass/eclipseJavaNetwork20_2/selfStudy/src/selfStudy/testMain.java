package selfStudy;

public class testMain implements Runnable {

	public testMain() {
		System.out.println("testMain ���� �Ϸ�");
	}
	
	public static void main(String[] args) {
		System.out.println("����� ����");
		testMain tm = new testMain();
		new Thread(tm).start();
		new Thread(tm).start();
	}
	
	public void run() {
		System.out.println("����� ������" + Thread.currentThread());
	}
}
