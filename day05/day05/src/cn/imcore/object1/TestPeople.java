package cn.imcore.object1;

public class TestPeople {
	public static void main(String[] args) {
		People zhangsan;//����
		zhangsan = new People();//�������󣨶���ʵ������
		
		zhangsan.name = "����";
		zhangsan.age = 20;
		
		System.out.println("������" + zhangsan.name +",���䣺" +  zhangsan.age);
		
		People p2 = new People();
		p2.name = "����";
		p2.age = 21;
		System.out.println("������" + p2.name +",���䣺" +  p2.age);
		
		p2.eating(p2.name);
		
		People wangwu;
		wangwu = zhangsan;
		System.out.println("������" + wangwu.name +",���䣺" +  wangwu.age);
				
		
	}
}
