
public class Service {
	
	private DAO dao;
	
	public Service() {
		dao = new DAO();
	}
	
	public void order(Store user) {
		System.out.println("주문 확인합니다.");
		System.out.println(user.getitem() + "상품");
		System.out.println(user.getnum() + "개 맞습니까?");
		System.out.println("-----------비즈니스로직 화면 ---------------");
		
		dao.addOrder(user);
	}
}
