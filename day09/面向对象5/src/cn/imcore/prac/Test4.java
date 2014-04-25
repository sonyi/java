package cn.imcore.prac;

public class Test4 {

	public static void main(String[] args) {
		Student stu = new Student("����", '��', 22, "���Ŵ�ѧ", 20130001);
		StudentManage stum = new StudentManage("����", '��', 22, "���Ŵ�ѧ", 20130002, "�೤");
		
		Worker worker = new Worker("����", '��', 30, "����", 1);
		
		//��ӡ��Ϣ
		System.out.println(stu);
		System.out.println(stum);
		System.out.println(worker);
		
		//�����ķ���
		stu.work();
		stum.work(); stum.meeting();
		worker.work();
		
	}
}


class Person {
	//����
	private String name; //����
	private char sex;//�Ա�
	private int age; //����
	
	public Person() {
		
	}
	
	public Person(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	//����
	public void eat() {
		
	}
	
	public void sleep() {
		
	}
	
	public void work() {
		
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

	@Override
	public String toString() {
		return "������" + name + ", �Ա�" + sex + ", ���䣺" + age;
	}
	
	
}

class Student extends Person {
	//��������
	private String school; //ѧУ
	private int sno; //ѧ��
	
	public Student(String name, char sex, int age, String school, int sno) {
		super(name, sex, age);
		this.school = school;
		this.sno = sno;
	}
	
	
	public void work() {
		System.out.println("ѧ���Ĺ�����ѧϰ");
	}
	
	
	
	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	@Override
	public String toString() {
		return "������" + super.getName() + ", �Ա�" + super.getSex()
				+ ", ���䣺" + super.getAge() + ", ѧУ��" + school + ", ѧ�ţ�" + sno;
	}
	
	
	
}


class Worker extends Person {
	private String company;
	private int workAge;
	
	public Worker(String name, char sex, int age, String c, int n) {
		super(name, sex, age);
		this.company = c;
		this.workAge = n;
	}

	@Override
	public void work() {
		System.out.println("���˵Ĺ�����׬Ǯ���ҡ�");
	}
	
	
	@Override
	public String toString() {
		return "������" + super.getName() + ", �Ա�" + super.getSex()
				+ ", ���䣺" + super.getAge()
				+ ", ��λ��" + company + ", ���䣺" + workAge;
	}
}


class StudentManage extends Student {
	private String job; //ְλ
	
	public StudentManage(String name, char sex, int age, String school,
			int sno, String job) {
		super(name, sex, age, school, sno);
		this.job = job;
	}
	
	//�����ķ���
	public void meeting() {
		System.out.println("ѧ���ɲ��ڿ���");
	}

	
	@Override
	public String toString() {
		return "������" + super.getName() + ", �Ա�" + super.getSex()
				+ ", ���䣺" + super.getAge()
				+ ", ѧУ��" + super.getSchool() + ", ѧ�ţ�" + super.getSno()
				+ ", ְλ��" + job;
	}
	
}
