package cn.csu.Abstract;

/**
 * 测试Abstract的用法：
 * 1、abstract可用于修饰类，方法，但不能修饰字段
 * 2、abstract抽象方法不能有大括号
 * 3、包含abstract方法的类必须定义为抽象类，abstract类不能创建实例对象
 * 4、抽象类应用，模板模式
 * 5、抽象类可以继承具体类，抽象类可以实现接口
 */
/**接口
 * 4、接口可以说成是抽象类的特例，接口中的所有方法必须的是抽象的，
 * 5、方法默认为public abstract、成员变量默认为public static final
 */
/**区别
 * 抽象类中可以有构造函数、普通成员变量、非抽象的普通方法，接口不能有
 * 抽象类可以包含静态成员方法，接口不能
 * 抽象类可以实现接口(方法体可以不实现)，但是不能继承接口。
 * 接口可以继承接口，但是不能实现接口。
 */
public class Test_Abstract 
{
	public static void main(String[] args) 
	{
		D d=new D();
	}
}

abstract class A extends C implements B
{
	//public abstract int a; //abstract不是访问修饰符，不能用于修饰字段
	public int a;
	public A()
	{
		System.out.println("Construct... A");
	}
	public abstract int methodA();
	
	public static void methodA2()
	{
	};
}

interface B
{
	int a=1;	//实际为public static final类型
	public int methodB();
}

class C
{
	public void methodC()
	{
	}
}

class D extends A
{	
	//必须实现其父类中的抽象方法
	public int methodA() 
	{
		return 0;
	}
	public int methodB() 
	{
		return 0;
	}
}