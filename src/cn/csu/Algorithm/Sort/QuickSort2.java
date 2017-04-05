package cn.csu.Algorithm.Sort;

/**
 * 
 * @author Li an
 * Apr 22, 2011
 */
public class QuickSort2 {
	
	public static void main(String[] args) {
		int[] arr={49,38,65,97,76,13,27,49};
		Qsort(arr, 0, arr.length-1);
		for(int i:arr){
			System.out.print(i+"  ");
		}
	}
	
	public static void Qsort(int[] arr,int low,int high){
		if(low<high){
			int pivotloc=partition(arr, low, high);
			Qsort(arr, low, pivotloc-1);
			Qsort(arr, pivotloc+1,high);
		}
	}
	
	public static int partition(int[] arr,int low,int high){
		int temp=arr[low];	//暂存枢轴值
		int pivotkey=arr[low];	//比较枢轴值
		while(low<high){
			while(low<high&&arr[high]>=pivotkey) 	//将高端比枢轴小的移动到低端
				high--;
			arr[low]=arr[high];						//移动记录，并不必记录枢轴
			while(low<high&&arr[low]<=pivotkey)		//将低端比枢轴大的移动到高端
				low++;								
			arr[high]=arr[low];						//移动记录，并不必记录枢轴
		}		
		arr[low]=temp;	//记录枢轴，还原枢轴值
		return low;		//返回枢轴位置
	}
}

