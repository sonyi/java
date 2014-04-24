package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
	Map���ϵ�����ȡ����ʽ��
		1��Set<K> keySet:��Map�����еļ����뵽Set���ϡ���Ϊset�߱���������
			���п��Ե�����ʽȡ�����еļ����ٸ���get��������ȡÿһ������Ӧ��ֵ��
			
			Map���ϵ�ȡ��ԭ����map����ת��set���ϣ���ͨ��������ȡ����
		2��Set<Map.Entry<K,V>> entrySet:��map�����е�ӳ���ϵ���뵽set�����У�
			�������ϵ���������;���Map.Entry.
 */
/*
	Map.Entry:��ʵEntryҲ��һ���ӿڣ�����Map�ӿ��е�һ���ڲ��ӿڡ�
	
interface Map{
	public static interface Entry{
		public abstract Object getKey();
		public abstract Object getValue();
	}
}

class HashMap implements Map{
	class Hash implements Map.Entry{
		public Object getKey(){}
		public Object getValue(){}
	}
}
 */


public class MapDemo2 {
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		map.put("01", "zhangsan1");
		map.put("04", "zhangsan4");
		
		//��ʽ����
		//��map�����е�ӳ���ϵȡ�������뵽set�����С�
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
		
		
		
		/*��ʽһ��
		//�Ȼ�ȡmap���ϵ����м���set���ϣ�����keySet();
		Set<String> keySet = map.keySet();
		
		//����Set���ϣ��Ϳ��Ի�ȡ�������
		for(Iterator<String> it = keySet.iterator(); it.hasNext();){
			String key = it.next();
			//���˼�����ͨ��map���ϵ�get������ȡ���Ӧ��ֵ��
			String value = map.get(key);
			System.out.println("key:" + key + ",value:" + value);
		}
		*/
	}
}
