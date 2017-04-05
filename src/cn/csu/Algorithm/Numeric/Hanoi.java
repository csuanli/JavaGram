package cn.csu.Algorithm.Numeric;

/**
 * Hanoi问题：递归实现
 * n个盘从A经B移动到C可以分为：
 * （1）n-1个盘从A经C移动到B
 * （2）第n个盘从A移动到C
 * （3）n-1个盘从B经A移动到C
 * @file Hanoi.java
 * @author 李岸
 * @version 1.0
 * @since 2011-4-26
 */
public class Hanoi {
	public static int cout=0;
	public static void main(String[] args) {
		han(5,'A','B','C');
	}
	
	public static void han(int n,char a,char b,char c){
		
		if(n<=0){
			return;
		}
		if(n==1){
			System.out.println("第"+(++cout)+"次：从 "+a+"移动到 "+c);
		}else{
			han(n-1,a,c,b);			
			System.out.println("第"+(++cout)+"次：从 "+a+"移动到 "+c);
			han(n-1, b, a, c);
		}
	}

}

