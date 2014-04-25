package cn.imcore.prac;

public class Test4 {

	public static void main(String[] args) {
		Student stu = new Student("张三", '男', 22, "厦门大学", 20130001);
		StudentManage stum = new StudentManage("李四", '男', 22, "厦门大学", 20130002, "班长");
		
		Worker worker = new Worker("王五", '男', 30, "果核", 1);
		
		//打印信息
		System.out.println(stu);
		System.out.println(stum);
		System.out.println(worker);
		
		//工作的方法
		stu.work();
		stum.work(); stum.meeting();
		worker.work();
		
	}
}


class Person {
	//属性
	private String name; //姓名
	private char sex;//性别
	private int age; //年龄
	
	public Person() {
		
	}
	
	public Person(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	//方法
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
		return "姓名：" + name + ", 性别：" + sex + ", 年龄：" + age;
	}
	
	
}

class Student extends Person {
	//增加属性
	private String school; //学校
	private int sno; //学号
	
	public Student(String name, char sex, int age, String school, int sno) {
		super(name, sex, age);
		this.school = school;
		this.sno = sno;
	}
	
	
	public void work() {
		System.out.println("学生的工作是学习");
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
		return "姓名：" + super.getName() + ", 性别：" + super.getSex()
				+ ", 年龄：" + super.getAge() + ", 学校：" + school + ", 学号：" + sno;
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
		System.out.println("工人的工作是赚钱养家。");
	}
	
	
	@Override
	public String toString() {
		return "姓名：" + super.getName() + ", 性别：" + super.getSex()
				+ ", 年龄：" + super.getAge()
				+ ", 单位：" + company + ", 工龄：" + workAge;
	}
}


class StudentManage extends Student {
	private String job; //职位
	
	public StudentManage(String name, char sex, int age, String school,
			int sno, String job) {
		super(name, sex, age, school, sno);
		this.job = job;
	}
	
	//新增的方法
	public void meeting() {
		System.out.println("学生干部在开会");
	}

	
	@Override
	public String toString() {
		return "姓名：" + super.getName() + ", 性别：" + super.getSex()
				+ ", 年龄：" + super.getAge()
				+ ", 学校：" + super.getSchool() + ", 学号：" + super.getSno()
				+ ", 职位：" + job;
	}
	
}
