package cn.imcore.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {

	public static void main(String[] args){
		Map map = new HashMap();
		map.put(8, "888");
		map.put(4, "444");
		map.put(3, "333");
		map.put(1, "111");
		map.put(2, "222");
		map.put(5, "111");
		
		System.out.println(map);
		System.out.println("����Keyȡֵ��" + map.get(4));
		System.out.println("ɾ��KeyΪ2��" + map.remove(2));
		
		System.out.println("��KeyΪ4������Ϊaaa��" + map.put(4, "aaa"));
		System.out.println(map);
		System.out.println("�Ƿ����Key 3��" + map.containsKey(3));//true
		System.out.println("�Ƿ����value 111��" + map.containsValue("111"));//true
		System.out.println("size:" + map.size());
		
		Set keyset = map.keySet();
		System.out.println("���ļ��ϣ�" + keyset);
		System.out.println("ֵ�ļ��ϣ�" + map.values());
		
		//Map����ֱ�ӱ�����Ҫ��ת��keySet��Ȼ���ٱ���
		Iterator it = keyset.iterator();
		while(it.hasNext()) {
			int key = (int) it.next();//ȡ��keyֵ
			System.out.println(key + "," + map.get(key));
		}
	}
}
