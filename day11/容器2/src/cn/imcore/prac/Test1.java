package cn.imcore.prac;

import java.util.Arrays;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcdaaabcddddfsfdsfddfgghjgkhjssssssssss";
		new Test1().printMaxChar(s);
	}

	public void printMaxChar(String ss) {
		char[] data = ss.toCharArray();
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		
		char ch = data[0];//
		int count = 1;
		int maxCount = 0;
		
		for(int i=0; i<data.length-1; i++) {
			if(data[i]==data[i+1]) {
				count++;
			} else {
				if(count>maxCount) {
					maxCount = count;
					ch = data[i];
				}
				count = 1;
			}
		}
		
		if(count>maxCount) {
			maxCount = count;
			ch = data[data.length-1];
		}
		
		System.out.println(ch + ":" + maxCount);
		
	}
}
