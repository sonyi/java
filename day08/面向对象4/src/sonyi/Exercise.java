package sonyi;
/*
	练习：
		创建一个类，它存储一个int数据成员MyNumber,并给该数据成员创建属性，当该数据成员被存储时，将其乘以100；当其被读取时，将其除以100。
	
 */
public class Exercise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class Number {
	private int myNumber;

	public int getMyNumber() {
		return myNumber/100;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber*100;
	}
}
