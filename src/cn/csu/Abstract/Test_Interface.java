package cn.csu.Abstract;
/**
 * 接口:
 * 1,接口中默认的方法为public abstract,变量为public static final
 * 2,接口可以继承接口，但是不能实现接口，
 * 3,接口在抽象类中可以被继承（且不实现，可以保留到子类中实现）
 */
public class Test_Interface implements Test2
{
	//实现父类所有接口
	public void methodA1() 
	{
	}
	
	public void methodB1() 
	{
	}
	
	public void methodB2() 
	{
	}
}

interface Test1{
	public int a=1;	//实际为	public static final int a=1;
	public abstract void methodA1();
}

interface Test2 extends Test1{	//implements Test1是错误的
	public int b=1;	//实际为	public static final int a=1;
	public abstract void methodB1();
	public void methodB2();	//实际为public abstract
}

interface Test3{
	//private double privateOne=1;
	//protected double privateTwo=1;	//private,protected不能修饰
	//public int publicFout;	//erro:必须初始化
	/*public void methodOne(){		//不能有方法体
		System.out.println("1111");
	}*/
	//public static void methodTwo();	//只能用abstract
	//public final int methodTwo();	//只能用abstract
	public abstract void methodFour();	//正确
	
}