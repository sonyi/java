package sonyi.text;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Text {
	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
		String user = "root";
		String password = "123";
		PreparedStatement pst = null;
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
			//建立连接
			con = (Connection) DriverManager.getConnection(url, user, password);
			if(!con.isClosed()) {
				System.out.println("数据库已经打开~~~~~~~~~");
			}
			
			//pst = con.prepareStatement(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
