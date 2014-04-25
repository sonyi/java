package sonyi;

public class Test {
	public static void main(String[] args) {
		String string = "abdDIUNS15Djdi34xskhDSCG";
		char ch;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < string.length(); i++){
			ch = string.charAt(i);
			if(ch >= 'a' && ch <= 'z')
				ch -= 32;
			else if(ch >= 'A' && ch <= 'Z')
				ch += 32;
			stringBuilder.append(ch);		
		}
		System.out.println(stringBuilder.toString());

	}

}
