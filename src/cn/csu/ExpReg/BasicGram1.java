package cn.csu.ExpReg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式基本语法 
 * @author Li an
 * Apr 10, 2011
 */
public class BasicGram1 {
	public static Pattern pattern;
	public static Matcher matcher;
	public static void main(String[] args) {
		/*
		 * 替换 将字符串中的基数java小写表示，偶数大写表示
		 */
		pattern=Pattern.compile("java",Pattern.CASE_INSENSITIVE);//忽略大小写
		matcher=pattern.matcher("hello Java,java ,Do you like JAva?  javA ，JAVA,so");
		StringBuffer buf=new StringBuffer();
		int i=0;
		while(matcher.find()){
			i++;
			if(i%2==0){
				matcher.appendReplacement(buf, "JAVA"); //替换当前找到的字串，放入buf中
			}else{
				matcher.appendReplacement(buf, "java");
			}
		}
		matcher.appendTail(buf);	//把最后未匹配部分添加上
		System.out.println("---------------------替换------------------");
		System.out.println(buf);
		
		/**
		 * 分组
		 * 查找三个数字带字母,并只将字母打印出来，则可以用（）分两组，以左小括号确定分组号序号
		 */
		pattern=Pattern.compile("(\\d{3})([a-z]+)");
		matcher=pattern.matcher("lia576-4245lain-587cindy-2154adfsd");
		System.out.println("----------------------分组---------------------");
		while(matcher.find()){
//			System.out.println(matcher.group());
//			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}
	}
}
