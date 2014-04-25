package cn.imcore.object1;

public class TestPeople {
	public static void main(String[] args) {
		People zhangsan;//声明
		zhangsan = new People();//创建对象（对象实例化）
		
		zhangsan.name = "张三";
		zhangsan.age = 20;
		
		System.out.println("姓名：" + zhangsan.name +",年龄：" +  zhangsan.age);
		
		People p2 = new People();
		p2.name = "李四";
		p2.age = 21;
		System.out.println("姓名：" + p2.name +",年龄：" +  p2.age);
		
		p2.eating(p2.name);
		
		People wangwu;
		wangwu = zhangsan;
		System.out.println("姓名：" + wangwu.name +",年龄：" +  wangwu.age);
				
		
	}
}
