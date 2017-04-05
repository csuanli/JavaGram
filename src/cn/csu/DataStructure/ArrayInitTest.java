package cn.csu.DataStructure;

public class ArrayInitTest {
	/**
	 * 数组的初始化形式
	 */
	public static void main(String[] args) {
		int[] a;
		a=new int[5];	//初始化方式一
		a=new int[]{1,5,6,3,2};		//初始方式二
		/* 
		 * a={1,5,6}；	//初始方式三错误，因为这情况下int a[]并没有分配空间，不能往里面赋值
		 */
		for(int m:a){
			System.out.println(m);
		}
		System.out.println("-----------------------------");
		int b[];	//声明，正确
		//int b[10]; int b[10]={1,2,3}	//错误的方式,初始化时不包含size
		int c[]={1,2,3,4};		
	}

}
