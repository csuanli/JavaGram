/**
 * 
 */
package cn.csu.Gram.Feature;

/**
 * 重载可以改变返回值，但并不能只有返回值不同，而其他参数完全一样 
 * 重载可以方法的参数个数，类型不同，而不能参数相同，返回值不同
 * (即只能靠参数而不能靠返回值类型来区分重载，C++同此理)
 * 
 * @author Lenovo
 * 
 */
public class Poly_Overload {

	public void f() {

	}

	// 重载可以方法的参数个数，类型不同，而不能参数相同，返回值不同
	/*
	 * public int f(){ return 1; }
	 */

	// 重载方法可以改变返回值
	public int f(int i) {
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
