package cn.imcore.method;

public class Leaf {
	int i = 0;//��Ա����

	Leaf(int i) {//���췽��
		this.i = i;//��Ա������ֲ��������� ��this.i��
	}

	public Leaf increament() {//��Ա����  ������.����
		i++;
		return this;
	}

	public void print() {
		System.out.println("i = " + i);
	}

	public static void main(String[] args) {
		Leaf leaf = new Leaf(100);//ʵ����  this��ָ��ǰ����leaf
		leaf.increament().increament().print();
		//leaf.increament();
		//leaf.increament();
		//leaf.print();
	}
}
