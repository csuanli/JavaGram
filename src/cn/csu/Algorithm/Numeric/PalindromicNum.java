package cn.csu.Algorithm.Numeric;

/**
 * 回文数问题
 * 方式1：利用字符串StringBuffer进行倒转
 * 方式2：利用数字取余倒转
 */
public class PalindromicNum {

	public static void main(String[] args) {
		for(int i=10;i<1000000;i++){
			if(isPalind2(i)){
				System.out.println(i);
			}	
		}
	}
	//方式1：利用字符串StringBuffer进行倒转
	public static boolean isPalind1(int num){
		String str=String.valueOf(num);
		StringBuffer sb=new StringBuffer(str);
		String newStr=sb.reverse().toString();
		if(str.equals(newStr)){
			return true;
		}
		return false;
	}
	
	//方式2：利用数字取余倒转
	public static boolean isPalind2(int num){
		int newVal=0;
		int oldVal=num;
		while(num>0){
			newVal=newVal*10+num%10;
			num=num/10;
		}
		if(newVal==oldVal){
			return true;	
		}
		return false;
		
	}

}
