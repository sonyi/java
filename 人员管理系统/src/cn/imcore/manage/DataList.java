package cn.imcore.manage;

import javax.swing.table.AbstractTableModel;

public class DataList extends AbstractTableModel{
	String[] names = new String[]{"id��", "����","����","�Ա�"};
	String[][] rowdatas = new String[][]{
			{"1","zhangsan","20","��"},
			{"2","lishi","21","��"},
			{"3","wangwu","22","��"}
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
