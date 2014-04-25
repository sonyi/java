package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	���Ͽ�ܵĹ����ࣺ
		collections��
 */
public class CollectionsDemo {
	public static void main(String[] args) {

		sortDemo();
//		maxDemo();
//		binarySearchDemo();
	}
	
	public static void binarySearchDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		Collections.sort(list);
		System.out.println(list);//
		int index = Collections.binarySearch(list, "aa");
		System.out.println("index:" + index);
		
		int index1 = halfSearch(list,"qq");
		System.out.println("index1:" + index1);
		
		Collections.sort(list,new strLengthSort());
		System.out.println(list);
		int index2 = halfSearch2(list,"qq",new strLengthSort());
		System.out.println("index2:" + index2);
	}
	
	public static int halfSearch(List<String> list,String key){
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		while(min <= max){
			mid = (max + min)>>1;
			String str = list.get(mid);
			int num = str.compareTo(key);
			if(num > 0)
				max = mid - 1;
			else if(num < 0)
				min = mid + 1;
			else 
				return mid;
		}
		return -min-1;
	}
	
	public static int halfSearch2(List<String> list,String key,Comparator<String> cmp){
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		while(min <= max){
			mid = (max + min)>>1;
			String str = list.get(mid);
			int num = cmp.compare(str, key);
			if(num > 0)
				max = mid - 1;
			else if(num < 0)
				min = mid + 1;
			else 
				return mid;
		}
		return -min-1;
	}
	
	public static void  maxDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
		
		String max = Collections.max(list);//���ù��ߣ���ȡ���ֵ
		System.out.println(max);
		
		String max1 = Collections.max(list,new strLengthSort());//�ص�Ƚϣ������ȣ���ȡ���ֵ
		System.out.println(max1);	
	}
	
	
	public static void sortDemo(){
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ad");
		list.add("a");
		list.add("qq");
		list.add("zzz");
		list.add("dsd");
			
		System.out.println(list);//������
		//Collections.sort(list);//���ù��ߣ���Ȼ����
		Collections.swap(list, 1, 2);//�û���������Ԫ�ء�
		System.out.println(list);	
		
		Collections.sort(list,new strLengthSort());//�ص����򣨰����ַ�����������
		System.out.println(list);	
	}
}

//�����Ƚ����������ַ������ȱȽ�
class strLengthSort implements Comparator<String>{

	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length() == o2.length())
			return o1.compareTo(o1);
		else return o1.length() - o2.length();
	}
}
