package class2;

public class PhoneMain2 {
	public static void main(String[] args) {
		SmartPhone2 sp = new SmartPhone2("아이폰", "010-1111-1234", "블랙");
		System.out.println("name : " + sp.name);
		System.out.println("ssn : " + sp.ssn);
		
		System.out.println("color : " + sp.color);
		
		String message = sp.SMS("문자");
		
		System.out.println(message);
	}
}
