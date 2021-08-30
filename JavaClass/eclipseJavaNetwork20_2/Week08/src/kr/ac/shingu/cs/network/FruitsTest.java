package kr.ac.shingu.cs.network;

import java.util.Arrays;
import java.util.List;

public class FruitsTest {

	public static void main(String[] args) {
		List<Fruits> fruitsList = Arrays.asList(
				new Fruits("����", "������", 20),
				new Fruits("�ٳ���", "�����", 60),
				new Fruits("��", "�����", 35),
				new Fruits("����", "������", 22),
				new Fruits("����", "�ʷϻ�", 250),
				new Fruits("���", "������", 90)
				);
		
		int sum = fruitsList.stream()
				.filter(w -> w.getColor() == "������")
				.mapToInt(w -> w.getWeight())
				.sum();
		
		System.out.println(sum);
		
		
		// Q. ������ ������ ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		int cnt = (int) fruitsList.stream()
				.filter(w -> w.getColor() == "������")
				.count(); // ī��Ʈ�� ������ long
		
		System.out.println(cnt);
	}
}
