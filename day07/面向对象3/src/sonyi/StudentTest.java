package sonyi;
/*
	��ϰ:
		����һ����ʾѧ�����ࡣ�����У�ѧ�ţ����������䣬������ɼ�����ѧ�ɼ���Ӣ��ɼ���
		Ҫ��ѧ��Ϊ�������ÿ������ѧ��ʱ��ѧ���Զ����ӣ�����ֵ������ѧ��������ѧ����ƽ���ɼ����ܳɼ���
		ʵ�����������󣬲����ԡ�
*/
public class StudentTest {
	public static void main(String[] args) {
		
		//����ѧ���࣬ѧ���Զ����ӣ����������ɹ��췽������
		Student s1 = new Student("zhangsan",20,95,80,78);
		Student s2 = new Student("lisi",20,95,80,78);
		System.out.println(s1);//��ӡ������Ǵ�ӡ�����toString������
		System.out.println(s2);
		
		//����ѧ��ѧ�Ŵ�10��ʼ
		Student.index = 10;
		Student s3 = new Student("lisi",27,95,80,78);
		System.out.println(s3);	
		Student s4 = new Student("lisi",27,95,80,78);
		System.out.println(s4);	
	}
}

class Student{
	static int index = 1;//����һ����̬������������¼��ǰ����ѧ����ѧ��
	//����˽�г�Ա����
	private String name;
	private int age;
	private int num;
	private double computerScore;
	private double mathScore;
	private double englisdScore;
	
	Student(){	
	}
		
	//���ع��췽��������ʵ��
	Student(String name,int age,double computerScore,double mathScore,double englisdScore){
		this.name= name;
		this.age = age;
		this.computerScore = computerScore;
		this.mathScore = mathScore;
		this.englisdScore = englisdScore;	
		num = index++;//����ǰѧ�Ÿ�����ǰ������ѧ�����󣬲��ҽ�ѧ������1������������һ��������ѧ������
	}
	
	//����ÿ��ѧ����ƽ���ɼ�
	public double averScore(){
		return Math.round((computerScore + mathScore + englisdScore)/3);// ��������
	}
	
	//����ÿ��ѧ�����ܳɼ�
	public double sumScore(){
		return computerScore + mathScore + englisdScore;
	}
	
	//��дtoString()�������������ѧ������Ϣ
	@Override
	public String toString() {
		return "Student [ѧ�ţ�" + num + ",������" + name + ",���䣺" + age +
				",������ɼ���" + computerScore+ ",��ѧ�ɼ���" + mathScore + ",Ӣ��ɼ�" + englisdScore + 
				"������ƽ���ɼ���" + averScore() + ",�����ܳɼ���" + sumScore() + "]";
	}

	//�����˽�г�Ա�����Ļ�ȡ���������÷���
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
