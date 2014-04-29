package sonyi;

public class Test2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Print().start();	
	}
}

class Print extends Thread{
	public char temp = 'a'; 
	public void run(){
		while((temp >= 'a' && temp <= 'z')){	
			System.out.println(Thread.currentThread().getName() + ": " + temp);
				temp += 1;			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}