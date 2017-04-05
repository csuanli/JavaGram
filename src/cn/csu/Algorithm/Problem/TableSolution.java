package cn.csu.Algorithm.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**假设你站在点(0,0)处，走向点(m,m)处，规定只能向右走和向下走，请用C、C++或Java中的任一中语言编程实现：
 *1)   输出所有可行的路径。
 *2)   统计所有可行的路径的总数。 
 * @file TableSolution.java
 * @author 李岸
 * @version 1.0
 * @since Apr 25, 2010
 */
public class TableSolution {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int[][] path;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int x,y;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入需到达点的位置：");
		System.out.println("x:");
		x=Integer.parseInt(br.readLine());
		System.out.println("y:");
		y=Integer.parseInt(br.readLine());		
		System.out.println("从(0,0)到达（"+x+","+y+"）存在路径数："+getNumOfPath(x, y));
		System.out.println("输出路径如下：");
		showPath(y, x);
	}
	
	static int getNumOfPath(int m,int n){
		if(m==0&&n==0){
			return 0;
		}else if(m==0){
			return 1;
		}else if(n==0){
			return 1;
		}else{
			int sum=0;
			sum=getNumOfPath(m-1,n)+getNumOfPath(m,n-1);
			return sum;
		}		
	}
	
	static void showPath(int x,int y){
//		if(x=)
		showPath(x+1,y);
		showPath(x+1,y);
		
		/*String[] strs=new String[x+y];
		for(int i=0;i<x+y;i++)
			strs[i]="down";
		
		for(int i=0;i<x;i++){
			strs[i]="right";
			for(int j=i+1;j<x;j++){
				strs[j]="right";
			}				
		}
		
		for(int i=0;i<x+y;i++)
			System.out.print(strs[i]+" ");*/
	}
}