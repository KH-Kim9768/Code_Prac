package kr.ac.shingu.cs.network;
//구구단 작업을 작업 쓰레드에 할당해서 사용(구구단 객체 이용)
public class T1Test {

	public static void main(String[] args) {
		Thread gugu = new Thread(new Gugudan()); // 구구단 쓰레드 객체 생성
		gugu.start(); // 구구단 쓰레드 시작
		
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
	
	public void run() { // 쓰레드 실행
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
