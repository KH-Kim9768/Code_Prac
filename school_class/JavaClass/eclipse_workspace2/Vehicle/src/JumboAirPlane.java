
public class JumboAirPlane extends AirPlane{
	
	public static final int NORMAL = 1;
	public final static int JUMBO = 2; // final static 위치 바뀌어도 상관 x
	
	public int flymode = NORMAL;
	
	public void fly() {
		if (flymode == JUMBO) {
			System.out.println("점보비행합니다.");
		} else {
			super.fly();
		}
		
	}
}
