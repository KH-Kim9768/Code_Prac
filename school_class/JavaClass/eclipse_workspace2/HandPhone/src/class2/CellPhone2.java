package class2;

public class CellPhone2 {
	
	public String name;
	public String ssn;
	
	public CellPhone2(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		
	}
	
	String SMS(String message) {
		System.out.println("부모 객체의 SMS() 실행");
		
		return message + "보내기";
	}
}
