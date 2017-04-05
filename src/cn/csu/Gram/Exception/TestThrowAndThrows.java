package cn.csu.Gram.Exception;

/**
 * @author Administrator
 *
 */

class Animal{
	public String name;
	public int age;
}
public class TestThrowAndThrows {

	/**
	 * @param args
	 */
	Animal aObj[];
	public TestThrowAndThrows() {
		aObj=new Animal[3];
		try{
			System.out.println("动物初始化");
			for(int i=0;i<3;i++){
				aObj[i]=new Animal();
				aObj[0].name="cat";
				aObj[0].age=1;
				aObj[1].name="tiger";
				aObj[1].age=2;
				aObj[2].name="rabbit";
				aObj[2].age=3;
			}			
		}catch(NullPointerException e){
			System.out.println("构造方法中的空指针异常");
//			e.printStackTrace();
//			throw e;
		}
	}
	
	public void showAnimal(){
		for(int i=0;i<3;i++){
			System.out.println("name:"+aObj[i].name+"  age:"+aObj[i].age);
		}
	}
	
	private void showArithException(int a,int b) throws ArithmeticException{//抛出0除异常
		int result=0;
		try{
			result=a/b;
		}catch (ArithmeticException e) {
//			System.out.println("除数不能为0");
			throw e;
		}
		System.out.println("result结果：");
	}
	
	
	public static void main(String[] args) {
		TestThrowAndThrows ttat=new TestThrowAndThrows();
		try{
			ttat.showArithException(5, 0);
		}catch(ArithmeticException e){
			System.out.println("除数不能为0");
			System.out.println("异常信息...");
			e.printStackTrace();
		}
		
		try{
			ttat.showAnimal();
		}catch(NullPointerException e1){
			System.out.println("空指针异常...");
			System.out.println("异常信息...");
			e1.printStackTrace();
		}	
	}
}