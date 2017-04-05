package cn.csu.Inner;

/**
 * 静态内部类
 * 静态内部类，无法访问外部类的非静态成员，它几乎是独立的，可以在没有外部对象的情况下创建。
 * @Li An
 *
 */
public class InnerStatic {

	public static void main(String[] args) {
		Outter1.Inner1 oi=new Outter1.Inner1();
		oi.abc();
	}
}

class Outter1{
	int i=2;
	static int j=2;
	static class Inner1{
		public void abc(){
			//i++;	//无法访问外部类的非静态成员
			j++;
			System.out.println("执行InnerStatic内部类！");
		}
	}
	
}