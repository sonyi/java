package string.demo;

/*

---------------------String类------------------------
String类：
	字符串是一个特殊的对象。
	字符串一旦初始化就不可以被改变。（字符串最大特点）
	
String str1 = "abc" 与String str2 = new String("abc")有什么区别？？？
	String str1 = "abc";str1是一个类类型变量，"abc"是一个对象。
	String str2 = new String("abc");String类复写了object类中的equals方法，
		该方法用于判断字符串是否相同。
	str1和str2区别：
		str1在内存中有一个对象。str2在内存中有两个对象。
	
	String str3 = "abc"  问：
		str1==str2.-----false   不同对象。
		str1==str3.-----true   字符串已经在内存中常量池内存在，str3初始化时发现已经
			存在，就不再独立开辟空间创建字符串。
			
String类适用于描述字符串事物。提供了多个方法对字符串进行操作。
常见的操作有哪些？
	1、获取：
		1.1字符串中包含的字符数，也就是字符串的长度。int length();
			(数组的length是属性，字符串length();是方法)
		1.2根据位置获取位置上的某个字符。char CharAt(int index);
			当访问到字符串中不存在的角标时会发生StringIndexOfBoundsException。
		1.3根据字符获取该字符在字符串中的位置。
			int indexOf(int ch);返回的是ch在字符串中第一次出现的位置。
			int indexOf(int ch,int fromIndex);从fromIndex指定位置开始，获取ch在字符串中出现的位置。
				如果没有找到，返回值为-1。
			int indexOf(String str);返回的是str在字符串中第一次出现的位置。
			int indexOf(String str,int fromIndex);从fromIndex指定位置开始，获取str在字符串中出现的位置。
			
			int lastIndexOf(int ch);反向索引。（从右往左查询，但是角标不变）
			int lastIndexOf(int ch, int fromIndex);
			int lastIndexOf(String str);
			int lastIndexOf(String str,int fromIndex);
		
	2、判断：
		2.1字符串中是否包含某一个字符串。
			boolean contains(String str);
			特殊之处：indexOf(String str):可以索引str第一次出现位置，如果返回-1,表示该
				str不在字符串中存在。所以，也可以用于判断对指定内容是否包含。
				if(str.indexOf("aa"!=-1));
				该方法既可以判断，又可以获取出现的位置。
		2.2字符中是否有内容。
			boolean isEmpty();原理就是判断长度是否为零。
		2.3字符串是否是以指定内容开头。
			boolean startWith(String str);
		2.4字符串是否是以指定内容结尾。
			boolean endsWith(String str);
		2.5判断字符串内容是否相同。（复写了object中的equals方法）
			boolean equals(String str);
		2.6判断内容是否相同，并忽略大小写。
			boolean equalsIgnoreCase();
	3、类型转换：
		3.1将字符数组转换成字符串
			构造函数：String(char[])
					  String(char[],offset,count);将字符数组中的一部分转换成字符串
			静态方法：static String copyValueOf(char[]);
					  static String copyValueOf(char[] data,int offset,int count);
					  
					  static String ValueOf(char[]);
			
		3.2将字符串转换成字符数组（****重点******）
			char[] toCharArray();
		3.3将字节数组转换成字符串
			String(byte[])
			String(byte[],offset,count);将字节数组中的一部分转
		3.4将字符串转换成字节数组
			byte[] getBytes();
		3.5将基本数据类型转换成字符串
			static String ValueOf(double);
			static String valueOf(int);	
			eg:3+"";  == String.value(3);
		特殊：字符串和字节数组在转换过程中，是可以指定编码表的
		
	4、替换：
		String replace(char oldChar,char newChar);
			(替换后产生新字符串，因为字符串初始化后就不会改变。如果替换不存在，返回的是原串)
		
	5、切割：
		String[] split(regex);
		
	6、子串：获取字符串中的一部分。
		String substring(begin);---从指定位置开始到结尾。
		String substring(begin,end); ---包含头，不包含尾。
			如果角标不存在，会出现字符串角标越界异常。
			
	7、大小写转换、去除空格、比较：
		7.1将字符串转换成大写或者小写
			String toUpperCase();
			String toLowerCase();	
		7.2将字符串两端的多余空格去除
			String trim();
		7.3对两个字符串进行自然顺序的比较
			int compareTo(String); 返回值：相同为0；大于为正数；小于为负数。
			
			
-------------------------StringBuffer、StringBuilder-----------------------------

StringBuffer是字符串缓冲区。
	特点：
		1、是一个容器。而且长度是可变化的。
		2、可以操作多个数据类型。
		3、最终会通过toString方法变成字符串。

CURD:增删改查
	即：create，update，read，delete

1、存储：
	StringBuffer append(); 将指定数据作为参数添加到已有数据结尾处。
	StringBuffer insert(int index,数据); 可以将数据插入到指定的index位置。
	
2、删除：
	StringBuffer delete(int start,int end); 删除缓冲区中的数据，包含start，不包含end。
	StringBuffer deleteCharAt(int index); 删除指定位置的字符。
	
3、获取：
	Char charAt(int index);
	int indexOf(String str);
	int lastIndexOf(String str);
	int length();
	String substring(int start,int end);  包含start，不包含end
	
4、修改：
	StringBuffer replace(int start,int end,String str);  包含start，不包含end
	setCharAt(int index,char ch);

5、反转：
	StringBuffer reverse();
    
6、将缓冲区中指定数据存储到指定数组中：
	void getChars(int srcBegin,int srcEnd,char[] dst,int dstBegin);
	
在JDK1.5版本之后出现了StringBuilder。功能与StringBuffer相同。
	StringBuffer是线程同步。线程是安全的，但是每次都需要访问锁，效率较低。
	StringBuilder是线程不同步。线程是不安全的，不需要访问锁，效率高。用于多线程不安全。
	所以如果需要多线程同步，建议使用StringBuffer，而不需要同步的使用StringBuilder。
	
	以后开发，建议使用StringBuilder。


Java升级的三个因素：
	1、提高效率；
	2、简化书写；
	3、提高安全性。


---------------------------基本数据类型对象包装类----------------------------------

基本数据类型	引用数据类型
	byte			Byte
	int				Integer
	short			Short
	long			Long
	boolean			Boolean
	float			Float
	double			Double
	char			Character

基本数据类型对象包装类的最常见作用：
	用于基本数据类型和字符串类型之间做转换。

基本数据类型转换成字符串：
	基本数据类型 + "";
	基本数据类型.toString(基本数据类型值);  
		eg：Integer.toString(34);  //将34整数变成"34";
		
字符串转换成基本数据类型：
	第一种方法：(静态调用方式)
		xxx是基本数据类型；
			xxx a = Xxx.parseXxx(String);
			eg:Integer.parseInt("123");
				//将字符串"123"变成整数123;必须传入数字类型的字符串，否则出现异常
			eg:Long.parseLong("123");
		boolean b = Boolean.parseBoolean("true");
	第二种方法：(非静态，对象调用方式)
		Integer i = new Integer("123");
		int num = i.intValue();
		
十进制转成其他进制：
	toBinaryString();
	toHexString();
	toOctalString();
	
其他进制转成十进制：
	parseInt(String,radix);
		eg:radix进行等级，如2,8,10,16


JDK1.5版本以后出现的新特性：
	
		

 */
