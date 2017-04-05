/**
 * 
 */
package cn.csu.Inner;

/**
 * 局部内部类
 * 局部内部类仅在定义它的方法中有效。
 * 局部类不能使用static关键字，只能使用final、abstract仅可以访问外部内带有final关键字的局部变量，
 * 因为它访问的是一个字面量或镜像，该局部变量已经不存在了。但是它可以访问任意外部类对象的成员变量。
 * 
 * 当局部内部类定义在静态方法中时，就相当于静态内部类
 * 当局部内部类定义在普通方法中时，就相当于成员内部类
 * @Li An
 *
 */
public class InnerLocal {

	public static void main(String[] args) {
		Outter3 o=new Outter3();
		o.abc();
	}

}

class Outter3{
	private int j=2;
	private void def(){
		System.out.println("执行外部类的def()方法");
	}
	
	public void abc(){
		final int i=11;
		class Inner3{	//局部内部类class之前不能有访问修饰符
			public void ghk(){
				def();
				System.out.println("执行局部内的ghk()方法，且打印局部方法中的i变量："+i+"  "+j);	//i必须为final,但是j可以随意访问
			}
		}
		new Inner3().ghk();	
		//注意：在类外不可直接生成局部内部类（保证局部内部类对外是不可见的）。
		//要想使用局部内部类时需要生成对象，对象调用方法，在方法中才能调用其局部内部类。
		//通过内部类和接口达到一个强制的弱耦合，用局部内部类来实现接口，并在方法中返回接口类型，使局部内部类不可见，屏蔽实现类的可见性。
	}
}