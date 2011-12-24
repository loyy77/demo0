package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	final static String url = "jdbc:hsqldb:hsql://localhost/xdb";
	final static String driver = "org.hsqldb.jdbc.JDBCDriver";
	final static String user = "SA";
	final static String password = "";

	static Connection con = null;

	public static Connection getConnection() {

		try {
			Class.forName(driver);
			if (con == null) {
				con= DriverManager.getConnection(url, user, password);
			}

		} catch (ClassNotFoundException e) {
			System.err.println("没有找到需要的类");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public static void closeAll(ResultSet rs, PreparedStatement ps,
			Connection con) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnection(con);
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				System.err.println("关闭ResultSet失败！");
				e.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			if (ps != null&&(!ps.isClosed())) {
				ps.close();

			}
		} catch (SQLException e) {
			System.err.println("关闭PreparedStatement失败！");
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if ( con != null&&(!con.isClosed() )) {
				con.close();
			}
		} catch (SQLException e) {
			System.err.println("关闭数据连接失败！");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * try {
		 * 
		 * String sql = "select * from sys_usr"; PreparedStatement ps =
		 * con.prepareStatement(sql); ResultSet rs = ps.executeQuery();
		 * 
		 * while (rs.next()) {
		 * 
		 * int usr_id = rs.getInt(1); String usr_name = rs.getString(2); String
		 * usr_password = rs.getString(3); int usr_role_id = rs.getInt(4); int
		 * usr_flag = rs.getInt(5);
		 * 
		 * System.out.printf("%d,%s,%s,%d,%d\n", usr_id, usr_name, usr_password,
		 * usr_role_id, usr_flag);
		 * 
		 * } rs.close(); ps.close(); con.close(); } catch
		 * (ClassNotFoundException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } finally {
		 * 
		 * }
		 */
	}
}
