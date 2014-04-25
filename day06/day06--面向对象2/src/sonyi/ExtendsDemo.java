package sonyi;

/*
 * 
 *��ϰ:
 *	Ŀ�ģ���ϰthis��super��ʹ�ã����췽������ʼֵ���̳г���
 *	���裺
 *		1���½�һ��Company��
 *			���ԣ��������Ա𣬹���(����Ϊ˽��)
 *			������printMsg();//��ӡ������ŵ���Ա������Ϣ
 *		2���½�һ��Dept��̳�Company
 *			���ԣ�����
 *			������printMsg();//��ӡ������ŵ���Ա������Ϣ
 *		3���½�һ��Manage��̳�Dept
 *			���ԣ�ְλ
 *			������printMsg();//��ӡ������ŵ���Ա������Ϣ
 *		4���½�һ��������
 *			ʵ����һ��Company����ʵ����һ��Dept����ʵ��������Manage����
 *				�ֱ��ӡ���Ե�ȫ����Ϣ��
 */
public class ExtendsDemo {
	public static void main(String[] args) {

		//��������Ķ��󣬲���ʼ��ֵ
		Company c1 = new Company("����",'��',2000);
		Company c2 = new Company("С��",'��');
		Dept d = new Dept("С��",'Ů',3000,"ǰ��");
		Manage m1 = new Manage("����",'��',2500,"���","����ʦ");
		Manage m2 = new Manage("С��",'Ů',3500,"���ݿ�","���ݿ⹤��ʦ");
		
		//��ӡ�������ȫ����Ϣ
		c1.printMsg();
		c2.printMsg();
		d.printMsg();
		m1.printMsg();
		m2.printMsg();
	}

}

//����Company����
class Company{
	private String name;//����˽������
	private char sex;
	private double salary;
	
	public Company(){//�޲ι��췽��
	}
	
	public Company(String name, char sex, double salary) {//���ع��췽��������������
		this.name = name;//this��ʹ��1�����ñ�������Ժͷ���
		this.sex = sex;
		this.salary = salary;
	}	

	public Company(String name, char sex) {	//���������Ĺ��췽�������أ�
		this(name,sex,0.0);//this��ʹ��2�����ñ���Ĺ��췽��
	}


	public String getName() {//����˽�����ԵĻ�ȡ����
		return name;
	}
	
	public void setName(String name) {//����˽�����Եĸ�ֵ����
		this.name = name;
	}
	
	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void printMsg(){
		System.out.println("�ҵ������ǣ�" + getName() + ",�ҵ��Ա��ǣ�" + getSex() + 
				",�ҵĹ����ǣ�" + getSalary());
	}
}

//����Company������
class Dept extends Company{
	
	private String skill;//���ö������е�˽������
	
	Dept(){	
	}
	
	//�ĸ������Ĺ��캯��
	Dept(String name,char sex,double salary,String skill){
		super(name,sex,salary);//super��ʹ��1�����ø���Ĺ��캯���������ظ�����
		this.skill = skill;
	}	
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public void printMsg(){//��ӡ�����������Ϣ
		super.printMsg();//super��ʹ��2�����ø���ķ����������ظ�����
		System.out.println("\t�ҵļ����ǣ�" + getSkill());
	}
}

//����Dept������
class Manage extends Dept{
	//���ø������е�˽������
	private String position;

	Manage(){//�޲ι��캯��	
	}
	
	//��������Ĺ��캯��
	Manage(String name,char sex,double salary,String skill,String position){
		super(name,sex,salary,skill);//���ø���Ĺ��캯��
		this.position = position;
	}
	
	public String getPosition() {//����˽�����ԵĻ�ȡ����
		return position;
	}

	public void setPosition(String position) {//����˽�����Եĸ�ֵ����
		this.position = position;
	}
	
	public void printMsg(){//��ӡ�������е���Ϣ
		super.printMsg();//���ø���Ĵ�ӡ�����������ظ�����
		System.out.println("\t�ҵ�ְλ�ǣ�" + getPosition());
	}
	
}
