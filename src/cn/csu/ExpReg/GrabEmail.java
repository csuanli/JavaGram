package cn.csu.ExpReg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从网页文件中抓取Email地址
 * @author Li an
 * Apr 10, 2011
 */
public class GrabEmail {

	/**
	 * 注意^是指一行的开头 $是指一行的结束，因此一行字符串的第一个字符不符，则整行都不匹配
	 * "^[\\w][\\w[-.]]+\\w@\\w[\\w[-.]]+\\.[\\w]+"前面的^是错误的
	 *@parm 
	 *@return
	 */
	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("src/email.htm");
			BufferedReader br=new BufferedReader(fr);			
			String str=null;
			while((str=br.readLine())!=null){
				parse(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	/**
	 * 解析email地址
	 *@parm 
	 *@return
	 */
	public static void parse(String str){
		Pattern pattern=Pattern.compile("[\\w][\\w[-.]]+\\w@\\w[\\w[-.]]+\\.[\\w]+");
		Matcher matcher=pattern.matcher(str);
		while(matcher.find()){		
			System.out.println(matcher.group());
		}
	}
}
