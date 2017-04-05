package cn.csu.Algorithm.Numeric;

/**
 * 求1--100的素数（质数）
 * 思路1：一个数只能被1或者自身整除
 * 思路2：（优化）一个数不能被大于其一半的数整除
 * 思路3：（优化）一个数不能被大于其评分跟的数整除，如9不能被大于3以上的数整除
 */
public class Prime {

	public static void main(String[] args) {
		for(int i=1;i<=100;i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(double num){
		if(num==1) return false;
		long temp=(long)Math.sqrt(num);
		for(int j=2;j<=temp;j++){
			if(num%j==0){
				return false;
			}
		}
		return true;
	}

}
