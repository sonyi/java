package cn.imcore.method;

public class Leaf {
	int i = 0;//成员变量

	Leaf(int i) {//构造方法
		this.i = i;//成员变量与局部变量重名 ‘this.i’
	}

	public Leaf increament() {//成员方法  对象名.方法
		i++;
		return this;
	}

	public void print() {
		System.out.println("i = " + i);
	}

	public static void main(String[] args) {
		Leaf leaf = new Leaf(100);//实例化  this代指当前对象leaf
		leaf.increament().increament().print();
		//leaf.increament();
		//leaf.increament();
		//leaf.print();
	}
}
