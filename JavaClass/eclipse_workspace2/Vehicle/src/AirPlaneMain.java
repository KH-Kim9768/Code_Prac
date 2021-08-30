
public class AirPlaneMain {
	public static void main(String[] args) {
		
		JumboAirPlane jp = new JumboAirPlane();
		jp.takeOff();
		jp.fly();
		jp.flymode = JumboAirPlane.JUMBO;
		jp.fly();
		jp.flymode = jp.NORMAL;
		jp.fly();
		jp.land();
		
	}
}
