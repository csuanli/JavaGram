package cn.csu.Gram.Detail;

/**
 * 输出j的值是多少？
 * @author csuanli
 *
 */
public class TempCache {
	/**
	 * Java采用了中间缓存机制，相当于
	 * temp=j;
	 * j=j+1;
	 * j=temp;
	 * 所以结果是0
	 */
	public static void main(String[] args) {
		int j=0;
		for(int i=0;i<100;i++){
			j=j++;
		}
		System.out.println(j);
	}
}
