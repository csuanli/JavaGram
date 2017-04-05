package cn.csu.Algorithm.Problem;

/**
 * 斐波拉契数列
 * 解法一：递归方式
 * 解法二：循环方式，从下往上计算，避免重复计算
 * @author user
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		long t1=System.currentTimeMillis();
		System.out.print(fin(40));		//数字过大就会出现调用栈溢出
		long t2=System.currentTimeMillis();
		System.out.println("   耗时： "+(t2-t1));
		
		long t3=System.currentTimeMillis();
		System.out.print(fin_noRecur(102));
		long t4=System.currentTimeMillis();
		System.out.println("   耗时： "+(t4-t3));
	}
	
	//递归方式：有重复计算
	public static int fin(int n){
		if(n<=0){
			return 0;
		}
		if(n==1||n==2){
			return 1;			
		}		
		return fin(n-1)+fin(n-2);
	}
	//非递归方式：避免重复计算
	public static int fin_noRecur(int n){
		if(n<=0){
			return 0;
		}
		if(n==1||n==2){
			return 1;			
		}
		int fst=1;
		int sec=1;
		int sum=0;
		for(int i=3;i<=n;i++){
			sum=fst+sec;
			fst=sec;
			sec=sum;
		}
		return sum;
	}
}
