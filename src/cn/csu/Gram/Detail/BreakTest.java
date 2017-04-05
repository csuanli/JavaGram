/**
 * 
 */
package cn.csu.Gram.Detail;

/**
 * 测试break语句跳出多重循环
 * 注意break只跳出一层当前循环体，不能跳出多层循环。
 * 如果需要跳出多层，则修改外层循环条件变量。
 * @author 李岸
 *
 */
public class BreakTest {
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println("外层循环："+i);
			for(int j=0;j<10;j++){
				System.out.println("里层循环："+j);
				if(j==5)
				{
					//i=10;//设置跳出外层循环
					break;
				}
			}
		}
	}

}
