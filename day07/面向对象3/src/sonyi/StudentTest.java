package sonyi;
/*
	练习:
		定义一个表示学生的类。属性有：学号，姓名，年龄，计算机成绩，数学成绩，英语成绩。
		要求学号为类变量，每次增加学生时，学号自动增加，并赋值给新增学生。计算学生的平均成绩和总成绩。
		实例化几个对象，并测试。
*/
public class StudentTest {
	public static void main(String[] args) {
		
		//创建学生类，学号自动增加，其他参数由构造方法传入
		Student s1 = new Student("zhangsan",20,95,80,78);
		Student s2 = new Student("lisi",20,95,80,78);
		System.out.println(s1);//打印对象就是打印对象的toString方法。
		System.out.println(s2);
		
		//设置学生学号从10开始
		Student.index = 10;
		Student s3 = new Student("lisi",27,95,80,78);
		System.out.println(s3);	
		Student s4 = new Student("lisi",27,95,80,78);
		System.out.println(s4);	
	}
}

class Student{
	static int index = 1;//定义一个静态变量，用来记录当前新增学生的学号
	//定义私有成员变量
	private String name;
	private int age;
	private int num;
	private double computerScore;
	private double mathScore;
	private double englisdScore;
	
	Student(){	
	}
		
	//重载构造方法，传入实参
	Student(String name,int age,double computerScore,double mathScore,double englisdScore){
		this.name= name;
		this.age = age;
		this.computerScore = computerScore;
		this.mathScore = mathScore;
		this.englisdScore = englisdScore;	
		num = index++;//将当前学号赋给当前创建的学生对象，并且将学号自增1，用来赋给下一个创建的学生对象；
	}
	
	//计算每个学生的平均成绩
	public double averScore(){
		return Math.round((computerScore + mathScore + englisdScore)/3);// 四舍五入
	}
	
	//计算每个学生的总成绩
	public double sumScore(){
		return computerScore + mathScore + englisdScore;
	}
	
	//复写toString()方法，用来输出学生的信息
	@Override
	public String toString() {
		return "Student [学号：" + num + ",姓名：" + name + ",年龄：" + age +
				",计算机成绩：" + computerScore+ ",数学成绩：" + mathScore + ",英语成绩" + englisdScore + 
				"，各科平均成绩：" + averScore() + ",各科总成绩：" + sumScore() + "]";
	}

	//定义各私有成员变量的获取方法和设置方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getComputerScore() {
		return computerScore;
	}
	public void setComputerScore(double computerScore) {
		this.computerScore = computerScore;
	}
	public double getMathScore() {
		return mathScore;
	}
	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}
	public double getEnglisdScore() {
		return englisdScore;
	}
	public void setEnglisdScore(double englisdScore) {
		this.englisdScore = englisdScore;
	}
}
