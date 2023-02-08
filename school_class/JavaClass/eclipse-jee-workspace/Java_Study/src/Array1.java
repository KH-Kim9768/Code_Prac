
public class Array1 {

	public static void main(String[] args) {
		int[] arr1 = new int[10];
		arr1[2] = 9;
		System.out.println(arr1.length);
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("배열의 %d번째 요소의 값은 %d\n", i+1, arr1[i]);
		}
		
	}

}
