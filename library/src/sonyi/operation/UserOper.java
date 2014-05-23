package sonyi.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sonyi.database.Conn;

public class UserOper {
	
	public int getUser(String name,String password){
		int count = 0;
		//获取连接
		Connection conn =Conn.getConnection();
		//创建数据库对象
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select count(uid) as num from usersys where uname=? and upassword=?");
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, ps, rs);
		}
		return count;
	}
}
