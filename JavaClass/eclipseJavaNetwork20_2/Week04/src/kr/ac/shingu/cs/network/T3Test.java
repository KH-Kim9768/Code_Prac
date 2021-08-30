package kr.ac.shingu.cs.network;
//구구단 작업을 작업 쓰레드에 할당해서 사용(람다식 사용)
public class T3Test {

	public static void main(String[] args) {
		// 작업 쓰레드가 하는 일
		Runnable r = ()->  { // 람다식
			
			for (int dan = 2; dan < 10; dan++) {

				for (int num = 1; num < 10; num++) {

					System.out.println(dan + " * " + num + " = " + dan * num);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		
		new Thread(r).start();
		
		// Main Thread가 하는 일
		for (int i = 0; i < 10; i++) {
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
