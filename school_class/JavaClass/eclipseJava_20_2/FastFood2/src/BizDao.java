
import java.sql.*;

public class BizDao {

	public void addoder(Store order){
		
		if (order.getmenuStr().equals("1")) {
			System.out.println("주문하신 메뉴는 "+order.getitem()+"이며 수량은 "+order.getsuryang()+"입니다.");
			System.out.println("주문 완료 되었습니다.");
			updateOrder(order);
			showOrder(order);
		} else if (order.getmenuStr().equals("2")) {
			System.out.println("주문하신 메뉴는 "+order.getitem()+"이며 수량은 "+order.getsuryang()+"입니다.");
			System.out.println("주문 완료 되었습니다.");
			updateOrder(order);
			showOrder(order);
		} else if (order.getmenuStr().equals("3")) {
			System.out.println("주문하신 메뉴는 "+order.getitem()+"이며 수량은 "+order.getsuryang()+"입니다.");
			System.out.println("주문 완료 되었습니다.");
			updateOrder(order);
			showOrder(order);
		}

	}
	
	public void showOrder(Store order){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastfood", "root", "apmsetup");
			System.out.println("데이터베이스에 접속했습니다.");
			if (order.getmenuStr().equals("1")) {
				sql = "select code, name, count from burger;";	
				
			} else if (order.getmenuStr().equals("2")) {
				sql = "select code, name, count from drink;";
				
			} else if (order.getmenuStr().equals("3")) {
				sql = "select code, name, count from setmenu;";

			}
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("순번" + " " + "메뉴" + " " + "수량");
			System.out.println("-------------------------------------");
			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int count = rs.getInt("count");
				System.out.println(code + " " + name + " " + count);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스 찾을 수 없습니다" + e.getMessage());
		} catch (SQLException se){
			System.out.println(se.getMessage());
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {
			}
			try {
				pstmt.close();
			} catch (Exception ignored) {
			}
			try {
				conn.close();
			} catch (Exception ignored) {
			}
		}
	}
	
	
	
	public void updateOrder(Store order){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastfood", "root", "apmsetup");
			
			if (order.getmenuStr().equals("1")) {
				sql = "update burger set count = count + ? where code = ?";
				
			} else if (order.getmenuStr().equals("2")) {
				sql = "update drink set count = count + ? where code = ?";
				
			} else if (order.getmenuStr().equals("3")) {
				sql = "update setmenu set count = count + ? where code = ?";
				
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getsuryang());
			pstmt.setInt(2, order.getchoice());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스 찾을 수 없습니다" + e.getMessage());
		} catch (SQLException se){
			System.out.println(se.getMessage());
		} finally {
			
			try {
				pstmt.close();
			} catch (Exception ignored) {
			}
			try {
				conn.close();
			} catch (Exception ignored) {
			}
		}
	}
}
