package sonyi;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("����");
		Student s2 = new Student("����");
		Student s3 = new Student("����");
		Teacher t = new Teacher();
		s1.ask(t);
		s2.ask(t);
		s3.ask(t);
	}
}

class Student{
	private String name;
	public Student(String name) {
		this.name = name;
	}
	public void ask(Teacher t){
		System.out.println(name + "����ʦ����ʲô��");
		t.answer(this);
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

class Teacher extends Thread{
	private Student student;
	public static Object o = new Object();
	Teacher(Student student){
		this.student = student;
	}
	public Teacher() {
		
	}
	
	public void run(){
		synchronized (o) {
			try {
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
	}
	
	public void answer(Student student){
		System.out.println("��ʦ�ش�:" + student.getName() + "Ҫ��ʼѧϰ��������ͥ��ҵ");
		new Teacher(student).start();
	}
}