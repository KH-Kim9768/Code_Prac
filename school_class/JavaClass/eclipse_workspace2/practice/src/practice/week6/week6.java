package practice.week6;

import java.util.ArrayList;
import java.util.Arrays;

public class week6 {
	public static void main(String[] args) {
		
//		String[] str = new String[3];
//		str[0] = "Java";
//		str[1] = "Java";
//		str[2] = new String("Java");
//		
//		System.out.println(str[0]==str[1]);
//		System.out.println(str[0]==str[2]);
//		System.out.println(str[0].equals(str[2]));
		
		
		
		
//		int[] old = {1,2,3};
//		int[] newarr = new int[5];
//		
//		for (int i = 0; i < old.length; i++) {
//			newarr[i] = old[i];
//			
//		}
//		for (int i = 0; i < newarr.length; i++) {
//			System.out.println(newarr[i]);
//		}
//		
//		String[] oldStr = {"Java", "array", "copy"};
//		String[] newStr = new String[5];
//		
//		System.arraycopy(oldStr,  0, newStr, 0, oldStr.length);
//		
//		for (int i = 0; i < newStr.length; i++){
//				System.out.println(newStr[i]);
//		}
//		
//		System.out.println(Arrays.toString(newarr));
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("papa");
		array.add("mama");
		array.add(1,"babay");
		
		//array.remove(0); 첫번째 삭제 papa
		//array.clear(); 전체 삭제
		for (int i=0; i<array.size(); i++) {
			System.out.println(array.get(i));
			
		}
		
		
		
	}
}
