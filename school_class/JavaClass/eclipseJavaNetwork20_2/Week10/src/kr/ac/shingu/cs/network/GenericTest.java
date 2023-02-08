package kr.ac.shingu.cs.network;

import java.util.ArrayList;
import java.util.List;

// ���׸��� casting�� �������ش�.
// ���׸��� Stronger type check�� ���ش�
public class GenericTest {
	// 1. ���� Ÿ�� �˻縦 ������ ������ �� �� �ִ�. ( ��Ÿ�� ���� ���� )
	// 2. cast ���� ����(non Generics���� Object�� ����� ��ü�� ���������� ĳ�����ϴ� ������带 ���� �� �ִ�.)
	// 3. ������ ����, ���׸� �˰��� ������ ���� (���α׷��Ӱ� �ڷ������κ��� �ع�)
	
	public static void main(String[] args) {
		
//		List list = new ArrayList();
//		list.add("hello");
//		list.add("�ȳ�");
//		list.add(5000);
//		String s = (String) list.get(1);	// 5000 ������ ����
		
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("�ȳ�");
		
		String s = list.get(0);
		System.out.println(s);
	}

}
