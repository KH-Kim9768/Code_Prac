import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JDBC ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb",
					"root","apmsetup");	// DB�� ����
			// 3306�� MySQL ��Ʈ, soft ��� �����ͺ��̽��� �ʿ�, ����, ���
			System.out.println("DB ���� ����");	// DB�� sql�� ���
		} catch(SQLException ex) {
			System.out.println("SQLExveption : " + ex);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		
		// DB ������ ���´�.
	}

}
