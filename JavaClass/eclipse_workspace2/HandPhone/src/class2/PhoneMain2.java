package class2;

public class PhoneMain2 {
	public static void main(String[] args) {
		SmartPhone2 sp = new SmartPhone2("������", "010-1111-1234", "��");
		System.out.println("name : " + sp.name);
		System.out.println("ssn : " + sp.ssn);
		
		System.out.println("color : " + sp.color);
		
		String message = sp.SMS("����");
		
		System.out.println(message);
	}
}
