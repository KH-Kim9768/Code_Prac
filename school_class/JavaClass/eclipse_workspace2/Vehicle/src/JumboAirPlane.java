
public class JumboAirPlane extends AirPlane{
	
	public static final int NORMAL = 1;
	public final static int JUMBO = 2; // final static ��ġ �ٲ� ��� x
	
	public int flymode = NORMAL;
	
	public void fly() {
		if (flymode == JUMBO) {
			System.out.println("���������մϴ�.");
		} else {
			super.fly();
		}
		
	}
}
