import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBMall {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb",
					"root", "apmsetup");
			System.out.println("DB 연결 성공");
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from goodsinfo;");
			
			System.out.println("상품코드   \t\t\t\t상품명  \t\t\t가격   제조사");
			System.out.println("---------------------------------------------------------------------");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s  %30s  \t%12d  %s\n", code, name, price, maker);
			}
		} catch(SQLException ex) {
			System.out.println("SQLExveption : " + ex);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
		}
		finally {
			try {
				stmt.close();
				
			} catch (Exception ignored) {
				
			}
			
			try {
				conn.close();
				
			} catch (Exception ignored) {
				
			}
		}
	}
}


