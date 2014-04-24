package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
	map��չ֪ʶ��
		map���ϱ�ʹ������Ϊ�߱�ӳ���ϵ��
		
	eg��
		��ʽһ��ѧУ�������а༶��ѧ����ӳ���ϵ���༶��������ѧ����ѧ��������ӳ���ϵ
			"yureban" "01" "zhangsan"
			"yureban" "02" "lisi"
			
			"jiuyeban" "01" "wangwu"
			"jiuyeban" "02" "zhaoliu"
			
		��ʽ����ѧУ�������а༶��ѧ����ӳ���ϵ���༶�������з�װ��ѧ������
			"yureban" Student("01" "zhangsan")
			"yureban" Student("02" "lisi")
			
			"jiuyeban" Student("01" "wangwu")
			"jiuyeban" Student("02" "zhaoliu")
 */
public class MapDemo3 {
	public static void main(String[] args) {
		System.out.println("=======��ʽһ��======");
		method_1();
		
		System.out.println("\n=======��ʽ����======");
		method_2();
	}
	
	//��ʽ����ѧУ�������а༶��ѧ����ӳ���ϵ���༶�������з�װ��ѧ������
	public static void method_2(){
		HashMap<String,List<Student1>> school = new HashMap<String,List<Student1>> ();//����ѧУ����
		List<Student1> yure = new ArrayList<Student1>();//�����༶����
		List<Student1> jiuye = new ArrayList<Student1>();
		
		school.put("yureban", yure);//���༶Ԫ����ӵ�ѧУ�����У�ӳ���ϵ��
		school.put("jiuye", jiuye);
		
		yure.add(new Student1(01,"zhangsan"));//��ѧ��������ӵ��༶�����У�û��ӳ���ϵ��
		yure.add(new Student1(03,"lisi"));
		yure.add(new Student1(02,"wangwu"));
		
		jiuye.add(new Student1(01,"xiaozhang"));
		jiuye.add(new Student1(02,"xiaowang"));
		jiuye.add(new Student1(03,"xiaoli"));
			
		//����school���ϣ���ȡ���н���
		Iterator<String> it = school.keySet().iterator();
		while(it.hasNext()){//����ѭ��Ƕ��ѭ���ķ�ʽ
			String roomName = it.next();
			List<Student1> room = school.get(roomName);
			System.out.println("-----" + roomName + "-----" );
			
			//�������Ҽ��ϣ���ȡ����ѧ������
			Iterator<Student1> it1 = room.iterator();
			while(it1.hasNext()){
				Student1 student = it1.next();
				System.out.println(student);
			}
		}
	}
	
	//��ʽһ��ѧУ�������а༶��ѧ����ӳ���ϵ���༶��������ѧ����ѧ��������ӳ���ϵ
	public static void method_1(){
		HashMap<String,HashMap<String,String>> school = new HashMap<String,HashMap<String,String>>();//����ѧУ����
		HashMap<String,String> yure = new HashMap<String,String>();//�����༶����
		HashMap<String,String> jiuye = new HashMap<String,String>();
		
		yure.put("01", "zhangsan");//���༶Ԫ����ӵ�ѧУ�����У�ӳ���ϵ��
		yure.put("02", "lisi");
		
		jiuye.put("01", "wangwu");//��ѧ��Ԫ����ӵ��༶�����У�ӳ���ϵ��
		jiuye.put("02", "zhaoliu");
		
		school.put("yureban", yure);
		school.put("jiuyeban", jiuye);
		
		
		//����school���ϣ���ȡ���а༶��
		Iterator<String> it = school.keySet().iterator();
		while(it.hasNext()){
			String roomName = it.next();
			HashMap<String,String> room = school.get(roomName);
			System.out.println("-----" + roomName + "-----" );
			//getStudentInfo(room);
			
			//�����༶���ϣ���ȡѧ����id������
			Iterator<String> it1 = room.keySet().iterator();
			while(it1.hasNext()){
				String id = it1.next();
				String name = room.get(id);
				System.out.println(id + ": " + name);
			}
		}
	}
}


//����ѧ����
class Student1{
	private String name;
	private int id;
	Student1(){
		
	}
	Student1(int id,String name){//���ع��췽��
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {//��дtoString����
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
