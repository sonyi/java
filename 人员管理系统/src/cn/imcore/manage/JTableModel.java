package cn.imcore.manage;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import cn.imcore.entity.Person;

public class JTableModel extends AbstractTableModel {

	String[] names = new String[]{"id号", "姓名","年龄","性别"};
	public static Vector<Vector<String>> rowdatas;
	
	public JTableModel() {
		rowdatas = new Vector<Vector<String>>();
		Vector v1 = new Vector();
		v1.add(1);
		v1.add("liming");
		v1.add(20);
		v1.add("男");
		
		Vector v2 = new Vector();
		v2.add(2);
		v2.add("huangxiao");
		v2.add(22);
		v2.add("男");
		
		Vector v3 = new Vector();
		v3.add(3);
		v3.add("zhangsan");
		v3.add(24);
		v3.add("男");
		
		rowdatas.add(v1);
		rowdatas.add(v2);
		rowdatas.add(v3);
		
		
	}
	
	public JTableModel(String s) {
		
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return names[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowdatas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowdatas.get(rowIndex).get(columnIndex);
	}

}
