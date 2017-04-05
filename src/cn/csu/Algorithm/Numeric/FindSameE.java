package cn.csu.Algorithm.Numeric;

/**
 * a[100]的数组，值为1-99，其中有两个数相同，找出其中两个相同的值
 * 解题思想：
 * 思路1：
 *   遍历数组，累加所有的和，减去1-99的和，记得要找的值
 * 思路2：
 * 	   选择第一个数，与后面的数比较，下的放前面，大的放后面，如果前面的个数大于第一个数的值，则重复值在前面
 *   如第一个数位30，若小于30的个数大于29，则说明重复值在30之前，同理，对前面部分进行处理
 * @file FindSameE.java
 * @author 李岸
 * @version 1.0
 * @since 2011-5-19
 */
public class FindSameE {
    /**
     * 以1-9为例
     */
	public static void main(String[] args) {
		int[] arr={1,3,5,4,7,8,9,6,2,5};
		int result=getSameE(arr);
		System.out.println(result);
		for(int i=0;i<arr.length;i++){
			if(result==arr[i]){
				System.out.println("重复元素的位置为：a["+i+"]");
			}
		}
	}
	
	public static int getSameE(int[] arr){
		int sum=0,num=0,len=arr.length;
		for(int i=0;i<len;i++){
			sum+=arr[i];
		}
		for(int j=1;j<len;j++){
			num+=j;
		}
		return sum-num;
	}
}
