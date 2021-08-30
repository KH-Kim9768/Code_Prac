import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	// 데이터처리 객체
	
	private Store[] arr;
	
	public DAO() {
		arr = new Store[10];
	}
	
	public void addOrder(Store user) {
		System.out.println("주문하신 메뉴는 " + user.getitem() + "이며 수량은"
				+ user.getnum() + "개 입니다.");
		System.out.println("주문 완료 되었습니다.");
		updateOrder(user);
		showOrder(user);
		
		
		
	}
	
	public void showOrder(Store user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastfood", "root", "apmsetup");
			System.out.println("DB 연결 성공");
			
			if(user.getmenuStr().equals("1")) {
				sql = "select code, name, count from burger;";
			}else if(user.getmenuStr().equals("2")) {
				sql = "select code, name, count from drink;";
			}else if(user.getmenuStr().equals("3")) {
				sql = "select code, name, count from setmenu;";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("순번" + " " + "메뉴" + " " + "수량");
			System.out.println("===============================");
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int count = rs.getInt("count");
				System.out.println(code + " " + name + " " + count);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ee) {
			ee.printStackTrace();
			
		} finally {
			try {
				rs.close();
				
			} catch(Exception e) {
				
			}
			try {
				pstmt.close();
				
			} catch(Exception e) {
				
			}
			try {
				conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
	
	public void updateOrder(Store user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastfood", "root", "apmsetup");
			System.out.println("DB 연결 성공");
			
			if(user.getmenuStr().equals("1")) {
				sql = "update burger set count = count + ? where code = ? ;";
			}else if(user.getmenuStr().equals("2")) {
				sql = "update drink set count = count + ? where code = ? ;";
			}else if(user.getmenuStr().equals("3")) {
				sql = "update setmenu set count = count + ? where code = ? ;";
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getnum());
			pstmt.setInt(2, user.getchoice());
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ee) {
			ee.printStackTrace();
			
		} finally {
			
			try {
				pstmt.close();
				
			} catch(Exception e) {
				
			}
			try {
				conn.close();
				
			} catch(Exception e) {
				
			}
		}
	}
	
	
}
