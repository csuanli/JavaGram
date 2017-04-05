package cn.csu.Algorithm.Numeric;

/**
 * 九九乘法表
 * 思路1：采用两重for循环打印
 * 思路2；利用一个for循环实现
 */
public class MultiTab {

	public static void main(String[] args) {
		//tab1();
		tab2();
	}
	
	//思路1：双重for循环 
	public static void tab1(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+j*i+"\t");
			}
			System.out.println();
		}
	}
	
	//思路2：一次循环
	public static void tab2(){
		for(int i=1,j=1;j<=9;i++){
			System.out.print(i+"*"+j+"="+i*j+"\t");
			if(i==j){		//当i==j时，换行
				i=0;		//i回复到0
				j++;		
				System.out.println();
			}
		}
	}
	

}
