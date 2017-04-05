package cn.csu.Algorithm.Sort;

/**
 * 归并排序算法实现
 * @author user
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr={5,2,4,7,1,3,2,6};
		divide(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	//将分解后的数据两两合并
	public static void merge(int[] array,int p,int mid,int q){
		int n1=mid-p+1;
		int n2=q-mid;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		int k=0;
		for(int i=p;i<=mid;i++){
			L[k]=array[i];
			k++;
		}
		k=0;
		for(int j=mid+1;j<=q;j++){
			R[k]=array[j];
			k++;
		}
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		int i=0,j=0;
		for(int m=p;m<=q;m++){
			if(L[i]<R[j]){
				array[m]=L[i];
				i++;
			}else{
				array[m]=R[j];
				j++;
			}
		}
	}
	
	//如果数组长度大于一，则分为2份，对数组进行分治
	public static void divide(int[] array,int p,int q){
		if(p<q){
			int mid=(p+q)/2;
			divide(array, p, mid);
			divide(array, mid+1, q);
			merge(array, p,mid,q);
		}
	}

}
