package kr.ac.shingu.cs.network;

public enum Fruit {
	APPLE("사과"),
	WATERMELON("수박"),
	STRAWBERRY("딸기");
	
	private final String value;
	Fruit(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
