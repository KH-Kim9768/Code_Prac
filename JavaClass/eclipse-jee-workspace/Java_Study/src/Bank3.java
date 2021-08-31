
public class Bank3 {
	// --- main() start ---
	public static void main(String[] args) {
		Bank000 myAccount = new Bank000("010-1122-3344", 1000);
		
		myAccount.deposit(1000);	
		myAccount.withdraw(500);
		check(myAccount);
	} // --- main() end ---

	public static void check(Bank000 account) {
		account.checkBalance();
	}
	
}

// --- Bank000 class start ---
class Bank000{
	String myAccNumber;
	int balance = 0;
	
	public Bank000(String Number, int bal){
		myAccNumber = Number;
		balance = bal;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	
	public void checkBalance() {
		System.out.println(myAccNumber);
		System.out.println(balance);
	}
} // --- Bank000 class end ---
