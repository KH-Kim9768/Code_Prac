package StarcraftJavaPack;

public class StarMain {
	
	public static void main(String[] args) {
		
		Zerg z = new Zerg();
		z.attack();
		
		Starcraft z1 = new Zerg(); 
		z1.attack();
		
		Starcraft arr[] = new Starcraft[3]; // ��ĳ����
		arr[0] = new Zerg();
		arr[1] = new Terran();
		arr[2] = new Protos();
		
		for(int i = 0; i< arr.length; i++) {
			arr[i].attack();
		}
		
	}
	
}
