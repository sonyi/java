package cn.imcore.test1;

import java.util.Vector;



public class TestVector {

	public static void main(String[] args) {
		Vector<String> v = new Vector();
		v.add("aaa");
		v.add("111");
		v.add("777");
		v.add("ggg");
		v.add("aaa");
		
		//ÔöÇ¿for
		for(String o:v){
			System.out.println(o);
		}
	}
}
