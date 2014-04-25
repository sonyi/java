package sonyi;
/*
	练习:
		定义一个表示雇员的类。属性有：雇员编号，姓名，职位，月薪，奖金。
		要求雇员编号为类变量，每次增加成员时，编号自动增加，并赋值给新增成员。计算雇员的月薪和年薪，打印雇员全部信息。
		实例化几个对象，并测试。
 */
public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//类的实例化，并赋初始值
		Employee e1 = new Employee("张三","前台",2000,500);
		Employee e2 = new Employee("小张","工程师",2000,500);
		Employee e3 = new Employee("小李","售后",2000,500);
		Employee e4 = new Employee("李四","前台",2000,500);
		Employee e5 = new Employee("王五","程序员",8000,1000);
		
		//打印类信息
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e5);	
	}
}

class Employee{
	//静态属性，记录新增成员编号，并赋值给新增成员，赋值后自加1
	private static int index = 1;
	private int no;//定义私有属性
	private String name;
	private String position;
	private double salary;
	private double premium;
	
	Employee(){
		
	}
	
	//重载构造方法
	Employee(String name, String position,double salary,double premium){
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.premium = premium;
		no = index++;
	}	
	
	
	//复写toString，打印成员信息
	@Override
	public String toString() {
		return "Employee [雇员编号：" + no + ", 姓名：" + name + ", 职位："
				+ position + ", 基本工资：" + salary + ", 奖金" + premium
				+ ", 月薪" + monthPay() + ", 年薪：" + annualPay() + "]";
	}
	
	//定义私有属性的获取方法和设置方法
	public double monthPay(){
		return salary + premium;
	}	
	public double annualPay(){
		return monthPay()*12;
	}
	
	//定义私有属性的获取方法和设置方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}	
}