package cn.imcore.test;

public class Person extends Object{
	private String name;
	private int age;
	
	Person() {
		
	}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("Person eat");
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	public static void main(String[] args) {
		Person p1 = new Person("李宁", 20);
		Person p2 = new Person("李宁", 20);
		System.out.println(p1);
		if(p1 == p2) {//比较地址
			System.out.println("p1==p2");
		} else {
			System.out.println("p1!=p2");
		}
		
		int a = 3, b = 3;
		if(a==b) {//比较值
			System.out.println("a==b");
		} else {
			System.out.println("a!=b");
		}
		
		
		if(p1.equals(p2)) {//
			System.out.println("p1 equals p2");
		} else {
			System.out.println("p1 not equals p2");
		}
		
		String s1 = "abc";
		String s2 = new String("abc");
		
		if(s1==s2) {
			System.out.println("s1==s2");
		} else {
			System.out.println("s1!=s2");
		}
		
		if(s1.equals(s2)) {//String 重写父类Object的equals()方法，结果是相等
			System.out.println("s1 equals s2");
		} else {
			System.out.println("s1 not equals s2");
		}
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
