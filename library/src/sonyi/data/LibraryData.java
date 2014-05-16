package sonyi.data;

import java.io.File;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class LibraryData extends AbstractTableModel{
	private static final long serialVersionUID = 5L;
	String[] names = new String[]{"书名","作者","藏书数量"};
	ArrayList<ArrayList<String>> data;
	
	File dataFile = new File("libraryData.xxx");
	public LibraryData() {
		init();
	}
	
	public void init(){
		data = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < 10; i++){
			ArrayList<String> a = new ArrayList<>();
			for(int j = 0; j < names.length; j++){
				a.add("haha");
			}
			data.add(a);
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
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data.get(rowIndex).get(columnIndex);
	}

}
