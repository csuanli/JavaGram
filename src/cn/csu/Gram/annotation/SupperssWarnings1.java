package cn.csu.Gram.annotation;

public class SupperssWarnings1 {

	public static void main(String[] args) {
		System.out.println(new Test1().div(3, 0));
	}
}
//取消特定的警告,以下两种形式都可以，对结果没有影响
@SuppressWarnings(value={"finally"})
//@SuppressWarnings("finally")
class Test1{
	public int div(int x,int y){
		try{
			int z=x/y;
		}catch(ArithmeticException e){
			e.printStackTrace();			
		}finally{
			System.out.println("-------");
			return 0;
		}
	}
}
