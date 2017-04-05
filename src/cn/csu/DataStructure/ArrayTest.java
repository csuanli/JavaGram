package cn.csu.DataStructure;
/**
 * @fileName: ArrayTest.java
 * @author: 李岸 2010-12-7
 * @description:
 */
public class ArrayTest {
	
	public static void assignArray(){
		int[] scores;
		int[] exams;
		//exams=scores;		此处赋值错误，因为scores数组未初始化，未分配地址
		scores=new int[4];
		exams=scores;		//赋值成功，指向同一个内存地址，数组中的值为0
		System.out.println("未赋值：");
		printArray(exams,"exams");
		printArray(scores,"scores");
		for(int i=0;i<scores.length;i++){		//length并非一个方法
			scores[i]=i;
		}
		exams=scores;		
		//赋值成功，指向同一个内存地址，数组中有值，但对其中一个进行改变时，另一个值也会变化
		System.out.println("赋值后：");
		printArray(exams,"exams");
		printArray(scores,"scores");
		exams[2]=11;		//修改exams[2]，scores数组的值也会变化，因为两者指向同一个地址
		System.out.println("exams数组改变后：");
		printArray(exams,"exams");
		printArray(scores,"scores");
	}
	/*
	 * 通过Clone方法进行赋值
	 */
	public static void assignArrayByClone(){
		int[] scores;
		int[] exams;
		scores=new int[4];
		for(int i=0;i<scores.length;i++){		
			scores[i]=i;
		}
		exams=scores.clone();		
		//赋值成功，拷贝了一份scores数据，两者不指向同一个内存地址
		//因此副本与原数组相互之间没有影响，即当一个数组改变时，不会对另一个数组产生影响
		System.out.println("赋值后：");
		printArray(exams,"exams");
		printArray(scores,"scores");
		exams[2]=11;		//修改exams[2]，scores数组的值不会变化，因为两者指向的内存地址不同
		System.out.println("exams数组改变后：");
		printArray(exams,"exams");
		printArray(scores,"scores");
		scores[0]=99;
		System.out.println("scores数组改变后：");
		printArray(exams,"exams");
		printArray(scores,"scores");
	}
	
	public static void printArray(int[] arr,String arrName){
		System.out.println(arrName);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		assignArray();
		System.out.println("--------------------------");
		assignArrayByClone();
	}

}
