package selfStudy;

public class testMain implements Runnable {

	public testMain() {
		System.out.println("testMain 생성 완료");
	}
	
	public static void main(String[] args) {
		System.out.println("여기는 메인");
		testMain tm = new testMain();
		new Thread(tm).start();
		new Thread(tm).start();
	}
	
	public void run() {
		System.out.println("여기는 쓰레드" + Thread.currentThread());
	}
}
