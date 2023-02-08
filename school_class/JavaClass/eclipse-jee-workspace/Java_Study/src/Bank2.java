public class Bank2 {
	// --- main() start ---
	public static void main(String[] args) {
		Bank00 myAccount = new Bank00();
		
		myAccount.deposit(1000);
		check(myAccount);		
		myAccount.withdraw(500);
		check(myAccount);
	} // --- main() end ---

	public static void check(Bank00 account) {
		account.checkBalance();
	}
}

// --- Bank00 class start ---
class Bank00{
	int balance = 0;
	
	public void deposit(int money) {
		balance += money;
//		return balance;
	}
	
	public void withdraw(int money) {
		balance -= money;
//		return balance;
	}
	
	public void checkBalance() {
		System.out.println(balance);
	}
	
} // --- Bank00 class end ---
