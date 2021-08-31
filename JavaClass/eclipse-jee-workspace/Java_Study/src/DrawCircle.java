
public class DrawCircle {
	
	/// main() start
	public static void main(String[] args) {
		Position p = new Position(2, 2);
		Circle circle = new Circle(p, 5);
		circle.showCircle();
	}
	/// main() end
}

/// Position class start
class Position {
	int x, y;
	
	// 생성자
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void showPosition() {
		System.out.println("x = " + x + ", y = " + y);
	}
	
} /// Position class end


/// Circle class start
class Circle {
	Position position;
	int r;
	
	// 생성자
	public Circle(Position position, int r) {
		this.position = position;
		this.r = r;
	}
	
	public void showCircle() {
		System.out.println("x = " + position.x + ", y = " + position.y + ", r = " + r);
	}
	
} /// Circle class end
