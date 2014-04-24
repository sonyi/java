package set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/*
	练习：
		按照字符串长度排序
	思路：字符串本身具备比较性，但是它的比较方式不是所需要的，这时就只能使用比较器
 */
public class TreeSetTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> ts = new TreeSet<String>(new StringLengthComparator());
		ts.add("abcd");
		ts.add("abd");
		ts.add("cd");
		ts.add("d");
		ts.add("adbcd");
		ts.add("aacd");
		
		for(Iterator<String> it = ts.iterator(); it.hasNext();){//遍历集合
			System.out.println(it.next());
		}
	}
}

class StringLengthComparator implements Comparator<Object>{

	public int compare(Object o1, Object o2) {
		String s1 = (String)o1;
		String s2 = (String)o2;
		int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if(num == 0) 
			return s1.compareTo(s2);
		return num;
	}

		
}



