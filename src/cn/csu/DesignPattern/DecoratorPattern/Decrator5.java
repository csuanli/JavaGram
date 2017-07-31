package cn.csu.DesignPattern.DecoratorPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * Description: Java IO中的装饰模式应用 <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017年7月31日 <br>
 * @since V8 <br>
 * @see cn.csu.DesignPattern.DecoratorPattern <br>
 */
public class Decrator5 {
	public static void main(String[] args) throws Exception{
		//从文件里面读取一句中文
		FileInputStream fis = 
			new FileInputStream("1.txt");
		BufferedInputStream bis = 
			new BufferedInputStream(fis);
		byte[] buf=new byte[100];
		int len=bis.read(buf);                     // 注意该方法返回的是文件内容长度
		System.out.println(new String(buf,0,len));   //读出内容   
//		System.out.println(br.read());
	}

}
