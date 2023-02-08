
public class InheritStatic {
	
	/// main() start
	public static void main(String[] args) {
		Parent s1 = new Parent();
		Parent s2 = new Parent();
		
		Child s3 = new Child();
		
		s3.showCount();
	} /// main() end
}

/// Parent class start
class Parent{
	protected static int count = 10;
	
	public Parent() {
		count += 1;
	}
} /// Parent class end


/// Child class start
class Child extends Parent{
	
	public void showCount() {
		System.out.println(count);
	}
} /// Child class end