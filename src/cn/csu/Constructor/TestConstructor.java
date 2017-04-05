package cn.csu.Constructor;

/**
 * 测试构造函数语法：
 * 1、构造函数可以省略
 * 2、构造方法必须与类同名，且类中的方法（非构造函数）也可以与类同名
 * 3、构造函数在类被new时执行
 */
public class TestConstructor {
	public TestConstructor(){
		System.out.println("TestConstructor...");
	}
	
	public static int TestConstructor(){
		return 1;
	}
	
	public static void main(String[] args) {
		TestConstructor tc1 = new TestConstructor();		//此时并不会调用构造函数（C++会），构造函数在new时调用
		//TestConstructor tc2=new TestConstructor();	//new时才调用
		System.out.println(TestConstructor());
	}

}
