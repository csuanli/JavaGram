package cn.csu.Algorithm.Sort;

/**
 * 折半插入排序
 * 在一个有序序列中，插入一个新的元素a，将a与序列的最后一个元素比较，如果a大，则直接插后面，小则序列后移
 * a与前一个元素比较，知道找到合适的位置，插入a
 * @author Li an
 * Apr 21, 2011
 */
public class BInsertSort {

	public static void main(String[] args) {
		int[] arr={46,38,65,97,76,13,27,49};
		int[] result=sort(arr);
		for(int i:result){
			System.out.print(i+"  ");
		}
	}
	
	public static int[] sort(int[] arr){
		int low,high,j,m;
		for(int i=1;i<arr.length;i++){	//一个值的时候，序列显然是有序的，因此从下标从1开始插入
			int temp=arr[i];	//暂存需插入的值
			low=0;				//设定low、high指针
			high=i-1;
			//进行折半查找，获得插入位置，high>low时获得查找结果
			while(low<=high){	
				m=(low+high)/2;
				if(temp<arr[m])
					high=m-1;
				else
					low=m+1;
			}
			//移动元素位置
			for(j=i-1;j>=0&&j>=high+1;--j){		//将i-1到插入前位置的数据后移，j>=0防止数组越界
				arr[j+1]=arr[j];
			}
			arr[high+1]=temp;		//插入位置high+1		
		}
		return arr;
	}
}
