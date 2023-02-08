package kr.ac.shingu.cs.network;

public class T4PriorityTest {
	
	public static void main(String[] args) { // 숫자 높은게 우선순위
		
		PriorityThread t01 = new PriorityThread(Thread.NORM_PRIORITY);
		PriorityThread t02 = new PriorityThread(1);
		PriorityThread t03 = new PriorityThread(Thread.MIN_PRIORITY);
		PriorityThread t04 = new PriorityThread(Thread.MAX_PRIORITY);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t01.stop();
		t02.stop();
		t03.stop();
		t04.stop();
		System.out.println("쓰레드 1번 카운팅 값 : " + t01.cnt);
		System.out.println("쓰레드 2번 카운팅 값 : " + t02.cnt);
		System.out.println("쓰레드 3번 카운팅 값 : " + t03.cnt);
		System.out.println("쓰레드 4번 카운팅 값 : " + t04.cnt);
		
	}
}




class PriorityThread extends Thread{
	public long cnt;
	
	PriorityThread(int p){
		setPriority(p);
		start();
		
	}
	public void run() {
		while(true) {
			cnt++;
		}
	}
	
}