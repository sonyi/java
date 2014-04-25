package cn.imcore.array;
/*
 * 数组的初始化形式：动态初始化和静态初始化
 */
public class Test2 {
	public static void main(String[] args) {
		//动态初始化
		  double[] d1 = new double[]{1,2};	  
	      double[][] d = new double[3][4];
	      d[0][1] = 10;
	      d[1] = d1;
	      
	    //静态初始化
	      double[][] arr = new double[][]{
	    		  {1,2},
	    		  {3,4,5},
	    		  {6,7,8,9}
	    		  };	    
	     for(int row = 0; row<arr.length; row++) {
	    	 for(int col = 0; col<arr[row].length; col++) {//打印列
	    		 System.out.print(arr[row][col] + " ");
	    	 }
	    	 System.out.println();
	     }
	}
}
