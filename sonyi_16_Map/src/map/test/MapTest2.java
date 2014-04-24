package map.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
	��ϰ��
		���󣺶�ѧ����������������������
		��Ϊ�������Լ�ֵ����ʽ���ڵģ�����Ҫʹ�ÿ��������Map���ϡ�TreeMap.
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
		
		//����ѧ���������������
		Set<Map.Entry<Student,String>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Student,String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<Student,String> me = it.next();
			Student s = me.getKey();
			String addr = me.getValue();
			System.out.println(s + " ,��ַ��" + addr);
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
