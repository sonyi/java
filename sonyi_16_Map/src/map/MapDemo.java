package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
	Map���ϣ��ü��ϴ洢��ֵ�ԣ�һ��һ������棬����Ҫ��֤����Ψһ�ԡ�
		1����ӣ�
			put(key,value);
			putAll(Map<? extends K,? extends v> m);
		2���жϣ�
			boolean containsKey();
			boolean containsValue()
			isEmpty();
		3��ɾ����
			void clear();
			remove(key);
		4����ȡ��
			get(key)
			size();
			values();
			
			entrySet();
			keySet();
			
	Map:
		|--Hashtable:�ײ��ǹ�ϣ�����ݽṹ�������Դ���null����nullֵ���ü������߳�ͬ���ġ�JDK1.0.Ч�ʵ͡�
		|--HashMap:�ײ��ǹ�ϣ�����ݽṹ������ʹ��null����nullֵ���ü����ǲ�ͬ���ġ�JDK1.2.Ч�ʸߡ�
		|--TreeMap:�ײ��Ƕ��������ݽṹ���̲߳�ͬ�����������ڸ�Map�����еļ���������
		
	��Set������ʵSet�ײ��������Map���ϡ�
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		//���Ԫ�أ�����������ʱ����ͬ�ļ�����ô����ӵ�ֵ�Ḳ��ԭ�м���Ӧ��ֵ��
		//��put�����᷵�ر����ǵ�ֵ��		
		System.out.println("put:" + map.put("01", "zhangsan1"));
		System.out.println("put:" + map.put("01", "wangwu1"));
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		
		System.out.println("containsKey:" + map.containsKey("02"));
		System.out.println("remove:" + map.remove("02"));
		System.out.println("get:" + map.get("01"));
		
		//����ͨ��get�����ķ���ֵ���ж�һ�����Ƿ���ڡ�ͨ������null���ж�
		map.put(null, "05");
		map.put("04", null);
		System.out.println("get:" + map.get("04"));
		
		//��ȡMap���������Ե�ֵ
		Collection<String> coll = map.values();
		System.out.println(coll);
		
		System.out.println(map);
	}
}
