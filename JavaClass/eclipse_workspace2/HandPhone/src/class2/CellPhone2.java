package class2;

public class CellPhone2 {
	
	public String name;
	public String ssn;
	
	public CellPhone2(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		
	}
	
	String SMS(String message) {
		System.out.println("�θ� ��ü�� SMS() ����");
		
		return message + "������";
	}
}
