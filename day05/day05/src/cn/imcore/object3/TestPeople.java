package cn.imcore.object3;

public class TestPeople {
	public static void main(String[] args) {
//		People zhangsan;//声明
//		zhangsan = new People();//创建对象（对象实例化）
//		
//		zhangsan.name = "张三";
//		zhangsan.age = 20;
//		zhangsan.setName("张三");
//		zhangsan.setAge(-20);
		
		People p1 = new People("张三", 20);//通过构造方法直接初始化
		System.out.println(p1.getName() + "," + p1.getAge());
	}
}
