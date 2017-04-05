package cn.csu.ExpReg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 一些常用匹配
 * @author Li an
 * Apr 10, 2011
 */
public class GeneralMatch {
	public static Pattern pattern;
	public static Matcher matcher;
	
	public static void main(String[] args) {
		/**
		 * 匹配e-mail地址
		 * 注意邮箱地址，只能验证合法性，要避免乱填可以写一个邮件发送验证程序
		 * 字符开头，中间可以有.- 
		 * “@”前后为字符 
		 * 问题..连着情况csu..anli@163.com.cn有问题
		 * 注意^是指一行的开头 $是指一行的结束，因此一行字符串的第一个字符不符，则整行都不匹配
		 */
		/**
		 * 版本1："[\\w][\\w[-.]]+\\w@\\w[\\w[-.]]+\\.[\\w]+"
		 * 未排除 csuan..li@163.com
		 */
		pattern=Pattern.compile("[\\w][\\w[-.]]+\\w@\\w[\\w[-.]]+\\.[\\w]+");
//		pattern=Pattern.compile("[\\w]\\w[-.]?\\w)+\\w@\\w[\\w[-.]]+\\.[\\w]+");
		matcher=pattern.matcher("csuasdf.sdnli@163.com.cn");
		System.out.println(matcher.matches());
		/**
		 * 手机号码
		 */
		pattern=Pattern.compile("^1(3[0-9]|5[036789]|8[89])\\d{8}");
		matcher=pattern.matcher("13874837553");
		System.out.println(matcher.matches());
	}

}
