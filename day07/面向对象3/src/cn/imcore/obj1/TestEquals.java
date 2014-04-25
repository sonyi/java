package cn.imcore.obj1;
/**
 * ==用法，equals用法
 * @author Administrator
 *
 */
public class TestEquals {
	String name;
	
	public TestEquals(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		int a = 3;
		int b = 3;
		int c = 4;
		
		if(a==b) {
			System.out.println("a==b");
		}
		if(a==c) {
			System.out.println("a==c");
		} else {
			System.out.println("a!=c");
		}
		
		
		//比较地址
		TestEquals t1 = new TestEquals("AAA");
		TestEquals t2 = new TestEquals("AAA");
		System.out.println("t1:" + t1);
		System.out.println("t2:" + t2);
		
		if(t1==t2) {
			System.out.println("t1==t2");
		} else {
			System.out.println("t1!=t2");
		}
		
		
		//比较地址
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//false
		
		//如何比较值？
		if(s1.equals(s3)){
			System.out.println("s1 equals s3");
		} else {
			System.out.println("s1 not equals s3");
		}
		
		
		//如何比较值？
		if(t1.equals(t2)) {
			System.out.println("t1 equals t2");
		} else {
			System.out.println("t1 not equals t2");
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TestEquals other = (TestEquals) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}








