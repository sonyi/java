package map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
	练习：
		"abhdehodahbdodscndhwhshdls"获取该字符串中的字母出现次数。
			希望打印的结果是：a(1) c(2).......
	思路：
		通过结果发现，每个字母都有对应的次数。说明字母和次数之间都有映射关系。
		注意：当发现有映射关系时，可以选择map集合。因为map集合中存放的就是映射关系。
		
	什么时候使用map集合呢？
		当数据之间存在映射关系时，首先就要想到map集合。
		
	思路：
		1、将字符串转换成字符数组，因为要对每一个字母进行操作。
		2、定义一个map集合，因为打印结果的字母有顺序，所以使用TreeMap集合。
		3、遍历字符数组，将每一个字母作为键去查map集合，如果返回空，就将该字母和1存入到map集合中，如果返回不是空，
			说明该字母在map集合内已经存在，并有对应的次数，那么就获取该次数并进行自增，然后将该字母和自增后的次数存入
			到集合中，覆盖掉原来所对应的值。
		4、将map集合中的数据变成指定的字符串返回。
		
 */
public class MapTest3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = charCount("abhdeh78odahbd51odscndhwh/.,shdls");
		System.out.println(s);
	}
	
	public static String charCount(String str){
		char[] ch = str.toCharArray();//将字符串转换成字符数组
		TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();//定义一个TreeMap集合，存储字符并计数
		int count = 0;
		
		//遍历字符数组
		for(int i = 0; i < ch.length; i++){		
			//判断是否是字符，如果不是，跳出此次循环，进入下一个字符，次字符不计数
			if(!(ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >='A' && ch[i] <= 'Z'))
				continue;
			
			Integer value = map.get(ch[i]);
			
			//判断字符并存储：方式二：
			if(value != null)
				count = value;
			count++;
			map.put(ch[i], count);
			count = 0;
			
			
			/*//判断字符并存储：方式一：
			if(value == null)
				map.put(ch[i], 1);
			else
				map.put(ch[i], value + 1);
			*/
		}
		//System.out.println(map);//打印集合内容
		
		//修改集合内元素的输出方式
		StringBuilder sb = new StringBuilder();//定义一个StringBuilder，用来存储字符数组内的每个元素
		Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();//定义一个集合
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();//定义一个迭代器
		while(it.hasNext()){//获取迭代器里面的内容，并添加到StringBuilder中
			Map.Entry<Character,Integer> me = it.next();
			Character c = me.getKey();
			Integer i = me.getValue();
			sb.append(c + "(" + i + ") ");	
		}
		
		return sb.toString();//返回字符串
	}
}
