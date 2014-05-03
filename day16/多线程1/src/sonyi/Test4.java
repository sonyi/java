package sonyi;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("张三");
		Student s2 = new Student("李四");
		Student s3 = new Student("王五");
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
		System.out.println(name + "问老师该做什么？");
		t.answer(this);
	}
	
	public void study(){
		System.out.println("学生" + name + "开始学习了");
	}
	
	public void doHomework(){
		System.out.println("学生" + name + "开始做家庭作业");
	}
	
	public void goToSleep(){
		System.out.println(name + "作业做好了，睡觉去。。。。");
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
		System.out.println("老师回答:" + student.getName() + "要开始学习，并做家庭作业");
		new Teacher(student).start();
	}
}