import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
	public static void main(String[] args) {
		Connection conn;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Soft",
					"root","apmsetup");
			System.out.println("DB 연결 성공");
		} catch(SQLException ex) {
			System.out.println("SQLExveption : " + ex);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}
