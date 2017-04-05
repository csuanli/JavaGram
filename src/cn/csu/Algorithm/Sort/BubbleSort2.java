package cn.csu.Algorithm.Sort;

/**
 * @instruction 冒泡排序
 * 起始顺序：9，2，4，6
 * 9和2比较，交换（2946）；9和4比较，交换（2496）；
 * 9和6比较，交换（2469）；  
 * @author 李岸
 * @version 1.0
 * @since Feb 26, 2011
 */
public class BubbleSort2 {
	/**
	 *冒泡排序
	 */
	public static int[] bubble(int array[],int n){
		int i;
		boolean flag;
		for(i=n-1,flag=true;i>=1&&flag;--i){
			flag=false;
			for(int j=0;j<i;++j){
				if(array[j]>array[j+1]){
					//交换：基本操作
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					//设置标志位
					flag=true;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array={9,2,4,6};
		int len=array.length;
		array=BubbleSort2.bubble(array, len);
		for(int i=0;i<len;++i){
			System.out.println(array[i]);
		}
	}
}

