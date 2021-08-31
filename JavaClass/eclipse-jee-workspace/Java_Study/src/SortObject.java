import java.util.Arrays;

public class SortObject {
	
	/// main() start
	public static void main(String[] args) {
		PersonSort[] personList = new PersonSort[] {
				new PersonSort(20),
				new PersonSort(30),
				new PersonSort(10)
		};
		
		Arrays.sort(personList);
		
		for(PersonSort p : personList) {
			System.out.println(p);
		}
	} /// main() end
}

/// PersonSort class start
class PersonSort implements Comparable{
	private int age;
	
	/// 생성자
	public PersonSort(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Object o) {
		PersonSort p = (PersonSort) o;
//		return this.age - p.age; // 오름차순 정렬
		return p.age - this.age; // 내림차순 정렬
	}
	
	@Override
	public String toString() {
		return "나이 : " + age;
	}
} /// PersonSort class end
