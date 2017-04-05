package cn.csu.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectStream {

	public static void main(String[] args) {
		try {
			FileOutputStream fos=new FileOutputStream("3.txt");		//？？写入的文件中存在编码问题
			//通过对象序列化方式发送数据
			ObjectOutputStream oos=new ObjectOutputStream(fos);		
			oos.writeInt(123);
			oos.writeObject("Lian");
			oos.writeObject(new Date());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis=new FileInputStream("3.txt");
			//通过对象序列化方式接收数据
			ObjectInputStream ois=new ObjectInputStream(fis);
			int i=ois.readInt();
			String str=(String)ois.readObject();
			Date date=(Date)ois.readObject();
			System.out.println("int:"+i);
			System.out.println("String:"+str);
			System.out.println("Date:"+date);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}

}
