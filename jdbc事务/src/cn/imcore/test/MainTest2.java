package cn.imcore.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest2 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		Statement stat = null;
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			if(!conn.isClosed()) {
				System.out.println("数据库已经打开~~~~~~~~~");
			}
			
			//创建statement对象
			stat = conn.createStatement();
//			conn.prepareStatement(sql);
			String del_sql = "delete from tblscore where sid=1004 and score=80";
			String upd_sql = "update tblscore set score=73 where score=73.75";
			
			int b = stat.executeUpdate(del_sql);
			int b2 = stat.executeUpdate(upd_sql);
			System.out.println("b=" + b + ",b2=" + b2);
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
