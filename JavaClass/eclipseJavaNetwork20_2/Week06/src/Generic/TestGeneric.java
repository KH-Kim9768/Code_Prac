package Generic;

// 제네릭을 사용하면 자료형을 제한해준다.

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List a = new ArrayList();
		List<String> b = new ArrayList<String>();
		
		a.add("test");
		a.add(555);
		
//		String sa = a.get(0); // 안에 뭐가 들었는지 모르기때무에 다 못가져옴 (String)a.get(0)을 해야함
//		b.add(555); String이기 때문에 문자열 밖에 오지 못한다.
		
		b.add("test");
		String sb = b.get(0); // String이라고 정해져있기 때문에 가져올 수 있음
	}

}
