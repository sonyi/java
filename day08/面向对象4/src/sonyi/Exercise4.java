package sonyi;
/*
	练习：
		定义一个人类，包括属性：姓名 name、性别 sex、年龄 age；包括方法：吃饭 eat() 、睡觉 sleep() ，工作 work() 。
			（1）根据人类，派生一个学生类，增加属性：学校 school、学号 no；重写工作方法（学生的工作是学习）。
			（2）根据人类，派生一个工人类，增加属性：单位 company、工龄 workAge；重写工作方法（工人的工作是……自己想吧）。
			（3）根据学生类，派生一个学生干部类，增加属性：职务 job；增加方法：开会 meeting()。
			（4）编写主函数分别对上述3类具体人物进行测试。
 */
public class Exercise4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//向上转型，对对象进行封装
		Person p1 = new Worker("张三",'男',26,"建筑公司",2.5);
		System.out.println(p1);
		p1.eat();
		p1.sleep();
		p1.work();
		
		Person p2 = new Student("小李",'女',20,"技术学校",007);
		System.out.println(p2);
		p2.eat();
		p2.sleep();
		p2.work();
		
		Person p3 = new StudentCadre("小王",'男',27,"计算机学校",007,"学生会老大");
		System.out.println(p3);
		p3.eat();
		p3.sleep();
		p3.work();
		StudentCadre sc = (StudentCadre)p3;//向下转型，调用对象特有方法。
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
		System.out.println("学生干部："+ super.getName() +"在开会");
	}
	
	
	@Override
	public String toString() {
		return "StudentCadre [姓名："+ getName() + ",年龄：" + getAge() + ", 性别："+ getSex() +
				", 学校：" + getSchool() + ",学号：" + getNo() + ", 干部职务:" + job + "]";
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
		System.out.println("学生"+ super.getName() +"在食堂吃饭");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("学生"+ super.getName() +"在集体宿舍睡觉");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("学生"+ super.getName() +"好好学习");
	}
	
	
	@Override
	public String toString() {
		return "Student [姓名："+ getName() + ",年龄：" + getAge() + ", 性别："+ getSex() +
				", 学校：" + school + ",学号：" + no + "]";
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
		System.out.println("工人"+ super.getName() +"在吃小炒");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("工人"+ super.getName() +"在工棚睡觉");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("工人"+ super.getName() +"做工很辛苦");
	}
	

	@Override
	public String toString() {
		return "Worker [姓名：" + getName()+ ", 年龄：" + getAge() +", 性别：" + getSex() +
				", 工作单位：" + company + ", 工龄：" + workAge + "]";
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