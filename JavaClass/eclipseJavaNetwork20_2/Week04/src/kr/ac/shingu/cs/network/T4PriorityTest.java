package kr.ac.shingu.cs.network;

public class T4PriorityTest {
	
	public static void main(String[] args) { // ���� ������ �켱����
		
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
		System.out.println("������ 1�� ī���� �� : " + t01.cnt);
		System.out.println("������ 2�� ī���� �� : " + t02.cnt);
		System.out.println("������ 3�� ī���� �� : " + t03.cnt);
		System.out.println("������ 4�� ī���� �� : " + t04.cnt);
		
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