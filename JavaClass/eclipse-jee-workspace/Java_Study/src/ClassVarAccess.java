
public class ClassVarAccess {

	public static void main(String[] args) {
		ClassAccess acc = new ClassAccess();
		acc.num++;
		
		ClassAccess.num++;
		
		System.out.println(acc.num);
		
		ClassAccess acc1 = new ClassAccess();
		System.out.println(ClassAccess.num);
		System.out.println(acc1.num);

	}

}

class ClassAccess{
	static int num = 100;
	
	ClassAccess(){
		increaseCnt();
	}
	
	void increaseCnt() {
		num++;
	}
	
}
