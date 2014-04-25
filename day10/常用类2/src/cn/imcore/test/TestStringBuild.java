package cn.imcore.test;

public class TestStringBuild {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.insert(0, "123456789");
		sb.reverse();		
	}
}
