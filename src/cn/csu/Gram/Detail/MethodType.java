package cn.csu.Gram.Detail;

/**
 * 测试类方法和实例方法
 * 1，类方法不能用this调用本类的类方法，但可以直接调用
 * 2，类方法不能调用实例方法
 */
public class MethodType {
	
	//类方法A
	private static void methodA(){
		System.out.println("methodA");
		//this.methodB();	//不能用this调用本类的类方法	
		methodB();			//但是可以直接调用
		//methodC();		//类方法中不能调用实例方法
	}
	
	//类方法B
	private static void methodB(){
		System.out.println("methodB");
	}
	
	//实例方法
	private void methodC(){
		System.out.println("methodC");
		
	}
	
	//类方法
	private void methodD(){
		System.out.println("methodD");
	}

	public static void main(String[] args) {
		MethodType mt=new MethodType();
		mt.methodA();			//两种方式都可以
		MethodType.methodA();
	}

}
