package sonyi;
/*
 * 练习：
 * 		需求：创建一个Person父类。创建Student和Worker子类，并做测试。
 * 		思路：
			1、新建一个Person类，
			  	属性：name 姓名，sex 性别，age 年龄	
			  	方法：各自的get/set方法
			        打印方法 public void printMsg();	
			2、新建一个Student类，继承Person类
			  	属性：学号 no, 成绩 score
			  	方法：各自的get/set方法
			        打印方法 public void printMsg();
			3、新建一个worker类，继承Person类
			  	属性：工种 job, 工资 salary
			  	方法：各自的get/set方法
			        打印方法 public void printMsg();
			4、建测试类，分别测试
 */
public class Exercise {
	public static void main(String[] args){
		//对象的实例化
		Person p = new Person("张三",'男',20);
		Student s = new Student("李四",'女',23,2007,98);
		Worker w = new Worker("王五",'男',30,"工匠",3000);
		
		//打印对象的信息
		p.printMsg();
		s.printMsg();
		w.printMsg();
	}
}

//创建父类
class Person{
	private String name;
	private char sex;
	private int age;
	Person(){	
	}
	Person(String name,char sex,int age){//重载构造方法
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public void printMsg(){//定义打印信息方法
		System.out.println("我的名字是：" + name + "，我的性别是：" + sex + ",我的年龄是：" + age);
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

//创建子类
class Student extends Person{
	private int no;
	private double score;
	Student(){	
	}
	//重载构造方法
	Student(String name,char sex,int age,int no,double score){
		super(name,sex,age);//调用父类构造方法
		this.no = no;
		this.score = score;
	}
	public void printMsg(){
		super.printMsg();
		System.out.println("我的学号的：" + no + ",我的成绩是：" + score);
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

//创建子类
class Worker extends Person{
	private String job;
	private double salary;
	Worker(){	
	}
	//重载构造方法
	Worker(String name,char sex,int age,String job,double salary){
		super(name,sex,age);//调用父类构造方法
		this.job = job;
		this.salary = salary;
	}
	public void printMsg(){
		super.printMsg();
		System.out.println("我的工作是：" + job + ",我的工资是：" + salary);
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