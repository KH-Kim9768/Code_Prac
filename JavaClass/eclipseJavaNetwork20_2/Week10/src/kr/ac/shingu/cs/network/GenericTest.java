package kr.ac.shingu.cs.network;

import java.util.ArrayList;
import java.util.List;

// 제네릭은 casting을 제거해준다.
// 제네릭은 Stronger type check를 해준다
public class GenericTest {
	// 1. 강한 타입 검사를 컴파일 시점에 할 수 있다. ( 런타임 에러 예방 )
	// 2. cast 제거 가능(non Generics에서 Object로 저장된 객체를 꺼낼때마다 캐스팅하는 오버헤드를 줄일 수 있다.)
	// 3. 가독성 증가, 제네릭 알고리즘 구현이 용이 (프로그래머가 자료형으로부터 해방)
	
	public static void main(String[] args) {
		
//		List list = new ArrayList();
//		list.add("hello");
//		list.add("안녕");
//		list.add(5000);
//		String s = (String) list.get(1);	// 5000 꺼낼때 에러
		
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("안녕");
		
		String s = list.get(0);
		System.out.println(s);
	}

}
