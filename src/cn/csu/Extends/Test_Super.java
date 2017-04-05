package cn.csu.Extends;

import java.util.Date;
/**
 * getClass()在Object类定义成final。子类不能覆盖该方法，所以test中就是调用
 * 从父类集成的getClass()方法，等效于super.getClass.getName();
 */
public class Test_Super extends Date{
	public static void main(String[] args){
		new Test_Super().test();
	}
	
	public void test(){
		//打印本身
		System.out.println(getClass().getName());
		//打印父类
		System.out.println(getClass().getSuperclass().getName());	
	}
}
