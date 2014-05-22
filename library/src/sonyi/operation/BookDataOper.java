package sonyi.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sonyi.database.Conn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BookDataOper {
	
	public Vector<Vector<String>> getdata(){
		Vector<Vector<String>> vector = null;
		Vector<String> v = null;
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String id,name,auth,count;
		try {
			pst = (PreparedStatement) conn.prepareStatement("select * from booksdata");
			rs = pst.executeQuery();
			vector = new Vector<Vector<String>>();
			while (rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				auth = rs.getString(3);
				count = rs.getString(4);
				v = new Vector<>();
				v.add(id);
				v.add(name);
				v.add(auth);
				v.add(count);
				System.out.println(v);
				vector.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, pst, rs);
		}
		return vector;
	}
	
	public void update(Vector<String> v){
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement("insert into booksdata(bname,bauth,bsum) valuse(?,?,?)");
			pst.setString(1, v.get(1));
			pst.setString(2, v.get(2));
			pst.setInt(3, Integer.parseInt(v.get(3)));
			pst.addBatch();
			
			System.out.println(v.get(1) + "-------------------------");
			//pst.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, pst, null);
		}
	}
}
