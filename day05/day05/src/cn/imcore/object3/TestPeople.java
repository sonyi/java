package cn.imcore.object3;

public class TestPeople {
	public static void main(String[] args) {
//		People zhangsan;//����
//		zhangsan = new People();//�������󣨶���ʵ������
//		
//		zhangsan.name = "����";
//		zhangsan.age = 20;
//		zhangsan.setName("����");
//		zhangsan.setAge(-20);
		
		People p1 = new People("����", 20);//ͨ�����췽��ֱ�ӳ�ʼ��
		System.out.println(p1.getName() + "," + p1.getAge());
	}
}
