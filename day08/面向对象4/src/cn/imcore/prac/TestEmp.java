package cn.imcore.prac;

public class TestEmp {

	public static void main(String[] args) {
		Employee emp1 = new Employee("小何", "中级工程师", 3000, 3000);
		Employee emp2 = new Employee("小李", "高级工程师", 6000, 5000);
		Employee emp3 = new Employee("小张", "初级工程师", 3000, 1000);
		
		//打印员工信息
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
	}
}


class Employee {
	//属性 雇员编号 eNo、姓名 eName、职位 eJob、基本工资 eSalary、奖金 eBonus
	private static int n = 1;
	private int eNo; //自增
	private String eName;
	private String eJob;
	private double eSalary;  //基本工资
	private int eBonus;  //奖金
	
	public Employee() {
		
	}
	
	public Employee(String name, String job, double salary, int bonus) {
		this.eNo = n++;
		this.eName = name;
		this.eJob = job;
		this.eSalary = salary;
		this.eBonus = bonus;
		
	}
	
	
	//求月薪(月薪 = 基本工资 + 奖金)
	public double monthPay() {
		return eSalary + eBonus;
	}
	
	//求年薪
	public double yearPay() {
		return this.monthPay()*12;
	}

	@Override
	public String toString() {
		return "Employee [eNo=" + eNo + ", eName=" + eName + ", eJob=" + eJob
				+ ", eSalary=" + eSalary + ", eBonus=" + eBonus
				+ ", month=" + monthPay() + " , year=" + yearPay() 
				+ "]";
	}
	
	
}