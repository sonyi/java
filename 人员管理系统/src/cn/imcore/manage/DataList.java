package cn.imcore.manage;

import javax.swing.table.AbstractTableModel;

public class DataList extends AbstractTableModel{
	String[] names = new String[]{"id号", "姓名","年龄","性别"};
	String[][] rowdatas = new String[][]{
			{"1","zhangsan","20","男"},
			{"2","lishi","21","男"},
			{"3","wangwu","22","男"}
	};
	
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
