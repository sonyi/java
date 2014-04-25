package cn.imcore.abs;

public class TestCalcu {

	public static void main(String[] args) {
		Calcu cal = new CalcuImpl();
		cal.divi(5, 2);
		cal.plus(4, 6);
		
		Calcu2 cal2 = new CalcuImpl();
		cal2.mix(5, 2);
		
//		CalcuImpl cImpl = new CalcuImpl();
//		cImpl.divi(3, 4);
		
	}
}
