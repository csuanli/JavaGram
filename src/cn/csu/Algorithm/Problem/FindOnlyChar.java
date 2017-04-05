package cn.csu.Algorithm.Problem;

/**
 * 在字符串中找出第一个只出现一次的字符，如输入“abaccdeff”,
 * 则输出‘b’.
 * 法一：每个字符与其它字符比较，如果都不相同则只出现1次。o(n平方)
 * 法二：利用hash表，记录每个词出现的频率。 o(n);
 */
public class FindOnlyChar {

	public static void main(String[] args) {
		char[] arr="aaccbddbeetffxx".toCharArray();
		System.out.println(getOnlyCharByHash(arr));
		System.out.println(getOnlyCharByLoop(arr));
	}
	//思路一：通过两层循环实现
	public static char getOnlyCharByLoop(char[] arr){
		int len=arr.length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(i==j)
					continue;
				if(arr[i]==arr[j]){
					break;
				}else if(arr[i]!=arr[j]&&j==len-1){
					return arr[i];
				}
			}
		}
		return ' ';
	}
	
	//思路二：hash表实现
	public static char getOnlyCharByHash(char[] arr){
		int[] hashTable=new int[256];
		for(int i=0;i<256;i++){			//初始化hash表
			hashTable[i]=0;
		}
		for(int i=0;i<arr.length;i++){	//记录每个字符出现次数
			hashTable[arr[i]]++;
		}
		for(int i=0;i<arr.length;i++){	//扫描第一个出现一次的的字符返回
			if(hashTable[arr[i]]==1)
				return arr[i];
		}
		return ' ';
	}
	

}
