package cn.csu.Algorithm.Sort;

import cn.csu.Gram.Detail.SysoutTest;

/**
 * 折半插入排序：
 * 插入排序的进一步优化，减少了“比较”次数
 * 通过二分查找，找到对应的插入点之后，插入元素，然后往后移动元素
 * @李岸
 */
public class BInsertSort2 {

	public static void main(String[] args) {
		int[] arr={46,38,65,97,76,13,27,49};
		sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void sort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int temp=arr[i];	//带比较字符
			int low=0,high=i-1;
			while(low<=high){
				int m=(low+high)/2;
				if(temp<arr[m]){
					high=m-1;
				}else{
					low=m+1;
				}
			}
			for(int j=i;j>high+1;j--){
				arr[j]=arr[j-1];
			}
			arr[high+1]=temp;
		}
	}

}
