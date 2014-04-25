package sonyi;
/*
 * ��ϰ��
 * 		���󣺴���һ��Person���ࡣ����Student��Worker���࣬�������ԡ�
 * 		˼·��
			1���½�һ��Person�࣬
			  	���ԣ�name ������sex �Ա�age ����	
			  	���������Ե�get/set����
			        ��ӡ���� public void printMsg();	
			2���½�һ��Student�࣬�̳�Person��
			  	���ԣ�ѧ�� no, �ɼ� score
			  	���������Ե�get/set����
			        ��ӡ���� public void printMsg();
			3���½�һ��worker�࣬�̳�Person��
			  	���ԣ����� job, ���� salary
			  	���������Ե�get/set����
			        ��ӡ���� public void printMsg();
			4���������࣬�ֱ����
 */
public class Exercise {
	public static void main(String[] args){
		//�����ʵ����
		Person p = new Person("����",'��',20);
		Student s = new Student("����",'Ů',23,2007,98);
		Worker w = new Worker("����",'��',30,"����",3000);
		
		//��ӡ�������Ϣ
		p.printMsg();
		s.printMsg();
		w.printMsg();
	}
}

//��������
class Person{
	private String name;
	private char sex;
	private int age;
	Person(){	
	}
	Person(String name,char sex,int age){//���ع��췽��
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public void printMsg(){//�����ӡ��Ϣ����
		System.out.println("�ҵ������ǣ�" + name + "���ҵ��Ա��ǣ�" + sex + ",�ҵ������ǣ�" + age);
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
}

//��������
class Student extends Person{
	private int no;
	private double score;
	Student(){	
	}
	//���ع��췽��
	Student(String name,char sex,int age,int no,double score){
		super(name,sex,age);//���ø��๹�췽��
		this.no = no;
		this.score = score;
	}
	public void printMsg(){
		super.printMsg();
		System.out.println("�ҵ�ѧ�ŵģ�" + no + ",�ҵĳɼ��ǣ�" + score);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}

//��������
class Worker extends Person{
	private String job;
	private double salary;
	Worker(){	
	}
	//���ع��췽��
	Worker(String name,char sex,int age,String job,double salary){
		super(name,sex,age);//���ø��๹�췽��
		this.job = job;
		this.salary = salary;
	}
	public void printMsg(){
		super.printMsg();
		System.out.println("�ҵĹ����ǣ�" + job + ",�ҵĹ����ǣ�" + salary);
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
}