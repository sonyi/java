package map.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
	练习：
		需求：对学生对象的年龄进行升序排序。
		因为数据是以键值对形式存在的，所以要使用可以排序的Map集合。TreeMap.
 * 
 */
public class MapTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuNameComparator());
		tm.put(new Student("zhangsan4",21), "beijing");
		tm.put(new Student("zhangsan3",23), "shenzhen");
		tm.put(new Student("zhangsan3",24), "wuhan");
		tm.put(new Student("zhangsan1",24), "xiamen");
		tm.put(new Student("zhangsan2",22), "shanghai");
		
		//按照学生的年龄进行排序
		Set<Map.Entry<Student,String>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Student,String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<Student,String> me = it.next();
			Student s = me.getKey();
			String addr = me.getValue();
			System.out.println(s + " ,地址：" + addr);
		}	
	}
}

class StuNameComparator implements Comparator<Student>{

	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int num = o1.getName().compareTo(o2.getName());
		if(num == 0)
			return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		return num;
	}

}
