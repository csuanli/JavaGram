package cn.csu.Algorithm.Problem.NetEase;


/**
 * 有一个人站在申影院门口卖票，票价50，一开始手上没有找零的钱，
 * 现在有两种人来买票，A 拿着100元的钱，人数为 m(m<20)，B 拿着50元的钱，
 * 人数为n(n<20)。卖票的人必项用仅B类人中那里得来钱找给A，所以卖票的顺序
 * 是有限制的。
 * 要求写一个程序打印出所有卖票序列：
 * 例如：m=2,n=3
 * 	BABAB
 *	BBAAB
 * 	BBBAA
 * 	BBABA
 * @author Li An
 */
public class MovieTicket {
	/**
	 * 解题思路：
	 * 1、思想
	 * 金句：涉及“状态转换和记录”的都可以用递归的方法求解
	 * 模拟 所有人买票的全过程，
	 * 
	 * 变量假设
	 * 假设拿着100元钱的人A的人数有m 人，拿着50元钱的B的人数有n 人，
	 * 某一时刻已经买票的A有a 人，B有b 人
	 * 
	 * 子问题
	 * 如果进来的一个人是A，需要判断条件 ①a<m且②a<b
	 * 如果进来的一个人是B，需要判断条件 b<n
	 * 
	 * 终止条件
	 * 所有的人都已经买票完毕，即有a+b==m+n
	 * 
	 */
	public static char[] str;
	
	public static void main(String[] args) {
		str=new char[2+3];
		ticket(2,3);
	}
	
	public static void ticket(int m,int n){
		if(m>=20||n>=20){
			System.out.println("请输入合法值！");
		}else if(m>n){
			System.out.println("没有合适卖票序列！");
		}else{
			ticketDis(m, n, 0, 0);
		}
	}
	
	public static void ticketDis(int m,int n,int a,int b){
		if(a+b==m+n){	//全部买到票
			for(int i=0;i<str.length;i++){
				System.out.print(str[i]+" ");
			}
			System.out.println();
		}
		if(a<m&&a<b){	//如果卖给A的数目，小于B,则可以继续卖给A
			str[a+b]='A';
			ticketDis(m, n, a+1, b);
		}
		if(b<n){		//卖给B的可以随时卖
			str[a+b]='B';
			ticketDis(m, n, a, b+1);                                
		}
		
	}
	
}
