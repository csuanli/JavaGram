package cn.csu.IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class Redirect {

	/**
	 * 输出流使用装饰类的示例
	 */
	public static void main(String[] args) {
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		PrintStream ps=null;
		try {
			fos = new FileOutputStream("2.txt",true);	//true表示吧数据追加到数据的末尾
			bos=new BufferedOutputStream(fos,1024);	//增加缓冲功能
			ps=new PrintStream(bos,true);	//true表示自动flush
			//重定向System.out到该文件
			System.setOut(ps);
			System.out.println("This is third test");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ps.close();			
		}		
	}

}
