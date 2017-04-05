package cn.csu.Algorithm.Sort;

/**
 * 插入排序
 * 两重循环实现，认为数组第一个为有序，从第二个元素开始遍历（一重循环），与前面元素比较（二重循环），
 * 如果大于前面的元素，则插入，否则则元素后移，知道遇到小于它的元素其后插入，如果到达第一元素则插入
 * 到头部
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr={5,11,6,2,5,4,1};
		sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void sort(int[] arr){
		int len=arr.length;
		for(int i=1;i<len;i++){
			int num=arr[i];
			for(int j=i-1;j>=0;j--){
				if(num>arr[j]){	//当遇到的元素小于num时，插入num
					arr[j+1]=num;
					j=0;
				}else{
					arr[j+1]=arr[j];
					if(j==0){		//当比较到第一个元素，比第一个元素下则插入到第一个位置
						arr[j]=num;
					}
				}
			}
		}
	}
}
