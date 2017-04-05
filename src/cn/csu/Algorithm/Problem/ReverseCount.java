package cn.csu.Algorithm.Problem;

/**
 * 在数组中两个数字如果前面一个数字大于后面的都数字，则这两个数字组成一个逆序对
 * 输入一个数组，求出这个数组中的逆序对的总数
 * 法一：依次比较当前元素与后续元素逆序的个数，o(n的平方)
 * 法二：采用归并排序的思想，将数组分为长度为1的子数组进行合并，排序，并统计逆序对(尚有问题)
 * 参考剑指offer p189
 */
public class ReverseCount {

	public static void main(String[] args) {
		int[] arr={4,2,1,3};
		System.out.println(getCountByLoop(arr));
		System.out.println(getCountByMerge(arr));
	}
	
	//法一:双重遍历
	public static int getCountByLoop(int[] arr){
		int len=arr.length;
		int count=0;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(arr[i]>arr[j]){
					count++;
				}
			}
		}
		return count;
	}
	
	//法二：基于归并排序实现（排序有问题？）
	public static int getCountByMerge(int[] arr){
		if(arr==null){
			return 0;
		}
		int[] copy=new int[arr.length];
		for(int i=0;i<copy.length;i++){ 
			copy[i]=arr[i];
		}
		int num=inverseCountArr(arr, copy, 0, arr.length-1);
		return num;
	}
	
	public static int inverseCountArr(int[] arr,int[] copy,int start,int end){
		if(start==end){		//只有一个元素
			copy[start]=arr[start];
			return 0;
		}
		int count=0;
		//分治，把数组依次拆分
		int mid=(start+end)/2;
		//分成两部分后，分别对数组进行排序，比较两个有序数组最大值，注意arr,copy交换
		int left=inverseCountArr(copy, arr,start, start+mid);
		int right=inverseCountArr(copy, arr,start+mid+1, end);
		//前半段数字下标
		int indexL=start+mid;
		//后半段数字下标
		int indexR=end;
		//辅助数组下标
		int indexcopy=end;
		
		while(indexL>=start&&indexR>=start+mid+1){
			if(arr[indexL]>arr[indexR]){	//如果左边最大值，大于右边最大值，则逆序对为右边剩余数之和
				copy[indexcopy--]=arr[indexL--];
				count+=indexR-(start+mid+1)+1;
			}else{
				copy[indexcopy--]=arr[indexR--];
			}
		}
		for(;indexL>=start;--indexL){
			copy[indexcopy--]=arr[indexL];
		}
		for(;indexR>=start+mid+1;--indexR){
			copy[indexcopy--]=arr[indexR];
		}
		return left+right+count;
	}

}
