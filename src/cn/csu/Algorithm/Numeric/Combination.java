package cn.csu.Algorithm.Numeric;

/**
 * 组合的递归实现从n个中取k可以分解为从
 * 从n-1中取k
 * 从n-1中取k-1
 * @file Combination.java
 * @author 李岸
 * @version 1.0
 * @since 2011-4-26
 */
public class Combination {
	
	public static void main(String[] args) {
		System.out.println(Comb(6,2));
	}
	/**
	 * 递归函数，注意先写跳出条件，再递归
	 *@Method Comb
	 */
	public static int Comb(int n,int k){
		if(n==k||k==0){
			return 1;
		}
		if(n>k){
			return Comb(n-1,k)+Comb(n-1,k-1);
		}
		return 0;
	}
}