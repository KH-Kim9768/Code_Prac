import java.util.Random;
import java.util.Scanner;


public class RandomAZ {
	
	/// main() start
	public static void main(String[] args) {
		try(
				Scanner scan = new Scanner(System.in);
				) {
			
			System.out.print("숫자 2개 입력 : ");
			String[] inputStrNumber = scan.nextLine().split(" ");
			
			int num1 = Integer.parseInt(inputStrNumber[0]);
			int num2 = Integer.parseInt(inputStrNumber[1]);
			
//			System.out.print("숫자 1 입력 : ");
//			int num1 = scan.nextInt();
//			
//			System.out.print("숫자 2 입력 : ");
//			int num2 = scan.nextInt();
			
			int max = (num1 > num2)? num1 : num2;
			int min = (num1 < num2)? num1 : num2;
			
			Random r = new Random();
			
			int[] randList = new int[10];
			
			for (int i =0; i< 10; i++) {
				randList[i] = r.nextInt(max - min + 1) + min;
			}
			
			for (int i : randList) {
				System.out.println(i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} /// main() end

}
