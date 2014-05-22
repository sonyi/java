package sonyi.main;

import java.util.Vector;

import sonyi.operation.BookDataOper;
import sonyi.ui.UserFrame;


public class Main {
	public static void main(String[] args) {
		//new UserFrame();
		Vector<String> v = new Vector<>();
		v.add("4");
		v.add("haha");
		v.add("heheh");
		v.add("6");
		BookDataOper b = new BookDataOper();
		b.update(v);
		b.getdata();
	}
}
