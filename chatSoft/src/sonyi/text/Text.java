package sonyi.text;

public class Text {
	public static void main(String[] args) {
		String s = "abcd";
		int i = 1;
		int len = 10000;
		String mes = (i + "") + (len + "") + s;
		//System.out.println(i + ":" + i.length());
		System.out.println(len + ":" + len);
		System.out.println(s + ":" + s.length());
		
		System.out.println(mes + ":" + mes.length());
		char[] c = mes.toCharArray();
		for(int j = 0; j < c.length; j++){
			System.out.println(c[j]);
		}
		
		
	}

}
