package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
	map扩展知识：
		map集合被使用是因为具备映射关系。
		
	eg：
		方式一：学校集合中有班级与学生的映射关系，班级集合中有学号与学生姓名的映射关系
			"yureban" "01" "zhangsan"
			"yureban" "02" "lisi"
			
			"jiuyeban" "01" "wangwu"
			"jiuyeban" "02" "zhaoliu"
			
		方式二：学校集合中有班级与学生的映射关系，班级集合中有封装的学生对象
			"yureban" Student("01" "zhangsan")
			"yureban" Student("02" "lisi")
			
			"jiuyeban" Student("01" "wangwu")
			"jiuyeban" Student("02" "zhaoliu")
 */
public class MapDemo3 {
	public static void main(String[] args) {
		System.out.println("=======方式一：======");
		method_1();
		
		System.out.println("\n=======方式二：======");
		method_2();
	}
	
	//方式二：学校集合中有班级与学生的映射关系，班级集合中有封装的学生对象
	public static void method_2(){
		HashMap<String,List<Student1>> school = new HashMap<String,List<Student1>> ();//创建学校集合
		List<Student1> yure = new ArrayList<Student1>();//创建班级集合
		List<Student1> jiuye = new ArrayList<Student1>();
		
		school.put("yureban", yure);//将班级元素添加到学校集合中（映射关系）
		school.put("jiuye", jiuye);
		
		yure.add(new Student1(01,"zhangsan"));//将学生对象添加到班级集合中（没有映射关系）
		yure.add(new Student1(03,"lisi"));
		yure.add(new Student1(02,"wangwu"));
		
		jiuye.add(new Student1(01,"xiaozhang"));
		jiuye.add(new Student1(02,"xiaowang"));
		jiuye.add(new Student1(03,"xiaoli"));
			
		//遍历school集合，获取所有教室
		Iterator<String> it = school.keySet().iterator();
		while(it.hasNext()){//采用循环嵌套循环的方式
			String roomName = it.next();
			List<Student1> room = school.get(roomName);
			System.out.println("-----" + roomName + "-----" );
			
			//遍历教室集合，获取所有学生对象
			Iterator<Student1> it1 = room.iterator();
			while(it1.hasNext()){
				Student1 student = it1.next();
				System.out.println(student);
			}
		}
	}
	
	//方式一：学校集合中有班级与学生的映射关系，班级集合中有学号与学生姓名的映射关系
	public static void method_1(){
		HashMap<String,HashMap<String,String>> school = new HashMap<String,HashMap<String,String>>();//创建学校集合
		HashMap<String,String> yure = new HashMap<String,String>();//创建班级集合
		HashMap<String,String> jiuye = new HashMap<String,String>();
		
		yure.put("01", "zhangsan");//将班级元素添加的学校集合中（映射关系）
		yure.put("02", "lisi");
		
		jiuye.put("01", "wangwu");//将学生元素添加到班级集合中（映射关系）
		jiuye.put("02", "zhaoliu");
		
		school.put("yureban", yure);
		school.put("jiuyeban", jiuye);
		
		
		//遍历school集合，获取所有班级。
		Iterator<String> it = school.keySet().iterator();
		while(it.hasNext()){
			String roomName = it.next();
			HashMap<String,String> room = school.get(roomName);
			System.out.println("-----" + roomName + "-----" );
			//getStudentInfo(room);
			
			//遍历班级集合，获取学生的id和姓名
			Iterator<String> it1 = room.keySet().iterator();
			while(it1.hasNext()){
				String id = it1.next();
				String name = room.get(id);
				System.out.println(id + ": " + name);
			}
		}
	}
}


//创建学生类
class Student1{
	private String name;
	private int id;
	Student1(){
		
	}
	Student1(int id,String name){//重载构造方法
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {//复写toString方法
		return id + ": " + name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
