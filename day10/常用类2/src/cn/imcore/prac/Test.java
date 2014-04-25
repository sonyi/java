package cn.imcore.prac;

public class Test {

	public static void main(String[] args) {
		String s = "1,2;3,4,5;6,7,8";
		String[] rows = s.split(";");
		double[][] d = new double[rows.length][];
		//打印每行内容
		for(int m=0; m<rows.length; m++) {
//			System.out.println("====打印每行内容====" + m);
//			System.out.println("rows["+m+"]=" + rows[m]);
			//拆分列
			String[] cols = rows[m].split(",");
			d[m] = new double[cols.length];
			for(int n=0; n<cols.length; n++) {
				d[m][n] = Double.parseDouble(cols[n]);
				System.out.print(d[m][n] + " ");
			}
//			System.out.println("\n====进入下一行====");
			System.out.println();
		}
	}
}
