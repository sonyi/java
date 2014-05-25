package sonyi.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import sonyi.database.Conn;


public class BookDataOper {
	
	public Vector<Vector<String>> getdata(String queryCondition,String queryText){
		Vector<Vector<String>> vector = null;
		Vector<String> v = null;
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String id,name,auth,count;
		System.out.println("vector:" + v);
		try {
			if(queryCondition != null && queryText != null){
				//System.out.println("vector---22222222222222--2:" + v);
				
				if(queryCondition.equals("书名")){
					//System.out.println("vector-----2:" + v);
					pst = conn.prepareStatement("select * from booksdata where bname like ?");
				}else if(queryCondition.equals("作者")){
					pst = conn.prepareStatement("select * from booksdata where bauth like ?");
				}else if(queryCondition.equals("藏书数量")){
					pst = conn.prepareStatement("select * from booksdata where bsum like ?");
				}
				System.out.println("vector3-------:" + v);
				pst.setString(1, "%" + queryText + "%");
				
			}else {
				pst = conn.prepareStatement("select * from booksdata");
			}
			
			rs = pst.executeQuery();
			vector = new Vector<Vector<String>>();
			System.out.println("vector4------:" + v);
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
				System.out.println("vector:" + v);
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
	
	
	public void changeIndex(int index){//改变id值
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = (PreparedStatement) conn.prepareStatement("update booksdata set bid=? where bid=?");
			pst.setInt(1, index-1);
			pst.setInt(2, index);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, pst, null);
		}
	}
	
	public void insertData(Vector<String> v){
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement("insert into booksdata (bid,bname,bauth,bsum) values (?,?,?,?)");
			pst.setInt(1, Integer.parseInt(v.get(0)));
			pst.setString(2, v.get(1));
			pst.setString(3, v.get(2));
			pst.setInt(4, Integer.parseInt(v.get(3)));
			//System.out.println(v.get(1) + "-------------------------");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, pst, null);
		}
	}
	
	public void updateData(Vector<String> v){
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		try {
			pst = (PreparedStatement) conn.prepareStatement("update booksdata set bname=?,bauth=?,bsum=? where bid=?");
			pst.setString(1, v.get(1));
			pst.setString(2, v.get(2));
			pst.setInt(3, Integer.parseInt(v.get(3)));
			pst.setInt(4, Integer.parseInt(v.get(0)));
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, pst, null);
		}
	}
	
	public void deleteData(Vector<String> v){
		Connection conn = Conn.getConnection();
		PreparedStatement pst = null;
		try {	
			pst = (PreparedStatement) conn.prepareStatement("delete from booksdata where bid=? and bname=? and bauth=? and bsum=?");
			pst.setInt(1, Integer.parseInt(v.get(0)));
			pst.setString(2, v.get(1));
			pst.setString(3, v.get(2));
			pst.setInt(4, Integer.parseInt(v.get(3)));
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Conn.closeConnection(conn, pst, null);
		}
	}
}
