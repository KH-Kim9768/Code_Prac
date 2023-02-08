package baseball;

public class Baseball {

	public static void main(String[] args) {
		
		
		Pitcher pi = new Pitcher();
		pi.pitch();
		
		Hitter hi = new Hitter();
		hi.hit(pi.pitcher);

	}

}
