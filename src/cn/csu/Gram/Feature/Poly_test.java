package cn.csu.Gram.Feature;

/**
 * @file Poly_test.java
 * @author 李岸
 * @version 1.0
 * @since Sep 27, 2010
 */
class Parents{
	public void print(){
		System.out.println("This is parent");
	}
	public void hello(){
		System.out.println("Coming From Parents");
	}
	
}

class Father extends Parents{
	public void print(){				//覆盖父类的方法
		System.out.println("This is father");
	}
}

class Mother extends Parents{
	public void print(){
		System.out.println("This is mother");
	}
}

public class Poly_test {

	/**
	 * 继承是子类使用父类的方法，而多态则是父类使用子类的方法。
	 */
	public static void main(String[] args) {
		//多态，运行时后期绑定
		Parents p=new Mother();
		p.print();					
		Parents p1=new Father();
		p1.print();
		
		//继承，继承父类的方法
		p.hello();		
	}
}
