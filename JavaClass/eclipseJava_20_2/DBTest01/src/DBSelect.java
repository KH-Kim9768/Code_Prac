import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelect {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = "";
	
	private void dbLoad() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb",
					"root", "apmsetup");
		}catch(ClassNotFoundException ee) {
			ee.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void select() {
		
		try {
			dbLoad();
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
				System.out.printf("%8s  %30s  \t%12d  %s\n", code, toUnicode(name), price, toUnicode(maker));
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


	public void insert(String[] args) {	// insert만 PreparedStatement로 바꿀것
		try {
			dbLoad();
			
//			stmt = conn.createStatement();
//			
//			int rowNum = stmt.executeUpdate("insert into goodsinfo (code, name, price, maker) "
//					+ "values ('" + args[0] + "', '" + toLatin(args[1]) + "', "
//					+ args[2] + ", '"
//					+ toLatin(args[3]) + "');");
//			
//			System.out.println(rowNum + " 행이 추가됨");
			
			sql = "insert into goodsinfo (code, name, price, maker) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, args[0]);
			pstmt.setString(2, toLatin(args[1]));
			pstmt.setInt(3, Integer.parseInt(args[2]));
			pstmt.setString(4, toLatin(args[3]));
			pstmt.executeUpdate();
			
		}  catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		finally {
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
	
	public String toLatin(String str) {
		try {
			byte[] b = str.getBytes();
			return new String(b,"ISO-8859-1");
		} catch(java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public String toUnicode(String str) {
		try {
			byte[] b = str.getBytes("ISO-8859-1");
			return new String(b);
		} catch(java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}


}
