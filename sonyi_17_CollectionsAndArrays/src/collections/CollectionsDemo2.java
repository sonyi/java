package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/*
	������ϰ��
		fill�������Խ�list����������Ԫ���滻��ָ��Ԫ�ء�
			��list�����в���Ԫ���滻��ָ��Ԫ��
 * 
 */
public class CollectionsDemo2 {

	public static void main(String[] args) {
		//fillDemo();
		//replaceAllDemo();
		//orderDemo();
		shuffleDemo();
	}
	
	public static void shuffleDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		System.out.println(list);
		Collections.shuffle(list);//�������е�Ԫ�ذ�������Խ����ٴ�����
		System.out.println(list);
	}
	
	public static void orderDemo(){
		//���ַ�ʽ�����ϰ���Ȼ˳��ķ�������
		//TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder()/*new StrComparator()*/);
		//�Զ�������ʽ�����������򣩣������ϰ����Զ�������ķ�������
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new strLengthSort()));
		
		ts.add("abced");
		ts.add("aa");
		ts.add("kkk");
		ts.add("c");
		
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	
	}
	
	public static void replaceAllDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		System.out.println(list);
		Collections.replaceAll(list, "ad", "kkk");//�滻
		System.out.println(list);
		
		Collections.reverse(list);//��ת
		System.out.println(list);
	}
	
	public static void fillDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		System.out.println(list);
		Collections.fill(list, "qq");//��������Ԫ�أ�ȫ���滻��ָ��ֵ
		System.out.println(list);
	}

}

//�Զ��巴������
class StrComparator implements Comparator<String>{
	public int compare(String s1, String s2){
		return s2.compareTo(s1);
	}
}
