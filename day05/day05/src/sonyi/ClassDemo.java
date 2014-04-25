package sonyi;


/*
 * ��ѧ���ݣ�
 * 		1��������Ժͷ����������Եĸ�ֵ��ʽ��
 * 		2����ķ�װ�ԡ�
 * 		3�����캯����ʹ�á�
 * 		4��this��ʹ�á�
 */
public class ClassDemo {
	public static void main(String[] args) {
		System.out.println("\n----------��Ĵ��������Ը�ֵ�ͷ����ĵ���------------");
		Person01Test();
		System.out.println("\n-------------------��ķ�װ��----------------------");		
		Person02Test();
		System.out.println("\n---------------���캯����this��ʹ��----------------");		
		Person03Test();
	}
	
	
	//1����Ĵ��������Ը�ֵ�ͷ����ĵ���
	public static void Person01Test(){
		Person01 p1;//����
		p1 = new Person01();//�������󣨶���ʵ������
		p1.name = "����";//�����Ը�ֵ
		p1.age = 20;
		System.out.println("������" + p1.name +",���䣺" +  p1.age);
		
		Person01 p2 = new Person01();//������ͬʱֱ�Ӵ�������
		p2.name = "����";
		p2.age = 21;
		System.out.println("������" + p2.name +",���䣺" +  p2.age);	
		p2.eating();//���ö���ķ�����		
	}
	
	//2����ķ�װ��
	public static void Person02Test(){
		//ͨ�����������������
		Person02 p1 = new Person02();
		p1.setName("����");
		p1.setAge(20);
		System.out.println("������" + p1.getName() +",���䣺" +  p1.getAge());
		
		//�����Ե�����ֵ�����жϣ��ж�����ֵ���������������������ӡ�쳣���������Ը�ֵ
		Person02 p2 = new Person02();
		p2.setName("����");
		p2.setAge(-20);
		System.out.println("������" + p2.getName() +",���䣺" +  p2.getAge());
	}
	
	//3�����캯����this��ʹ��
	public static void Person03Test(){
		
		//�޲εĹ��캯��
		Person03 p1 = new Person03();
		System.out.println("������" + p1.getName() +",���䣺" +  p1.getAge() + ",�Ա�" + p1.getSex());
		
		//һ�������Ĺ��캯�����Զ��󸳳�ʼֵ
		Person03 p2 = new Person03("����");
		System.out.println("������" + p2.getName() +",���䣺" +  p2.getAge() + ",�Ա�" + p2.getSex());
		
		//���������Ĺ��캯�����Զ��󸳳�ʼֵ
		Person03 p3 = new Person03("����",20,'Ů');
		System.out.println("������" + p3.getName() +",���䣺" +  p3.getAge() + ",�Ա�" + p3.getSex());
		
		//���������Ĺ��캯������ʼֵ���Ա�����䣩������Ҫ��Ļ�������ʾ
		Person03 p4 = new Person03("����",30,'��');
		System.out.println("������" + p4.getName() +",���䣺" +  p4.getAge() + ",�Ա�" + p4.getSex());	
		
		p4.setSex('��');//���ö���¶�ķ����Դ�������Խ����޸�
		System.out.println("������" + p4.getName() +",���䣺" +  p4.getAge() + ",�Ա�" + p4.getSex());	
	}
}

//1����Ĵ���
class Person01 {	
	//����
	String name;
	int age;
	char sex;

	//��Ϊ-����
	public void eating() {
		System.out.println(name + "���ڳԷ�������������������");
	}
}

//2����ķ�װ��
class Person02 {	
	//��������Ϊ˽�У�ֻ�������ڲ�ʹ��(��װ)
    private String name;
    private int age = 1;
	
	//���Ⱪ¶�������Ժͻ�ȡ���Եķ����������ԶԸ�ֵ�����ж�
	public String getName(){//��ȡname
		return name;
	}
	
	public void setName(String name) {//����name
		this.name = name;
	}
	
	public int getAge() {//��ȡage
		return age;
	}
	
	public void setAge(int age) {//����age
		if(age<=0 || age>120) {//����Ĺ���
			System.out.println("���䲻�Ϸ�");
			return;
		}
		this.age = age;	
	}
	
	public void eating(String name) {
		System.out.println(name + "���ڳԷ�����������������������");
	}
}

//3�����캯����this��ʹ��
	/*
		1��this����ǰ����
		2�����ܷ��ھ�̬�������档
		3�����ֲ������ͳ�Ա������ȫ�ֱ���������ʱ���������ʳ�Ա����ʱ����this.��Ա������
		4��this���ù��췽��ʱ����Ҫ���ڹ��췽���ڵĵ�һ�С�
	*/
class Person03 {
	//����(��װ)
	private String name;
	private int age = 1;
	private char sex;
	
	//�޲ι��캯��
	public Person03() {
		this("zhangsan");
	}
	
	//һ�������Ĺ��캯��
	public Person03(String name) {
		this(name, 1, '��');//�������������Ĺ��캯��
	}
	
	//���������Ĺ��캯��
	public Person03(String name, int age, char sex) {
		this.name = name;//this������ø÷����ĵ�ǰ����
		setAge(age);
		setSex(sex);//���÷������ж�������Ϣ�Ƿ��������
	}
	
	//��Ϊ-����
	public String getName(){//��ȡname
		return name;
	}
	
	public void setName(String name) {//����name
		this.name = name;
	}
	
	public int getAge() {//��ȡage
		return age;
	}
	
	public void setAge(int age) {//����age
		if(age<=0 || age>120) {//����Ĺ���
		System.out.println(this.name + "���������벻�Ϸ�");
			return;
		}
		this.age = age;	
	}
	
	public void setSex(char sex){//����sex
		if(sex == '��' || sex == 'Ů')
			this.sex = sex;	
		else
			System.out.println(this.name  + "���Ա�������������������");
	}
	
	public char getSex(){//��ȡsex
		return sex;
	}
	
	public void eating(String name) {
		System.out.println(name + "���ڳԷ�����������������������");
	}
}
