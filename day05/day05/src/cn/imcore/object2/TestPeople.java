package cn.imcore.object2;

public class TestPeople {
	public static void main(String[] args) {
		People zhangsan;//����
		zhangsan = new People();//�������󣨶���ʵ������
		
//		zhangsan.name = "����";
//		zhangsan.age = 20;
		zhangsan.setName("����");
		zhangsan.setAge(-20);
		
		System.out.println("������" + zhangsan.getName() +",���䣺" +  zhangsan.getAge());
			
		People p2 = new People();
		p2.setName("л����");
		p2.setAge(33);
		System.out.println("������" + p2.getName() +",���䣺" +  p2.getAge());
		
		People p3 = new People();
		p3.setName("����");
		p3.setAge(122);
		System.out.println("������" + p3.getName() +",���䣺" +  p3.getAge());
		
	}
}
