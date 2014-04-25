package sonyi;


public class Test2 {

	public static void main(String[] args) {
		String string = "21ab123UNS15Djd22skh45";
		char ch;
		for(int i = 0; i < string.length(); i++){
			ch = string.charAt(i);
			if(!(ch >= '0' && ch <= '9')){
				string = string.replace(ch, 'a');
			}
		}
		String[] s = string.split("a");
		int sum = 0;
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
			if(!s[i].isEmpty()){
				sum += Integer.parseInt(s[i]);
			}
		}
		System.out.println(sum);
	}

}
