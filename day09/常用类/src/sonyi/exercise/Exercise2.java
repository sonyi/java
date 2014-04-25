package sonyi.exercise;
//练习：
//		编写一个方法，输出在一个字符串中指定字符串出现的次数。
public class Exercise2 {
	public static void main(String[] args) {
		String s = "251ahebdhelihe odhe lodhehelodehhe";
		String s1 = "he";
		int count = 0;
		int start = 0;
		
		//判断方式一：建议使用while循环，因为循环没有自增变量
		while(true){	
			int index = s.indexOf(s1,start);//返回查询结果
			if(index != -1){//判断是否找到，找到后执行方法体里的内容，如果没找到就退出循环
				count++;//每找到一次，增加记录一次
				System.out.println("第" + count + "次出现的位置是：" + index );
				start = index + s1.length();//改变下次循环的起始位置
			}else break;
		}
		
		//判断方式二： for循环，同样可以完成判断结果
		/*//初始化第一次查询结果，并判断
		for(int index = s.indexOf(s1);index != -1;){
			count++;  //每找到一次，增加记录一次
			start = index + s1.length();//改变下次循环的起始位置
			index = s.indexOf("he",start);	//查询下次循环结果，并返回值进行条件判断
		}
		*/
		System.out.println("字符串中，he出现的次数为：" + count);
	}
}
