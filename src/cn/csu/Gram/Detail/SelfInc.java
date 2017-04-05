package cn.csu.Gram.Detail;

/**
 * 考察i++，++i用法
 * 以下程序输出是多少？
 * @author csuanli
 *
 */
public class SelfInc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i=0;
		i=i++ + ++i;	//0+2 
		System.out.println("i="+i);
		
		int j=0;
		j=++j + j++ + j++ + j++;	//1+1+2+3
		System.out.println("j="+j);
		
		int k=0;
		k=k++ + k++ + k++ + ++k;	//0+1+2+4 
		//其中k++ 0，在k++ k还是0，补前面的++，变为1；在k++,k还是1，补加前面的++变为2；最后++k 3补加++,变为4；
		System.out.println("k="+k);

	}

}
