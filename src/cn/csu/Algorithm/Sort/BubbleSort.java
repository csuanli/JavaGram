package cn.csu.Algorithm.Sort;

/**
 * 冒泡排序
 * 思路1：从后往前比较，小的往上升
 * 思路2：从前往后比较，将大的往下沉
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr={5,11,6,2,5,4,1};
		sort2(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//思路1：把小的往上浮
	public static void sort(int[] arr){
		int len=arr.length;
		int temp=0;		//临时变量
		for(int i=0;i<len;i++){
			for(int j=len-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}
	
	//思路2：把大的往下沉
	public static void sort2(int[] arr){
		int len=arr.length;
		int temp=0;
		for(int i=0;i<len;i++){
			for(int j=0;j<len-i-1;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

}
