package sonyi;

/*@author shijin  
* ��������������ģ���У�Ҫ��֤���¼��㣺  
* 1 ͬһʱ����ֻ����һ������������     ������������sychronized  
* 2 ͬһʱ����ֻ����һ������������     ���ѷ�������sychronized  
* 3 ������������ͬʱ�����߲�������     ������������sychronized  
* 4 ���������ѵ�ͬʱ�����߲�������     ���ѷ�������sychronized  
* 5 ����ռ��ʱ�����߲��ܼ�������     ����ǰѭ���ж��Ƿ�Ϊ�գ��յĻ������߳�wait���ͷ�����������ͬ������ִ��  
* 6 ����ռ���ʱ�����߲��ܼ�������     ����ǰѭ���ж��Ƿ�Ϊ�������Ļ������߳�wait���ͷ�����������ͬ������ִ��     
*/ 
 
//����  
class  ProducerConsumer  
{  
    public static void main(String[] args)   
    {  
        StackBasket s = new StackBasket();  
        Producer p = new Producer(s);  
        Consumer c = new Consumer(s);  
        Thread tp = new Thread(p);  
        Thread tc = new Thread(c);  
        tp.start();  
        tc.start();  
    }  
}  
 
//  
class Mantou  
{  
    private int id;  
      
    Mantou(int id){  
        this.id = id;  
    }  
 
    public String toString(){  
        return "Mantou :" + id;  
    }  
}  
 
//����ջ�ռ�  
class StackBasket  
{  
    Mantou sm[] = new Mantou[6];  
    int index = 0;  
      
    /**   
    * show ��������.  
    * show �÷���Ϊͬ�����������з�������  
    * show ����ѭ���ж��������Ļ�ʹ���̵߳ȴ����ͷ�ͬ�����������������ѣ�  
    * show ������ʱ���Ȼ������ڵȴ������ѷ���������Ҳֻ������������״̬��  
    * show �����������ͷ�ͬ�������������Ѳ��ܳ��и�����������  
    * @param m Ԫ��  
    * @return û�з���ֵ   
    */   
 
    public synchronized void push(Mantou m){  
        try{  
            while(index == sm.length){  
                System.out.println("!!!!!!!!!��������!!!!!!!!!");  
                this.wait();  
            }  
            this.notify();  
        }catch(InterruptedException e){  
            e.printStackTrace();  
        }catch(IllegalMonitorStateException e){  
            e.printStackTrace();  
        }  
          
        sm[index] = m;  
        index++;  
        System.out.println("�����ˣ�" + m + " �ֿ���" + index + "����ͷ");  
    }  
 
    /**   
    * show ���ѷ���  
    * show �÷���Ϊͬ�����������з�����  
    * show ����ѭ���жϿշ񣬿յĻ�ʹ���̵߳ȴ����ͷ�ͬ��������������������  
    * show ������ʱ���Ȼ������ڵȴ�����������������Ҳֻ������������״̬  
    * show �����ѽ����ͷ�ͬ�����������������ܳ��и�����������  
    * @param b true ��ʾ��ʾ��false ��ʾ����   
    * @return û�з���ֵ   
    */   
    public synchronized Mantou pop(){  
        try{  
            while(index == 0){  
                System.out.println("!!!!!!!!!���ѹ���!!!!!!!!!");  
                this.wait();  
            }  
            this.notify();  
        }catch(InterruptedException e){  
            e.printStackTrace();  
        }catch(IllegalMonitorStateException e){  
            e.printStackTrace();  
        }  
        index--;  
        System.out.println("�����ˣ�---------" + sm[index] + " �ֿ⻹��" + index + "����ͷ");  
        return sm[index];  
    }  
}  
 
class Producer implements Runnable  
{  
    StackBasket ss = new StackBasket();  
    Producer(StackBasket ss){  
        this.ss = ss;  
    }  
 
    /**   
    * show ��������.   
    */   
    public void run(){  
        for(int i = 1;i <= 20;i++){  
            Mantou m = new Mantou(i);  
            ss.push(m);  
//          System.out.println("�����ˣ�" + m + " ��" + ss.index + "����ͷ");  
//          ������һ�н��в����ǲ��׵ģ���index�ķ���Ӧ����ԭ�Ӳ������Ϊ������push֮������֮ǰ�������ˣ�������������  
            try{  
                Thread.sleep((int)(Math.random()*500));  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
    }  
}  
 
class Consumer implements Runnable  
{  
    StackBasket ss = new StackBasket();  
    Consumer(StackBasket ss){  
        this.ss = ss;  
    }  
 
    /**   
    * show ���ѽ���.  
    */   
    public void run(){  
        while(ss.index != 0){  
            ss.pop();  
//          System.out.println("�����ˣ�---------" + m + " ��" + ss.index + "����ͷ");  
//  ͬ��  ������һ�н��в���Ҳ�ǲ��׵ģ���index�ķ���Ӧ����ԭ�Ӳ������Ϊ������pop֮������֮ǰ�������ˣ�������������  
            try{  
                Thread.sleep((int)(Math.random()*1000));  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
    }  
} 
