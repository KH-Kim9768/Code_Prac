
public class Array2 {
	/// main() start
	public static void main(String[] args) {
		String[] arr1 = new String[5];
		arr1[0] = "Korea";
		arr1[1] = "Seoul";
		arr1[2] = "Busan";
		arr1[3] = "Daegu";
		arr1[4] = "Incheon";
		
		System.out.println(arr1.length);
		
		int arr1_length = 0;
		for(int i = 0; i < arr1.length; i++) {
			arr1_length += arr1[i].length();
		}
		
		System.out.println(arr1_length);
	} /// main() end
}
