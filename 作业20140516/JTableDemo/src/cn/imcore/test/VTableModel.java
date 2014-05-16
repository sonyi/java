package cn.imcore.test;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class VTableModel extends AbstractTableModel{
	String[] names = new String[]{"�ֶ�1","�ֶ�2","�ֶ�3","�ֶ�4","�ֶ�5"};
	
	Vector<Vector<String>> rowsdata;
	
	public VTableModel() {
		rowsdata = new Vector<Vector<String>>();
		for(int i=0; i<8; i++) {//��
			Vector<String> v = new Vector<String>();
			for(int j=0; j<5; j++) {//��
				v.add("aaaa"+i+j);			
			}
			rowsdata.add(v);
		}
	}
		
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return names[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowsdata.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowsdata.get(rowIndex).get(columnIndex);
	}

	

}
