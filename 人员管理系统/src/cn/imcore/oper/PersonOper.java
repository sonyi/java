package cn.imcore.oper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.imcore.db.DBConn;
import cn.imcore.entity.Person;

public class PersonOper {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	//根据ID取人员信息
	public Person getPerson(int pId) {
		Person p = null;
		conn = DBConn.getConn();
		try {
			pst = conn.prepareStatement("select * from person where pId=?");
			pst.setInt(1, pId);
			rs = pst.executeQuery();
			while(rs.next()) {
				p = new Person();
				p.setpId(rs.getInt("pId"));
				p.setpName(rs.getString("pName"));
				p.setpAge(rs.getString("pAge"));
				p.setpSex(rs.getString("pSex"));
				p.setpAddr(rs.getString("pAddr"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, rs);
		}
		
		return p;
	}
	
	
	//增加人员信息
	public void addPerson(Person p) {
		conn = DBConn.getConn();
		try {
			pst = conn.prepareStatement("insert into person(pName,pAge,pSex,PAddr) values(?,?,?,?)");
			pst.setInt(1, p.getpId());
			pst.setString(2, p.getpName());
			pst.setString(3, p.getpAge());
			pst.setString(4, p.getpSex());
			pst.setString(5, p.getpAddr());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, null);
		}
		
	}

	//删除人员信息
	public void delPerson(int pId) {
		conn = DBConn.getConn();
		try {
			pst = conn.prepareStatement("delete from person where pId=?");
			pst.setInt(1, pId);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, null);
		}
	}
	
	//修改人员信息
	public void updPerson(Person p) {
		conn = DBConn.getConn();
		try {
			pst = conn.prepareStatement("update person set pName=?,pAge=?,pSex=?,pAddr=? where pId=?");
			pst.setString(1, p.getpName());
			pst.setString(2, p.getpAge());
			pst.setString(3, p.getpSex());
			pst.setString(4, p.getpAddr());
			pst.setInt(5, p.getpId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pst, null);
		}
	}
	//
}
