
public class DBMall2 {
	/* ���� �� �̼�
	 * PreparedStatement() �˾ƿ��� -> ���� �� ����
	 * 
	 * Statement Ŭ����
	 *   SQL ������ �����ϴ� ����
	 *   �����δ� SQL ���� ���� ����(�����ؼ� X) -> ���޿���
	 *   SQL ���� O + ���� ���� X
	 *   
	 * PreparedStatement Ŭ����
	 *   Statement Ŭ������ ��� ���
	 *   ���ڿ� ���õ� �۾��� Ưȭ(�Ű�����)
	 *   �ڵ� ������ ����, ������ ����
	 *   �ڵ差�� ���� -> �Ű������� set ������ϱ� ������
	 *   �ؽ�Ʈ SQL ȣ��
	 *  
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		DBSelect dbs = new DBSelect();
//		dbs.select();
		
		
		if (args.length != 4) {
			System.out.println("��� Ȯ�� : ��ǰ�ڵ� ��ǰ�� ���� ������");
			return;
		}
		
		dbs.insert(args);
		dbs.select();
	}

}
