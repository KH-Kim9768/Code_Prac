package Generic;

// ���׸��� ����ϸ� �ڷ����� �������ش�.

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List a = new ArrayList();
		List<String> b = new ArrayList<String>();
		
		a.add("test");
		a.add(555);
		
//		String sa = a.get(0); // �ȿ� ���� ������� �𸣱⶧���� �� �������� (String)a.get(0)�� �ؾ���
//		b.add(555); String�̱� ������ ���ڿ� �ۿ� ���� ���Ѵ�.
		
		b.add("test");
		String sb = b.get(0); // String�̶�� �������ֱ� ������ ������ �� ����
	}

}
