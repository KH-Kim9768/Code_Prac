import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JDBC 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb",
					"root","apmsetup");	// DB에 연결
			// 3306은 MySQL 포트, soft 라는 데이터베이스가 필요, 계정, 비번
			System.out.println("DB 연결 성공");	// DB에 sql을 사용
		} catch(SQLException ex) {
			System.out.println("SQLExveption : " + ex);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		
		// DB 연결을 끊는다.
	}

}
