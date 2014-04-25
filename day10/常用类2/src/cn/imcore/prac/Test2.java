package cn.imcore.prac;

public class Test2 {

	public static void main(String[] args) {
		String[][] ss = new String[3][];
		String[] s1 = {"1","2"};
		String[] s2 = {"3","4","5"};
		String[] s3 = {"6","7","8"};
		
		ss[0] = s1;
		ss[1] = s2;
		ss[2] = s3;
		
		for(int row = 0; row < ss.length; row++) {
			for(int col = 0; col < ss[row].length ; col++) {
				System.out.print(ss[row][col] + " ");
			}
			System.out.println();
		}
		
		//=====================
		String s = "1,2;3,4,5;6,7,8";
		String[] rows = s.split(";");//{"1,2","3,4,5","6,7,8"}
//		String[] cols = rows[0].split(",");//"1,2" -> {"1","2"}
		//rows.length  --行数
		for(int i = 0; i < rows.length; i++) {
			String[] cols = rows[i].split(",");//一行又几列 = cols.length 
			for(int j = 0; j < cols.length ; j++) {
				System.out.print(cols[j] + " ");
			}
			System.out.println();
		}
		
	}
}
