package cn.imcore.oper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import cn.imcore.db.DBConn;

public class JDataModel extends AbstractTableModel{
	private Vector<Vector<String>> rowsData = new Vector<Vector<String>>();
	
	private String[] columnNames = new String[]{
			"ID", "姓名", "年龄", "性别", "地址"
	};
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public JDataModel() {
		//连接数据库
		conn = DBConn.getConn();
		try {
			pst = conn.prepareStatement("select * from person");
			rs = pst.executeQuery();
			while(rs.next()) {
				Vector<String> v = new Vector();
				v.add(String.valueOf(rs.getInt("pId")));
				v.add(rs.getString("pName"));
				v.add(rs.getString("pAge"));
				v.add(rs.getString("pSex"));				
				v.add(rs.getString("pAddr"));
				
				rowsData.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, rs);
		}
		
	}
	
	public JDataModel(String pName) {
		//连接数据库
		conn = DBConn.getConn();
		try {
			pst = conn.prepareStatement("select * from person where pName like ?");
			pst.setString(1, "%"+pName+"%");//按姓名模糊查询
			rs = pst.executeQuery();
			while(rs.next()) {
				Vector<String> v = new Vector();
				v.add(String.valueOf(rs.getInt("pId")));
				v.add(rs.getString("pName"));
				v.add(rs.getString("pAge"));
				v.add(rs.getString("pSex"));				
				v.add(rs.getString("pAddr"));
				
				rowsData.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, rs);
		}
		
	}
	
	@Override
	public String getColumnName(int column) {
		
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowsData.size();
	}

	@Override
	public int getColumnCount() {
	
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return rowsData.get(rowIndex).get(columnIndex);
	}

	
}
