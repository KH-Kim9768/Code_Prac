package kr.ac.shingu.cs.network;

public class FruitTest {

	public static void main(String[] args) {
		System.out.println(Fruit.WATERMELON.getValue());
		for(Fruit kind : Fruit.values()) {
			System.out.println(kind);
		}
		
		for(Fruit kind : Fruit.values()) {
			System.out.println(kind.getValue());
		}

	}

}
