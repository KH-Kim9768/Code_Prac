package Tank;

public class TankClass implements Car, Cannon{
	public void drive() {
		System.out.println("탱크 운전 시작");
	}
	

	public void fire() {
		System.out.println("탱크 발사");
	}
}
