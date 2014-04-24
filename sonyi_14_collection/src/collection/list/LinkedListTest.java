package collection.list;

import java.util.LinkedList;

/*

---------------------�������գ���Ҫ��-----------------------------

��ϰ��ʹ��LinkedListģ��һ����ջ���߶������ݽṹ

��ջ���Ƚ����   ��ͬһ������
���У��Ƚ��ȳ�   First in, First out FIFO��ͬһ��ˮ��
*/


class LinkedListTest{
	public static void main(String[] args){
		Queue dl = new Queue();
		dl.myAdd("java01");//��Ϊ��һ��Ԫ����ӵ�������
		dl.myAdd("java02");
		dl.myAdd("java03");
		dl.myAdd("java04");
		
		while(!dl.isNull())
			System.out.println(dl.myGet());//��ȡ���һ��Ԫ��
	}
}

class Queue{
	private LinkedList<Object> link;
	
	Queue(){//����һ���������
		link = new LinkedList<Object>();
	}
	
	public void myAdd(Object obj){//��Ϊ��һ��Ԫ�����
		link.addFirst(obj);
	}
	
	public Object myGet(){//��ȡ���һ��Ԫ�أ����Ƴ�
		return link.removeLast();
	}
	public boolean isNull(){//�жϼ����Ƿ�Ϊ��
		return link.isEmpty();
	}
}
