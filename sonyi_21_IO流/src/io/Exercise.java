package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 *	练习：
		有五个学生，每个学生有3门课的成绩，从键盘输入以上数据(包括姓名、三门课成绩)
		输入的格式：如张三，30,40,60计算出总成绩，并把学生的信息和计算出的总分数按
		高低顺序存在在磁盘文件"stud.txt"中。
		
		1、描述学生对象。
		2、定义一个可以操作学生对象的工具类。
	
	思路：
		1、通过获取键盘输入一行数据，并将该行中的信息取出封装成学生对象。
		2、因为学生有很多，那么就需要存储，使用到集合。因为要对学生的总分排序
			所以可以使用TreeSet
		3、将集合的信息写入到一个文件中。
		
 */
public class Exercise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Comparator<Student> cmp = Collections.reverseOrder();
			Set<Student> sets = StudentInfoTool.getStudents(cmp);
			StudentInfoTool.write2File(sets);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//定义操作学生的工具类
class StudentInfoTool{
	//默认比较器的学生集合
	public static Set<Student> getStudents() throws IOException{
		return getStudents(null);
	}
	
	//带比较器的学生集合
	public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//键盘输入流
		String line = null;
		Set<Student> stuSet = null;//声明容器，用于存放学生对象
		//判断是否带比较器
		if(cmp ==null)
			stuSet = new TreeSet<Student>();
		else
			stuSet = new TreeSet<Student>(cmp);
		//键盘循环输入学生数据
		while((line = buf.readLine()) != null){
			if("over".equals(line))
				break;
			String[] info = line.split(",");
			Student stu = new Student(info[0], Integer.parseInt(info[1]),
					Integer.parseInt(info[2]), Integer.parseInt(info[3]));
			stuSet.add(stu);
		}
		return stuSet;
	}
	
	public static void write2File(Set<Student> stuSet) throws IOException{
		BufferedWriter buf = new BufferedWriter(new FileWriter("studentfo.txt"));//将学生信息写入到文件中
		//循环写入学生信息
		for(Student s : stuSet){
			buf.write(s.toString() + '\t');
			buf.write(s.getSum() + "");
			buf.newLine();
			buf.flush();
		}
		buf.close();
	}
}

class Student implements Comparable<Student>{
	private String name;//声明私有属性
	private double math,chinese,english;
	private double sum;
	
	//重载构造方法
	public Student(String name,double math,double chinese,double english) {
		this.name = name;
		this.setMath(math);
		this.setChinese(chinese);
		this.setEnglish(english);
		sum = math + chinese + english;
	}
	
	//定义默认比较器
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		int num = new Double(sum).compareTo(new Double(o.sum));
		if(num == 0)
			return this.name.compareTo(o.name);
		return num;
	}
	
	@Override//复写toString
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", chinese="
				+ chinese + ", english=" + english + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(chinese);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(english);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(math);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(chinese) != Double
				.doubleToLongBits(other.chinese))
			return false;
		if (Double.doubleToLongBits(english) != Double
				.doubleToLongBits(other.english))
			return false;
		if (Double.doubleToLongBits(math) != Double
				.doubleToLongBits(other.math))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getChinese() {
		return chinese;
	}
	public void setChinese(double chinese) {
		this.chinese = chinese;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	public double getSum(){
		return sum;
	}
}
