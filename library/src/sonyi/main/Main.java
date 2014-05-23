package sonyi.main;

import sonyi.operation.BookDataOper;
import sonyi.ui.UserFrame;


public class Main {
	public static void main(String[] args) {
		//new UserFrame();
		
//		Vector<String> v = new Vector<>();
//		v.add("6");
//		v.add("dag");
//		v.add("dag");
//		v.add("8");
//		new BookDataOper().update(v,"delete");
		
		new BookDataOper().getdata("书名","中国");
	}
}
