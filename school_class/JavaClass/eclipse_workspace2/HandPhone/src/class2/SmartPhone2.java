package class2;

public class SmartPhone2 extends CellPhone2{
	
	public String color;
	
	public SmartPhone2(String name, String ssn, String color) {
		super(name,ssn);
		
		this.color = color;
		
	}
	
	
	String SMS(String message) {
		System.out.println("자식 객체의 SMS() 실행");
		return message + "보내기";
		
	}
	
	

}
