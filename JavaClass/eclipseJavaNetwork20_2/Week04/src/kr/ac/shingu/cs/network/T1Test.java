package kr.ac.shingu.cs.network;
//������ �۾��� �۾� �����忡 �Ҵ��ؼ� ���(������ ��ü �̿�)
public class T1Test {

	public static void main(String[] args) {
		Thread gugu = new Thread(new Gugudan()); // ������ ������ ��ü ����
		gugu.start(); // ������ ������ ����
		
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

class Gugudan implements Runnable{
	
	public void run() { // ������ ����
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
}
