package sonyi;

/*
 * 
 *练习:
 *	目的：练习this，super的使用，构造方法覆初始值，继承初步
 *	步骤：
 *		1、新建一个Company类
 *			属性：姓名，性别，工资(设置为私有)
 *			方法：printMsg();//打印这个部门的人员所有信息
 *		2、新建一个Dept类继承Company
 *			属性：技能
 *			方法：printMsg();//打印这个部门的人员所有信息
 *		3、新建一个Manage类继承Dept
 *			属性：职位
 *			方法：printMsg();//打印这个部门的人员所有信息
 *		4、新建一个测试类
 *			实例化一个Company对象，实例化一个Dept对象，实例化两个Manage对象，
 *				分别打印各自的全部信息。
 */
public class ExtendsDemo {
	public static void main(String[] args) {

		//创建各类的对象，并初始化值
		Company c1 = new Company("张三",'男',2000);
		Company c2 = new Company("小张",'男');
		Dept d = new Dept("小红",'女',3000,"前端");
		Manage m1 = new Manage("李四",'男',2500,"后端","工程师");
		Manage m2 = new Manage("小王",'女',3500,"数据库","数据库工程师");
		
		//打印各对象的全部信息
		c1.printMsg();
		c2.printMsg();
		d.printMsg();
		m1.printMsg();
		m2.printMsg();
	}

}

//创建Company父类
class Company{
	private String name;//设置私有属性
	private char sex;
	private double salary;
	
	public Company(){//无参构造方法
	}
	
	public Company(String name, char sex, double salary) {//重载构造方法（三个参数）
		this.name = name;//this的使用1：调用本类的属性和方法
		this.sex = sex;
		this.salary = salary;
	}	

	public Company(String name, char sex) {	//两个参数的构造方法（重载）
		this(name,sex,0.0);//this的使用2：调用本类的构造方法
	}


	public String getName() {//设置私有属性的获取方法
		return name;
	}
	
	public void setName(String name) {//设置私有属性的赋值方法
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
		System.out.println("我的姓名是：" + getName() + ",我的性别是：" + getSex() + 
				",我的工资是：" + getSalary());
	}
}

//创建Company的子类
class Dept extends Company{
	
	private String skill;//设置对象特有的私有属性
	
	Dept(){	
	}
	
	//四个参数的构造函数
	Dept(String name,char sex,double salary,String skill){
		super(name,sex,salary);//super的使用1：调用父类的构造函数，减少重复代码
		this.skill = skill;
	}	
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public void printMsg(){//打印该类的所有信息
		super.printMsg();//super的使用2：调用父类的方法，减少重复代码
		System.out.println("\t我的技能是：" + getSkill());
	}
}

//创建Dept的子类
class Manage extends Dept{
	//设置该类特有的私有属性
	private String position;

	Manage(){//无参构造函数	
	}
	
	//五个参数的构造函数
	Manage(String name,char sex,double salary,String skill,String position){
		super(name,sex,salary,skill);//调用父类的构造函数
		this.position = position;
	}
	
	public String getPosition() {//设置私有属性的获取方法
		return position;
	}

	public void setPosition(String position) {//设置私有属性的赋值方法
		this.position = position;
	}
	
	public void printMsg(){//打印该类所有的信息
		super.printMsg();//调用父类的打印方法，减少重复代码
		System.out.println("\t我的职位是：" + getPosition());
	}
	
}
