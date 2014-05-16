package cn.imcore.test;

import javax.swing.table.AbstractTableModel;

public class JJTableModel extends AbstractTableModel{

	String[][] rowdatas = new String[][]{
			{"aaaaa","aaaaa","aaaaa","aaaaa","aaaaa"},
			{"aaaaa","aaaaa","aaaaa","aaaaa","aaaaa"},
			{"aaaaa","aaaaa","aaaaa","aaaaa","aaaaa"}			
	};
	
	String[] names = new String[]{"×Ö¶Î1","×Ö¶Î2","×Ö¶Î3","×Ö¶Î4","×Ö¶Î5"};
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return names[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowdatas.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowdatas[rowIndex][columnIndex];
	}

	

}
