
public class Service {

	private BizDao dao;
	public Service(){
		dao = new BizDao();
	}
	
	public void order(Store newuser){
		System.out.println("�ֹ� Ȯ�� �մϴ�.");
		
		if (newuser.getmenuStr().equals("1")) {
			System.out.print(newuser.getitem()+"���� ");
			System.out.println(newuser.getsuryang() + "�� �½��ϱ�?");
			dao.addoder(newuser);
		} else if (newuser.getmenuStr().equals("2")) {
			System.out.print(newuser.getitem()+"���� ");
			System.out.println(newuser.getsuryang() + "�� �½��ϱ�?");
			dao.addoder(newuser);
		} else if (newuser.getmenuStr().equals("3")) {
			System.out.print(newuser.getitem()+"��Ʈ ");
			System.out.println(newuser.getsuryang() + "�� �½��ϱ�?");
			dao.addoder(newuser);
		}
		
		
		System.out.println("++++++++++++++++++++++����Ͻ����� ȭ���Դϴ�.+++++++++++++++++++++++++++");
	}

}
