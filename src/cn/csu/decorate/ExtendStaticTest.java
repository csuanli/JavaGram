package cn.csu.decorate;


/**
 * @file ExtendStaticTest.java
 * @author 李岸
 * @version 1.0
 * @since Apr 9, 2010
 */
class A{
	static void print(){
		System.out.println("class A");
	}
}

class B extends A{
	static void print(){		//少了static则出错
		System.out.println("class B");
	}
}

public class ExtendStaticTest {
		public static void main(String[] args) {
			A a=new A();
			B b=new B();
			a.print();
			b.print();
			a=b;
			//b=a;	子类不能转换为父类
			a.print();	//输出 class A
	}

}
