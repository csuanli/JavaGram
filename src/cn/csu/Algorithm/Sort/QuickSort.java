package cn.csu.Algorithm.Sort;
/**
 * 快速排序
 * 进行一趟快排划分，返回枢轴位置，设定i（左->右）遇到大于枢轴的，则交换到枢轴位置,
 * j(右->左)遇到小于枢轴的则交换到枢轴位置
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr={49,38,65,97,76,13,27,49};
		sort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
	
	//采用递归形式快速排序
	public static void sort(int[] arr,int low,int high){
		if(low<high){									//长度大于1时进行排序，否则已有序
			int pivotloc=partition(arr, low, high);		//一趟快速排序，将数组分为两部分，左边小于枢轴，右边大于枢轴
			sort(arr, low, pivotloc-1);					//对低字表快排
			sort(arr, pivotloc+1, high);				//对高字表快排
		}
	}
	
	//进行一趟快排划分，返回枢轴位置，设定i（左->右）遇到大于枢轴的，则交换到枢轴位置,j(右->左)遇到小于枢轴的则交换到枢轴位置
	public static int partition(int[] arr,int low,int high){
		int temp=arr[low];			//暂存枢轴值	此处应该暂存arr[low] 而不是arr[0]
		int pivotkey=arr[low];		//比较枢轴值
		while(low<high){
			while(low<high&&arr[high]>=pivotkey){
				high--;
			}
			arr[low]=arr[high];
			while(low<high&&arr[low]<=pivotkey){
				low++;
			}
			arr[high]=arr[low];
		}
		//当low==high时，扫描结束，获得枢轴位置
		arr[low]=temp;
		return low;
	}

}
