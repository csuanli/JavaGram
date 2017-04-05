
public class Test {

	public static void main(String[] args) throws Exception{
//		intArray[] a1,a2;
		int[] a1,a2;
		int a3;
		a1=new int[2];
		a2=new int[2];
		   
		String a="sssssd"; 
		a.length();
		
		new Test2();
		//System.out.println(a1.getClass());
		//System.out.println(a1.getClass());
	}
	
	/**
	 * 构造方法
	 */
	public Test(){
		System.out.println("xxxx");
	}
}

class Test2 extends Test
{
	/**
	 * 子类方法名同父类构造方法，不会产生覆盖
	 */
	public void Test()
	{
		System.out.println("sss");
	}
}
