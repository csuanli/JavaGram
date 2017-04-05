/**
 * 
 */
package cn.csu.ExpReg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的基本语法
 * @name BasicGram.java
 * @author user
 * @version 1.0
 * @date Apr 10, 2011 
 */
public class BasicGram {
	public static Pattern pattern;
	public static Matcher matcher;
	
	public static void main(String[] args) {
		//true 匹配
		System.out.println("1,"+"a".matches("a"));	//true
		//false 
		System.out.println("2,"+"aa".matches("a"));	//false
		
		/**
		 * 认识 ？ + *
		 */
		//a? 0个或1个a
		System.out.print("3,"+"".matches("a?"));	//true
		System.out.print("  "+"a".matches("a?"));	//true
		System.out.println("  "+"aa".matches("a?"));//false
		//a+ 1个或多个a
		System.out.print("4,"+"a".matches("a+"));	//true
		System.out.println("  "+"".matches("a+"));	//false
		//a* 0个或多个a
		System.out.println("5,"+"aa".matches("a*")); //true
		
		/**
		 * 认识 Pattern, Matcher
		 */
		//先对正则表达式编译compile，再匹配matcher
		pattern=Pattern.compile("[1-2][0-9][0-9]"); //"\\d[1-2]\\d[0-9]\\d[0-9]"错误
		matcher=pattern.matcher("292");				//true
		System.out.print("6,"+matcher.matches());
		matcher=pattern.matcher("29a");				//false
		System.out.print("   "+matcher.matches());
		pattern=Pattern.compile("\\d[1-2]\\d[0-9]\\d[0-9]"); // \d+[1-2]+\d+[0-9]+\d+[0-9] 
		matcher=pattern.matcher("292");				//false
		System.out.print(" "+matcher.matches());
		matcher=pattern.matcher("829248");			//true
		System.out.println(" "+matcher.matches());

		//符合整数要求的ip地址
		pattern=Pattern.compile("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"); //1-3个数字.1-3个数字.1-3个数字.1-3个数字
		matcher=pattern.matcher("202.192.168.aa");	//false
		System.out.print("7,"+matcher.matches());
		matcher=pattern.matcher("202.192.168.1");	//true
		System.out.println("  "+matcher.matches());
		
		/**
		 * 范围 []不管里面多少，代表一个字符
		 */
		System.out.print("8,"+"a".matches("[abc]"));	//true a或b或c
		System.out.print("  "+"a".matches("[^abc]"));	//false 非abc字符
		System.out.print("  "+"e".matches("[a-zA-Z]"));	//true a-z或A-Z字符
		System.out.print("  "+"e".matches("[a-z|A-Z]"));	//true 同上
		System.out.print("  "+"Z".matches("[a-z[A-Z]]"));	//true 同上
		System.out.println("  "+"e".matches("[a-z&&[bcd]]"));	//false a-z且属于bcd
		
		/**
		 * 特殊字符 \s \w \d \
		 * \s代表空白字符[ \t\n\x0B\f\r]		\S代表非字符[a-zA-Z_0-9]
		 * \w代表字符[a-zA-Z_0-9]				\W代表非字符[a-zA-Z_0-9]
		 * \d代表数字[0-9]					\D代表非数字
		 * \本身
		 */
		System.out.print("9,"+"\n\f\r\t".matches("\\s{4}"));	//true 4个空白字符
		System.out.print("  "+" ".matches("\\S"));	//false 空格为空白字符
		System.out.print("  "+"a_5".matches("\\w{3}"));	//true 3个字符
		System.out.print("  "+"aad585#$%".matches("[a-z]+\\d+[#$%]{3}"));	//true 3个字符
		//true 匹配\本身，注意java中，两个\代表一个\,因此"\\\\"在正则表达式中代表"\\"，而正则表达式的"\\"代表一个"\"
		System.out.println("  "+"\\".matches("\\\\"));	//true 
		
		/**
		 * 边界处理 ^中括号中表示取反，在外面表示开头
		 * $表示结尾
		 */
		System.out.print("10,"+"_asds".matches("^[a-zA-Z_0-9][a-zA-Z]+s$"));	//true 以数字字母下划线开头，s结尾
		System.out.print("  "+"hello lian".matches("^h[el]{3}o\\b.*an$"));  //true 以h开头，\b字符边界，以an结尾
		System.out.println("  "+"hellolian".matches("^h[el]{3}o\\b.*an$"));  //false 以h开头，\b字符边界，以an结尾
		
		/**
		 * 匹配空白行
		 */
		System.out.println("11,"+"\n".matches("^\\s*\\n$"));	//以空白字符开始，中间为空白字符，以换行结尾
		
		/**
		 * matchers find lookingat
		 * 注意matches是全部进行匹配，会对find影响，因此find前需要reset
		 * find每次接在后面重新查找
		 * lookingat每次重头开始找
		 */
		pattern=Pattern.compile("\\d{3}");
		matcher=pattern.matcher("354-354856--aa--548-12");
		System.out.println("------------------matches、find、lookingat--------------------");
//		System.out.println(matcher.matches());
//		matcher.reset();
		//从下一个新的匹配位置开始,如354匹配，则下一次，354，再下一次856，再下一次548，
		System.out.println(matcher.find());
		System.out.println(matcher.start()+"-"+matcher.end());	//返回找到的起始位置和结束位置
		System.out.println(matcher.find());
		System.out.println(matcher.start()+"-"+matcher.end());	//返回找到的起始位置和结束位置
		System.out.println(matcher.find());
		System.out.println(matcher.start()+"-"+matcher.end());	//返回找到的起始位置和结束位置
		System.out.println(matcher.find());
		System.out.println(matcher.start()+"-"+matcher.end());	//返回找到的起始位置和结束位置
		System.out.println(matcher.find());
		
		//重头开始匹配
		/*System.out.println(matcher.lookingAt());
		System.out.println(matcher.lookingAt());
		System.out.println(matcher.lookingAt());
		System.out.println(matcher.lookingAt());
		System.out.println(matcher.lookingAt());*/
	
	}
}
