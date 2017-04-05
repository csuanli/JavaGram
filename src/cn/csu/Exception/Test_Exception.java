package cn.csu.Exception;
/**
 * Java语言异常关键字：throws、throw、try、catch、finally
 * throws:用来表明成员函数可能抛出的各种“异常”
 * throw：用于明确的抛出一个异常
 * throwable:是所有错误或异常的超类，Error, Exception是其子类
 */
public class Test_Exception {
	public static void main(String[] args){
		try {
			methodA();
		} catch (Ex e) {
			System.out.println("打印自定义异常："+e);;
		}
	}
	public static void methodA() throws Ex{
		throw(new Ex());
	}
}

class Ex extends Throwable{	//也可以继承自RuntimeException
	public Ex() {
		System.out.println("Ex");
	}
}