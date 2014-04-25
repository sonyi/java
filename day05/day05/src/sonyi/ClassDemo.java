package sonyi;


/*
 * 教学内容：
 * 		1、类的属性和方法。类属性的赋值方式。
 * 		2、类的封装性。
 * 		3、构造函数的使用。
 * 		4、this的使用。
 */
public class ClassDemo {
	public static void main(String[] args) {
		System.out.println("\n----------类的创建、属性赋值和方法的调用------------");
		Person01Test();
		System.out.println("\n-------------------类的封装性----------------------");		
		Person02Test();
		System.out.println("\n---------------构造函数和this的使用----------------");		
		Person03Test();
	}
	
	
	//1、类的创建、属性赋值和方法的调用
	public static void Person01Test(){
		Person01 p1;//声明
		p1 = new Person01();//创建对象（对象实例化）
		p1.name = "张三";//给属性赋值
		p1.age = 20;
		System.out.println("姓名：" + p1.name +",年龄：" +  p1.age);
		
		Person01 p2 = new Person01();//声明的同时直接创建对象
		p2.name = "李四";
		p2.age = 21;
		System.out.println("姓名：" + p2.name +",年龄：" +  p2.age);	
		p2.eating();//调用对象的方法。		
	}
	
	//2、类的封装性
	public static void Person02Test(){
		//通过方法访问类的属性
		Person02 p1 = new Person02();
		p1.setName("张三");
		p1.setAge(20);
		System.out.println("姓名：" + p1.getName() +",年龄：" +  p1.getAge());
		
		//对属性的输入值进行判断（判断年龄值），如果不符合条件，打印异常，不给属性赋值
		Person02 p2 = new Person02();
		p2.setName("李四");
		p2.setAge(-20);
		System.out.println("姓名：" + p2.getName() +",年龄：" +  p2.getAge());
	}
	
	//3、构造函数和this的使用
	public static void Person03Test(){
		
		//无参的构造函数
		Person03 p1 = new Person03();
		System.out.println("姓名：" + p1.getName() +",年龄：" +  p1.getAge() + ",性别：" + p1.getSex());
		
		//一个参数的构造函数，对对象赋初始值
		Person03 p2 = new Person03("张三");
		System.out.println("姓名：" + p2.getName() +",年龄：" +  p2.getAge() + ",性别：" + p2.getSex());
		
		//三个参数的构造函数，对对象赋初始值
		Person03 p3 = new Person03("李四",20,'女');
		System.out.println("姓名：" + p3.getName() +",年龄：" +  p3.getAge() + ",性别：" + p3.getSex());
		
		//三个参数的构造函数，初始值（性别和年龄）不符合要求的会跳出提示
		Person03 p4 = new Person03("王五",30,'好');
		System.out.println("姓名：" + p4.getName() +",年龄：" +  p4.getAge() + ",性别：" + p4.getSex());	
		
		p4.setSex('男');//调用对象暴露的方法对错误的属性进行修改
		System.out.println("姓名：" + p4.getName() +",年龄：" +  p4.getAge() + ",性别：" + p4.getSex());	
	}
}

//1、类的创建
class Person01 {	
	//属性
	String name;
	int age;
	char sex;

	//行为-方法
	public void eating() {
		System.out.println(name + "正在吃饭。。。。。。。。。");
	}
}

//2、类的封装性
class Person02 {	
	//属性设置为私有，只能在类内部使用(封装)
    private String name;
    private int age = 1;
	
	//对外暴露设置属性和获取属性的方法。并可以对赋值进行判断
	public String getName(){//获取name
		return name;
	}
	
	public void setName(String name) {//设置name
		this.name = name;
	}
	
	public int getAge() {//获取age
		return age;
	}
	
	public void setAge(int age) {//设置age
		if(age<=0 || age>120) {//年龄的过滤
			System.out.println("年龄不合法");
			return;
		}
		this.age = age;	
	}
	
	public void eating(String name) {
		System.out.println(name + "正在吃饭。。。。。。。。。。。");
	}
}

//3、构造函数和this的使用
	/*
		1、this代表当前对象。
		2、不能放在静态方法里面。
		3、当局部变量和成员变量（全局变量）重名时，如果想访问成员变量时，用this.成员变量。
		4、this调用构造方法时，需要放在构造方法内的第一行。
	*/
class Person03 {
	//属性(封装)
	private String name;
	private int age = 1;
	private char sex;
	
	//无参构造函数
	public Person03() {
		this("zhangsan");
	}
	
	//一个参数的构造函数
	public Person03(String name) {
		this(name, 1, '男');//调用三个参数的构造函数
	}
	
	//三个参数的构造函数
	public Person03(String name, int age, char sex) {
		this.name = name;//this代表调用该方法的当前对象
		setAge(age);
		setSex(sex);//调用方法，判断输入信息是否符合条件
	}
	
	//行为-方法
	public String getName(){//获取name
		return name;
	}
	
	public void setName(String name) {//设置name
		this.name = name;
	}
	
	public int getAge() {//获取age
		return age;
	}
	
	public void setAge(int age) {//设置age
		if(age<=0 || age>120) {//年龄的过滤
		System.out.println(this.name + "的年龄输入不合法");
			return;
		}
		this.age = age;	
	}
	
	public void setSex(char sex){//设置sex
		if(sex == '男' || sex == '女')
			this.sex = sex;	
		else
			System.out.println(this.name  + "的性别输入有误，请重新输入");
	}
	
	public char getSex(){//获取sex
		return sex;
	}
	
	public void eating(String name) {
		System.out.println(name + "正在吃饭。。。。。。。。。。。");
	}
}
