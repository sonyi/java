package sonyi;
/*
	��ϰ:
		����һ����ʾ��Ա���ࡣ�����У���Ա��ţ�������ְλ����н������
		Ҫ���Ա���Ϊ�������ÿ�����ӳ�Աʱ������Զ����ӣ�����ֵ��������Ա�������Ա����н����н����ӡ��Աȫ����Ϣ��
		ʵ�����������󣬲����ԡ�
 */
public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ʵ������������ʼֵ
		Employee e1 = new Employee("����","ǰ̨",2000,500);
		Employee e2 = new Employee("С��","����ʦ",2000,500);
		Employee e3 = new Employee("С��","�ۺ�",2000,500);
		Employee e4 = new Employee("����","ǰ̨",2000,500);
		Employee e5 = new Employee("����","����Ա",8000,1000);
		
		//��ӡ����Ϣ
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e5);	
	}
}

class Employee{
	//��̬���ԣ���¼������Ա��ţ�����ֵ��������Ա����ֵ���Լ�1
	private static int index = 1;
	private int no;//����˽������
	private String name;
	private String position;
	private double salary;
	private double premium;
	
	Employee(){
		
	}
	
	//���ع��췽��
	Employee(String name, String position,double salary,double premium){
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.premium = premium;
		no = index++;
	}	
	
	
	//��дtoString����ӡ��Ա��Ϣ
	@Override
	public String toString() {
		return "Employee [��Ա��ţ�" + no + ", ������" + name + ", ְλ��"
				+ position + ", �������ʣ�" + salary + ", ����" + premium
				+ ", ��н" + monthPay() + ", ��н��" + annualPay() + "]";
	}
	
	//����˽�����ԵĻ�ȡ���������÷���
	public double monthPay(){
		return salary + premium;
	}	
	public double annualPay(){
		return monthPay()*12;
	}
	
	//����˽�����ԵĻ�ȡ���������÷���
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