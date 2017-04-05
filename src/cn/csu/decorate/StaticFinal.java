package cn.csu.decorate;

/**
 * 关于static和final的定义
 * 方法体中的成员变量不能用public、static等修饰
 * StaticFinal.java
 * @author 李岸
 * @version 1.0
 * @since 2011-4-25
 */
public class StaticFinal {
	public final int a=5;
	public static final int b=5;
	public static void main(String[] args) {
		final int c=5;	//正确
//		public final int c=5;	//错误
	}
}
