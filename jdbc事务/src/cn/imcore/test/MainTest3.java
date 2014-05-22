package cn.imcore.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainTest3 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
		String user = "root";
		String password = "123";
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			if(!conn.isClosed()) {
				System.out.println("数据库已经打开~~~~~~~~~");
			}
			
			//创建statement对象
			stat = conn.prepareStatement("update student set sAddr=? where sid=?");
			stat.setString(1, "漳州");
			stat.setInt(2, 1006);
			stat.addBatch();
			stat.setString(1, "泉州");
			stat.setInt(2, 1007);
			stat.addBatch();
			
			stat.executeBatch();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
