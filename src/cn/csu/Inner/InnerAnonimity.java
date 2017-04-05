package cn.csu.Inner;

/**
 * 匿名内部类
 * 匿名内部类的定义和使用没有出现class关键字，但还是创建了，该类实现一个借口，
 * 直接在方法体重提供具体实现。
 * @Li An
 */
public class InnerAnonimity {
	public static void main(String[] args) {
		Outter4 o=new Outter4();
		o.abc();
	}
}

class Outter4{
	private void gkh(){
		System.out.println("执行外部类的gkh()方法!");
	}
	public void abc(){
		new Inner4(){
			public void def(){
				gkh();
				System.out.println("执行内部类的def()方法!");
			}
		}.def();
	}
	public void fun(){
		new Thread(new Runnable() { // 匿名内部类
			public void run() {
			}
		}).start();
	}
}

interface Inner4{
	public void def();
}
