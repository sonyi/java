package sonyi;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("张三");
		Student s2 = new Student("李四");
		Student s3 = new Student("王五");
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
		System.out.println("学生" + name + "问老师该做什么？");
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
		System.out.println("老师回答:" + student.getName() + "要开始学习，并做家庭作业");
	}
	
}