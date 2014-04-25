package cn.imcore.object2;

public class TestPeople {
	public static void main(String[] args) {
		People zhangsan;//声明
		zhangsan = new People();//创建对象（对象实例化）
		
//		zhangsan.name = "张三";
//		zhangsan.age = 20;
		zhangsan.setName("张三");
		zhangsan.setAge(-20);
		
		System.out.println("姓名：" + zhangsan.getName() +",年龄：" +  zhangsan.getAge());
			
		People p2 = new People();
		p2.setName("谢霆锋");
		p2.setAge(33);
		System.out.println("姓名：" + p2.getName() +",年龄：" +  p2.getAge());
		
		People p3 = new People();
		p3.setName("黎明");
		p3.setAge(122);
		System.out.println("姓名：" + p3.getName() +",年龄：" +  p3.getAge());
		
	}
}
