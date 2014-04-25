package sonyi;
/*
	��ϰ��
		����һ�����࣬�������ԣ����� name���Ա� sex������ age�������������Է� eat() ��˯�� sleep() ������ work() ��
			��1���������࣬����һ��ѧ���࣬�������ԣ�ѧУ school��ѧ�� no����д����������ѧ���Ĺ�����ѧϰ����
			��2���������࣬����һ�������࣬�������ԣ���λ company������ workAge����д�������������˵Ĺ����ǡ����Լ���ɣ���
			��3������ѧ���࣬����һ��ѧ���ɲ��࣬�������ԣ�ְ�� job�����ӷ��������� meeting()��
			��4����д�������ֱ������3�����������в��ԡ�
 */
public class Exercise4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ת�ͣ��Զ�����з�װ
		Person p1 = new Worker("����",'��',26,"������˾",2.5);
		System.out.println(p1);
		p1.eat();
		p1.sleep();
		p1.work();
		
		Person p2 = new Student("С��",'Ů',20,"����ѧУ",007);
		System.out.println(p2);
		p2.eat();
		p2.sleep();
		p2.work();
		
		Person p3 = new StudentCadre("С��",'��',27,"�����ѧУ",007,"ѧ�����ϴ�");
		System.out.println(p3);
		p3.eat();
		p3.sleep();
		p3.work();
		StudentCadre sc = (StudentCadre)p3;//����ת�ͣ����ö������з�����
		sc.meeting();
			
	}
}
class StudentCadre extends Student{
	private String job;
	
	StudentCadre(){
		
	}
	StudentCadre(String name,char sex,int age,String school,int no,String job){
		super(name,sex,age,school,no);
		this.job = job;
	}
	public void meeting(){
		System.out.println("ѧ���ɲ���"+ super.getName() +"�ڿ���");
	}
	
	
	@Override
	public String toString() {
		return "StudentCadre [������"+ getName() + ",���䣺" + getAge() + ", �Ա�"+ getSex() +
				", ѧУ��" + getSchool() + ",ѧ�ţ�" + getNo() + ", �ɲ�ְ��:" + job + "]";
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}

class Student extends Person{
	private String school;
	private int no;
	
	Student(){
		
	}
	Student(String name,char sex,int age,String school,int no){
		super(name,sex,age);
		this.school = school;
		this.no = no;
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("ѧ��"+ super.getName() +"��ʳ�óԷ�");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("ѧ��"+ super.getName() +"�ڼ�������˯��");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("ѧ��"+ super.getName() +"�ú�ѧϰ");
	}
	
	
	@Override
	public String toString() {
		return "Student [������"+ getName() + ",���䣺" + getAge() + ", �Ա�"+ getSex() +
				", ѧУ��" + school + ",ѧ�ţ�" + no + "]";
	}
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}

class Worker extends Person{
	private String company;
	private double workAge;
	
	Worker(){
		
	}
	
	Worker(String name,char sex,int age,String company,double workAge){
		super(name,sex,age);
		this.company = company;
		this.workAge = workAge;
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("����"+ super.getName() +"�ڳ�С��");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("����"+ super.getName() +"�ڹ���˯��");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("����"+ super.getName() +"����������");
	}
	

	@Override
	public String toString() {
		return "Worker [������" + getName()+ ", ���䣺" + getAge() +", �Ա�" + getSex() +
				", ������λ��" + company + ", ���䣺" + workAge + "]";
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getWorkAge() {
		return workAge;
	}
	public void setWorkAge(double workAge) {
		this.workAge = workAge;
	}	
}

abstract class Person{
	private String name;
	private char sex;
	private int age;
	
	
	Person(){
		
	}
	
	Person(String name,char sex,int age){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public abstract void eat();
	public abstract void sleep();
	public abstract void work();
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
} 