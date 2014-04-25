package cn.imcore.prac;

public class TestStu {

	public static void main(String[] args) {
		//实例化3个学生
		Student stu1 = new Student("国荣", 26, 30, 80, 90);
		Student stu2 = new Student("左宁", 25, 80, 70, 90);
		Student stu3 = new Student("卢敏", 25, 70, 80, 80);
		
		//打印学生信息
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
	}
}


class Student {
	//属性
	private static int no = 1;
	private int sNo;//学号
	private String sName;//姓名
	private int sAge;//年龄
	private double sComputer;  //计算机
	private double sMath; //数学
	private double sEnglish; //英语
	
	public Student(String sName, int sAge, double sComputer, double sMath, double sEnglish) {
		sNo=no++;
		this.sName = sName;
		this.sAge = sAge;
		this.sComputer = sComputer;
		this.sMath = sMath;
		this.sEnglish = sEnglish;
		
	}
	
	public Student() {
		
	}
	//方法
	public double reqSum(){//求总成绩
		return sComputer+sMath+sEnglish;
	}
	
	public double reqAvg(){//求平均成绩
		double avg = (sComputer+sMath+sEnglish)/3;
		return Math.round(avg);//Math.round() 四舍五入
	}

	@Override
	public String toString() {
		return sNo + ", " + sName + ", " + sAge + ", "
				+ sComputer + ", " + sMath + ", " + sEnglish
				+ ", 总成绩=" + this.reqSum() + ", 平均成绩=" + this.reqAvg()
				;
	}
	
	
	
}