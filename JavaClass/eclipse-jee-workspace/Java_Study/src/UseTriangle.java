
public class UseTriangle {
	
	/// main() start
	public static void main(String[] args) {
		Triangle tri1 = new Triangle(10, 5);
		System.out.println(tri1.calcArea());
		
		tri1.setBottom(20.6); 	// tri1.bottom = 20.6;
		tri1.setHeight(8.4);	// tri1.height = 8.4;
		System.out.println(tri1.calcArea());

	} /// main() end

}

/// Triangle class start
class Triangle{
	double bottom, height;
	
	// 생성자
	public Triangle(double bot, double hei) {
		bottom = bot;
		height = hei;
	}
	
	public void setBottom(double bot) {
		bottom = bot;
	}
	
	public void setHeight(double hei) {
		height = hei;
	}
	
	public double calcArea() {
		return bottom * height * 0.5;
	}
	
} /// Triangle class end