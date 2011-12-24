package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitData {
	public static void insertData() {
		System.out.println("InitData.insertData()-->Start!");
		Connection con = DBUtil.getConnection();

		String sql = "INSERT INTO SYS_USR( USR_NAME, USR_PASSWORD, USR_ROLE_ID, USR_FLAG)VALUES (?, ?,? ,? )";
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);

			for (int i = 0; i < 138; i++) {
				ps = con.prepareStatement(sql);

				ps.setString(1, "loyy" + i);
				ps.setString(2, "123");
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.executeUpdate();
				System.out.println(i);
			}
			con.commit();

		} catch (SQLException e) {
			System.err.println("初始化数据时出现异常！");
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(null, ps, con);
		}
		System.out.println("InitData.insertData()-->End!");
	}

	public static void main(String[] args) {
		insertData();
	}
}
