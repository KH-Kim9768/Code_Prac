package kr.ac.shingu.cs.network;

public class Fruits {
	private String name;
	private String color;
	private int weight;
	
	
	public Fruits(String name, String color, int weight) {
		this.name = name;
		this.color = color;
		this.weight = weight; // weight = w -> 안 좋은 방식, 가독성을 해침
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getWeight() {
		return weight;
	}
}
