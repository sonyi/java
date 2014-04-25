package sonyi.exercise;

/*
	练习：定义一个字符串 str = "a,b,c;d,e,f,g;h,i,j,k,l";  把此字符串拆分成一个二维数组的字符串，并打印出来格式如下(3行)： 用方法split()
    a b c
    d e f g
    h i j k l
 */
public class Exercise3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a,b,c;d,e,f,g;h,i,j,k,l";
		String[] row = s.split(";");//对字符串进行第一次切割
		String[][] array = new String[row.length][];//开辟二维字符串数组行空间
		
		for(int i = 0; i < row.length; i++){
			array[i] = row[i].split(",");
		}
		
		/*
		for(int i = 0; i < row.length; i++){//遍历第一次切割后的字符串数组
			String[] col = row[i].split(",");//对字符串进行第二次切割
			array[i] = new String[col.length];//开辟二维字符串数组列空间
			for(int j = 0; j < col.length; j++){//遍历第二次切割后的字符串数组
				//System.out.print(col[j] + " ");//打印数组元素
				array[i][j] = col[j];//将数组元素赋值给二维字符串数组
			}
		}
		*/
		
		//打印二维字符串数组
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
