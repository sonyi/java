package generic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> ts = new TreeSet<String>(new LenComparetor());
		ts.add("abd01");
		ts.add("a01");
		ts.add("abd02");
		ts.add("ab81");
		ts.add("abd0174");
		
		for(Iterator<String> it = ts.iterator();it.hasNext();){
			String s = it.next();           //不需要再强制类型转换了
			System.out.println(s);
		}		
	}
}

class LenComparetor implements Comparator<String>{//使用泛型
	public int compare(String o1,String o2){//无需再强制类型转换
		int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num == 0)
			return o1.compareTo(o2);
		return num;
	}
}
