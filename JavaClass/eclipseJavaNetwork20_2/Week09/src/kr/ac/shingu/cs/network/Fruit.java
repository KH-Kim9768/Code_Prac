package kr.ac.shingu.cs.network;

public enum Fruit {
	APPLE("���"),
	WATERMELON("����"),
	STRAWBERRY("����");
	
	private final String value;
	Fruit(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
