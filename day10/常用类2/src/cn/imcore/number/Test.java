package cn.imcore.number;

public class Test {
	public static void main(String[] args) {
		String s = "100";
		byte b1 = 120;
		Byte b2 = b1;  
		Byte b3 = new Byte(b1);
		
		byte b4 = b3.parseByte(s);  //�ַ���ת���ֽ�
		String s1 = b3.toString(); 
		
		byte a = 3;
		Byte b = new Byte(a);//byte-> Byte��װ��
		a = Byte.valueOf(b);//Byte��װ�� -> byte ��������
	
	    int i1 = Integer.parseInt(s);
	    
	    float f = Float.parseFloat(s);
	    
	    double d = Double.parseDouble(s);
	    
	    boolean bo1 = Boolean.parseBoolean(s);
	    
	    System.out.println(bo1);//false
	    
	    boolean bo2 = Boolean.parseBoolean("true");
	    
	    System.out.println(bo2);//true
	}
}
