package cn.imcore.oper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.imcore.db.DBConn;

public class UserOper {
	
	public int getUser(String uName, String uPwd) {
		int count = 0;
		//1.获取连接
		Connection conn = DBConn.getConn();
		//2.创建数据库操作对象
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("select count(uId) as num from user where uName=? and uPwd=?");
			pst.setString(1, uName);
			pst.setString(2, uPwd);
			//3.执行语句
			rs = pst.executeQuery();
			while(rs.next()) {
				count = Integer.parseInt(rs.getString(1));
				System.out.println(count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, rs);
		}
		
		return count;
	}

}
