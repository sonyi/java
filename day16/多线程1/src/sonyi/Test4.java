package sonyi;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("����");
		Student s2 = new Student("����");
		Student s3 = new Student("����");
		new teacher(s1).start();
		new teacher(s2).start();
		new teacher(s3).start();
		
	}
}

class Student{
	private String name;
	public Student(String name) {
		this.name = name;
	}
	public void ask(){
		System.out.println("ѧ��" + name + "����ʦ����ʲô��");
	}
	
	public void study(){
		System.out.println("ѧ��" + name + "��ʼѧϰ��");
	}
	
	public void doHomework(){
		System.out.println("ѧ��" + name + "��ʼ����ͥ��ҵ");
	}
	
	public void goToSleep(){
		System.out.println(name + "��ҵ�����ˣ�˯��ȥ��������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class teacher extends Thread{
	private Student student;
	teacher(Student student){
		this.student = student;
	}
	
	public void run(){
		
		try {
			student.ask();
			//Thread.sleep(1000);
			answer();
			//Thread.sleep(1000);
			student.study();
			Thread.sleep(1000);
			student.doHomework();
			//Thread.sleep(1000);
			student.goToSleep();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void answer(){
		System.out.println("��ʦ�ش�:" + student.getName() + "Ҫ��ʼѧϰ��������ͥ��ҵ");
	}
	
}