package cn.imcore.prac;

public class TestEmp {

	public static void main(String[] args) {
		Employee emp1 = new Employee("С��", "�м�����ʦ", 3000, 3000);
		Employee emp2 = new Employee("С��", "�߼�����ʦ", 6000, 5000);
		Employee emp3 = new Employee("С��", "��������ʦ", 3000, 1000);
		
		//��ӡԱ����Ϣ
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
	}
}


class Employee {
	//���� ��Ա��� eNo������ eName��ְλ eJob���������� eSalary������ eBonus
	private static int n = 1;
	private int eNo; //����
	private String eName;
	private String eJob;
	private double eSalary;  //��������
	private int eBonus;  //����
	
	public Employee() {
		
	}
	
	public Employee(String name, String job, double salary, int bonus) {
		this.eNo = n++;
		this.eName = name;
		this.eJob = job;
		this.eSalary = salary;
		this.eBonus = bonus;
		
	}
	
	
	//����н(��н = �������� + ����)
	public double monthPay() {
		return eSalary + eBonus;
	}
	
	//����н
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