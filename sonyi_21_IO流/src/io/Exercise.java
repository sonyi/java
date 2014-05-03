package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 *	��ϰ��
		�����ѧ����ÿ��ѧ����3�ſεĳɼ����Ӽ���������������(�������������ſγɼ�)
		����ĸ�ʽ����������30,40,60������ܳɼ�������ѧ������Ϣ�ͼ�������ܷ�����
		�ߵ�˳������ڴ����ļ�"stud.txt"�С�
		
		1������ѧ������
		2������һ�����Բ���ѧ������Ĺ����ࡣ
	
	˼·��
		1��ͨ����ȡ��������һ�����ݣ����������е���Ϣȡ����װ��ѧ������
		2����Ϊѧ���кܶ࣬��ô����Ҫ�洢��ʹ�õ����ϡ���ΪҪ��ѧ�����ܷ�����
			���Կ���ʹ��TreeSet
		3�������ϵ���Ϣд�뵽һ���ļ��С�
		
 */
public class Exercise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Comparator<Student> cmp = Collections.reverseOrder();
			Set<Student> sets = StudentInfoTool.getStudents(cmp);
			StudentInfoTool.write2File(sets);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//�������ѧ���Ĺ�����
class StudentInfoTool{
	//Ĭ�ϱȽ�����ѧ������
	public static Set<Student> getStudents() throws IOException{
		return getStudents(null);
	}
	
	//���Ƚ�����ѧ������
	public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//����������
		String line = null;
		Set<Student> stuSet = null;//�������������ڴ��ѧ������
		//�ж��Ƿ���Ƚ���
		if(cmp ==null)
			stuSet = new TreeSet<Student>();
		else
			stuSet = new TreeSet<Student>(cmp);
		//����ѭ������ѧ������
		while((line = buf.readLine()) != null){
			if("over".equals(line))
				break;
			String[] info = line.split(",");
			Student stu = new Student(info[0], Integer.parseInt(info[1]),
					Integer.parseInt(info[2]), Integer.parseInt(info[3]));
			stuSet.add(stu);
		}
		return stuSet;
	}
	
	public static void write2File(Set<Student> stuSet) throws IOException{
		BufferedWriter buf = new BufferedWriter(new FileWriter("studentfo.txt"));//��ѧ����Ϣд�뵽�ļ���
		//ѭ��д��ѧ����Ϣ
		for(Student s : stuSet){
			buf.write(s.toString() + '\t');
			buf.write(s.getSum() + "");
			buf.newLine();
			buf.flush();
		}
		buf.close();
	}
}

class Student implements Comparable<Student>{
	private String name;//����˽������
	private double math,chinese,english;
	private double sum;
	
	//���ع��췽��
	public Student(String name,double math,double chinese,double english) {
		this.name = name;
		this.setMath(math);
		this.setChinese(chinese);
		this.setEnglish(english);
		sum = math + chinese + english;
	}
	
	//����Ĭ�ϱȽ���
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		int num = new Double(sum).compareTo(new Double(o.sum));
		if(num == 0)
			return this.name.compareTo(o.name);
		return num;
	}
	
	@Override//��дtoString
	public String toString() {
		return "Student [name=" + name + ", math=" + math + ", chinese="
				+ chinese + ", english=" + english + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(chinese);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(english);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(math);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(chinese) != Double
				.doubleToLongBits(other.chinese))
			return false;
		if (Double.doubleToLongBits(english) != Double
				.doubleToLongBits(other.english))
			return false;
		if (Double.doubleToLongBits(math) != Double
				.doubleToLongBits(other.math))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getChinese() {
		return chinese;
	}
	public void setChinese(double chinese) {
		this.chinese = chinese;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}
	public double getSum(){
		return sum;
	}
}
