package cn.csu.Algorithm.Numeric;

/**
 * 排列问题:全排列算法
 * @author Li an
 * Apr 19, 2011
 */
public class Permutation {

	public static void main(String[] args) {
		char[] buf={'a','b','c'};
		perm(buf,0,buf.length-1);
	}
	/**
	 * 排列算法
	 *@parm buf需要排列的字符序列
	 *@param start需排列的起点位置
	 *@param end需排列的终点位置
	 *@return
	 */
	public static void perm(char[] buf,int start,int end){
		//如果只对一个字母进行排列，则直接输出数组即可
		if(start==end){
			for(int i=0;i<end;i++){
				System.out.println(buf[i]);
			}
			System.out.println();
		}else{
			//否则，多个字母进行排列
			for(int i=start;i<=end;i++){
				//交换数组的第一个元素与后续元素
				char temp=buf[start];
				buf[start]=buf[i];
				buf[i]=temp;
				//递归
				perm(buf, start+1, end);
				//将交换后的数组还原
				temp=buf[start];
				buf[start]=buf[i];
				buf[i]=temp;
			}
		}
	}
}
