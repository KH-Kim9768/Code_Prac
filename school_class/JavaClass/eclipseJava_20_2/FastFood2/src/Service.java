
public class Service {

	private BizDao dao;
	public Service(){
		dao = new BizDao();
	}
	
	public void order(Store newuser){
		System.out.println("주문 확인 합니다.");
		
		if (newuser.getmenuStr().equals("1")) {
			System.out.print(newuser.getitem()+"버거 ");
			System.out.println(newuser.getsuryang() + "개 맞습니까?");
			dao.addoder(newuser);
		} else if (newuser.getmenuStr().equals("2")) {
			System.out.print(newuser.getitem()+"음료 ");
			System.out.println(newuser.getsuryang() + "개 맞습니까?");
			dao.addoder(newuser);
		} else if (newuser.getmenuStr().equals("3")) {
			System.out.print(newuser.getitem()+"세트 ");
			System.out.println(newuser.getsuryang() + "개 맞습니까?");
			dao.addoder(newuser);
		}
		
		
		System.out.println("++++++++++++++++++++++비즈니스로직 화면입니다.+++++++++++++++++++++++++++");
	}

}
