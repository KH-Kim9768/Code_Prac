package kr.ac.shingu.cs.network;
// ������ �۾��� �۾� �����忡 �Ҵ��ؼ� ���(�͸� ���� ��ü �̿�)
public class T2Test {
	public static void main(String[] args) {
		// �۾� �����尡 �ϴ� ��
		new Thread(new Runnable() {
			public void run() {
				for(int dan=2; dan <10; dan++) {
					
					for(int num=1; num<10; num++) {
						
						System.out.println(dan + " * " + num + " = " + dan*num);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		
		// Main Thread�� �ϴ� ��
		for(int i=0; i<10; i++){
			System.out.println("Hi I`m main thread~");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
