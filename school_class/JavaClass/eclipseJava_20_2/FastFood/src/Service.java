
public class Service {
	
	private DAO dao;
	
	public Service() {
		dao = new DAO();
	}
	
	public void order(Store user) {
		System.out.println("�ֹ� Ȯ���մϴ�.");
		System.out.println(user.getitem() + "��ǰ");
		System.out.println(user.getnum() + "�� �½��ϱ�?");
		System.out.println("-----------����Ͻ����� ȭ�� ---------------");
		
		dao.addOrder(user);
	}
}
