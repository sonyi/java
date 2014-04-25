package cn.imcore.prac;

public class TestStu {

	public static void main(String[] args) {
		//ʵ����3��ѧ��
		Student stu1 = new Student("����", 26, 30, 80, 90);
		Student stu2 = new Student("����", 25, 80, 70, 90);
		Student stu3 = new Student("¬��", 25, 70, 80, 80);
		
		//��ӡѧ����Ϣ
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
	}
}


class Student {
	//����
	private static int no = 1;
	private int sNo;//ѧ��
	private String sName;//����
	private int sAge;//����
	private double sComputer;  //�����
	private double sMath; //��ѧ
	private double sEnglish; //Ӣ��
	
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
	//����
	public double reqSum(){//���ܳɼ�
		return sComputer+sMath+sEnglish;
	}
	
	public double reqAvg(){//��ƽ���ɼ�
		double avg = (sComputer+sMath+sEnglish)/3;
		return Math.round(avg);//Math.round() ��������
	}

	@Override
	public String toString() {
		return sNo + ", " + sName + ", " + sAge + ", "
				+ sComputer + ", " + sMath + ", " + sEnglish
				+ ", �ܳɼ�=" + this.reqSum() + ", ƽ���ɼ�=" + this.reqAvg()
				;
	}
	
	
	
}