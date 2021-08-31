
public class Array3 {

	/// main() start
	public static void main(String[] args) {
		int[] arr1 = new int[] {10, 2, 19, 22, 90, 40, 9, 45, 89, 70};

		
		System.out.println("최소값 : " + minValue(arr1));
		System.out.println("최대값 : " + maxValue(arr1));
	} /// main() end
	
	/// maxValue() start
	public static int maxValue(int[] arr) {
		int max_value = arr[0];
//		int max_value = Integer.MIN_VALUE;
		
		for(int i:arr) {
			if (i > max_value) {
				max_value = i;
			}
		}
		
		return max_value;
	} /// maxValue() end
	
	/// minValue() start
	public static int minValue(int[] arr) {
		int min_value = arr[0];
//		int min_value = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] < min_value) {
				min_value = arr[i];
			}
		}
		
		return min_value;
	} /// minValue() end
}
