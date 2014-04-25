package cn.imcore.test;

import java.util.LinkedList;

public class Point {
   private int x;
   private int y;
   static LinkedList list = new LinkedList();
   public Point(int x, int y) {
	   this.x = x;
	   this.y = y;
   }
   
   
   public static void main(String[] args) {
	   init();
	   list.pop();
	   list.addLast(new Point(5, 2));
	   System.out.println(list);
	   list.pop();
	   list.addLast(new Point(6, 2));
	   System.out.println(list);
   }
   
   
   public static void init() {
	   for(int x=4; x>=2; x--) {
		   list.push(new Point(x, 2));
	   }
	   System.out.println(list);
   }


@Override
public String toString() {
	return "Point [x=" + x + ", y=" + y + "]";
}
   

   
}
