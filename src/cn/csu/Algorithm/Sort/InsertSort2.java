package cn.csu.Algorithm.Sort;

/**
 * 直接插入排序
 * 在一个有序序列中，插入一个新的元素a，将a与序列的最后一个元素比较，如果a大，则直接插后面，小则序列后移
 * a与前一个元素比较，知道找到合适的位置，插入a
 * @author Li an
 * Apr 21, 2011
 */
public class InsertSort2 {

	public static void main(String[] args) {
		int[] arr={46,38,65,97,76,13,27,49};
		int[] result=sort(arr);
		for(int i:result){
			System.out.print(i+"  ");
		}
	}
	
	public static int[] sort(int[] arr){
		int j;
		for(int i=1;i<arr.length;i++){	//一个值的时候，序列显然是有序的，因此从下标从1开始插入
			if(arr[i]<arr[i-1]){	//如果插入的值，小于有序序列的第一个值，则需要进行插入操作，否则直接插在有序序列后面即可
				int temp=arr[i];	//暂存需插入的值
				arr[i]=arr[i-1];	//由于arr[i]<arr[i-1],所以arr[i]应该插在arr[i-1]之后,所以进行后移操作				
				for(j=i-2;j>=0&&temp<arr[j];--j){	//从i-2开始，如果插入的值比arr[j]，则后移arr[j],其中j>=0防止数组越界
					arr[j+1]=arr[j];	//从i-2的位置开始后移
				}
				arr[j+1]=temp;	//当temp<arr[j]不符合条件，说明temp应该插在j之后，即j+1位置
			}
		}
		return arr;
	}
}