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
			//������������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			
			if(!conn.isClosed()) {
				System.out.println("���ݿ��Ѿ���~~~~~~~~~");
			}
			
			//����statement����
			stat = conn.prepareStatement("update student set sAddr=? where sid=?");
			stat.setString(1, "����");
			stat.setInt(2, 1006);
			stat.addBatch();
			stat.setString(1, "Ȫ��");
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
