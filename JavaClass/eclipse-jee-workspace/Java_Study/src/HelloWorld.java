
public class HelloWorld {

	public static void main(String[] args) {
//		System.out.println("Hello Java World!!");
		
//		int a = 10;
//		int b = 20;
//		boolean b1 = 10 > 20;
//		boolean b2 = 10 < 20;
//		System.out.println(a > b);
//		System.out.println(a < b);
				
//		char c1 = '대';
//		char c2 = '한';
//		char c3 = '민';
//		char c4 = '국';
//		System.out.println(c1 + " " + c2 + " " + c3 + " " + c4);
		
//		final char CHAR1= '가';
//		System.out.println(CHAR1);
//		
//		char star = '\u2605';
//		System.out.println("\u2605 표시 : " + star);
//		
//		short s_num1 = 10, s_num2 = 20, s_num3;
//		s_num3 = (short) (s_num1 + s_num2);
//		System.out.println(s_num3);
	
//		int num3 = 0;
//		int num4 = 0;
//		boolean result;
//		result = ((num3 += 10)<0) && ((num4 += 10)>0);
//		System.out.println("result = " + result);
//		System.out.println("num3 = " + num3);
//		System.out.println("num4 = " + num4 + '\n');
//		
//		result = ((num3 += 10) > 0) || ((num4 += 10)>0);
//		System.out.println("result = " + result);
//		System.out.println("num3 = " + num3);
//		System.out.println("num4 = " + num4 + '\n');
//		
//		result = ((num4 += 10) > 0) || ((num3 += 10)>0);
//		System.out.println("result = " + result);
//		System.out.println("num3 = " + num3);
//		System.out.println("num4 = " + num4 + '\n');
		
//		int num5 = 10;
//		int a = 20;
//		num5 = a++;
//		System.out.println("num5 = " + num5 + " a = " + a);
//		num5 = ++a;
//		System.out.println("num5 = " + num5 + " a = " + a);
		
//		int rate = 2;
//		rate *= 2.5;
//		System.out.println(rate);
//		
//		int rate1 = 2;
//		rate1 = (int)(rate1 * 2.5);
//		System.out.println(rate1);
		
//		int n = 1;
//		n += 2;
//		System.out.println(n);
//
//		n += 3;
//		System.out.println(n);
//
//		n += 4;
//		System.out.println(n);
		
//		int some_number = 100;
//		
//		if ((some_number % 2 == 0) && (some_number > 0)) {
//			System.out.println(some_number + " 양수, 짝수입니다.");
//		} else {
//			
//		}
		
//		int num7 = 79;
//		if (num7 < 80) {
//			System.out.println("80점미만");
//		} else if (num7 < 90) {
//			System.out.println("80점대");
//		} else if (num7 < 100) {
//			System.out.println("90점대");
//		} else if (num7 == 100) {
//			System.out.println("100점");
//		} else {
//			System.out.println("???");
//		}
//		
//		switch(num7/10) {
//			case 10:
//				System.out.println("100점");
//				break;
//			case 9:
//				System.out.println("90점대");
//				break;
//			case 8:
//				System.out.println("80점대");
//				break;
//			default:
//				System.out.println("80점미만");
//		}
		
//		int result = 0;
//		for ( int i = 1 ; i <= 100 ; i++) {
//			result += i;
//		}
//		System.out.println(result);
		
//		for( int i = 1; i <= 9; i++) {
//			System.out.println("9 x " + i + " = " + (9* i));
//		}
		
//		int result = 0;
//		int i = 1;
//		while(i <= 100) {
//			if (i % 2 == 0 && i % 5 == 0){ // --> i % 10 == 0
//				result += i;
//			}
//			i++;
//		}
//		System.out.println(result);
		
//		int num = 0;
//		
//		while(num<10) {
//			num++;
//			System.out.println(num);
//		}
//		System.out.println("현재 num 값 : " + num);
//		do {
//			System.out.println(num);
//			num--;
//		} while(num>0);
//		System.out.println("현재 num 값 : " + num);
		
//		int i = 1, sum = 0;
//		while(true) {
//			if (i % 2 == 1) sum += i;
//			if (sum > 100) break;
//			i++;
//		}
//		System.out.println("sum  = " + sum + ", i = " + i);
		
//		for( int i = 2; i < 9; i += 2) {
//			for(int j = 1; j <= i; j++) {
//				System.out.println(i+" x " + j + " = " + (i*j));
//			}
//		}
		
		for( int i = 0; i < 100; i++) {
			int n1 = i/10;
			int n2 = i%10;
			if(n1 * n2 == 0 || n1 == 1) continue;
			if(n1%2 != 0 || n2 > n1) continue;
			System.out.println(n1 + " x " + n2 + " = " + (n1*n2));
		}
		
	} //--- main() end ---
} // --- class end ---

class String0{
	public static void main(String[] args) {
		System.out.println("This is String0");
		String s1 = "990101-1234567";
		String s2 = s1.substring(0, 6) + "" + s1.substring(7);
		System.out.println(s2);
	}
}


