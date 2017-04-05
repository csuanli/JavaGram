package cn.csu.IO;

import java.io.File;
import java.io.IOException;

/**
 * @file FileTest.java
 * @author 李岸
 * @version 1.0
 * @since Apr 24, 2010
 */
public class FileTest {

	public static void main(String[] args) throws IOException {
		File fDir=new File(File.separator);			//独立于系统的分隔符，此表示根（父）目录
		String strFile="workspace"+File.separator+"JavaBaseTest"+File.separator+"src"
		+File.separator+"cn"+File.separator+"csu"+File.separator+"io"+File.separator+"1.txt";
		//G:\workspace\JavaBaseTest\src\cn\csu\io
		File f=new File(fDir,strFile);
		f.createNewFile();
	}

}