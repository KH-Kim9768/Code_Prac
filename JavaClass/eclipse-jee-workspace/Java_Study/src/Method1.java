
public class Method1 {
	
	// --- main() start ---
	public static void main(String[] args) {
		System.out.println("factorial : " + factorial(5));
		
	} // --- main() end ---

	public static int factorial(int n) {
		if (n <= 1 ) return 1;
		
		return n * factorial(n-1);
	} 
}
