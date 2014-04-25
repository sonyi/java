package cn.imcore.abs;

public class CalcuImpl extends Object implements Calcu, Calcu2{

	@Override
	public void divi(int x, int y) {
		System.out.println(x/y);
		
	}

	@Override
	public void plus(int x, int y) {
		System.out.println(x+y);
		
	}

	@Override
	public int mix(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

}
