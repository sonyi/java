package cn.imcore.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
//		Statement stat = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			if(!conn.isClosed()) {
				System.out.println("数据库已经打开~~~~~~~~~");
			}
			
			//创建statement对象
			String sql = "select * from tblstudent where sid=1003";
//			stat = conn.createStatement();
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery(sql);
			while(rs.next()) {
				int sId = rs.getInt("sId");
				String sName = rs.getString("sName");
				System.out.println(sId + "," + sName);
			}
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
//			if(stat != null) {
//				try {
//					stat.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
