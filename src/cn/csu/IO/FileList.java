package cn.csu.IO;

import java.io.File;

/**
 * @file FileList.java
 * @author 李岸
 * @version 1.0
 * @since Apr 24, 2010
 */
public class FileList {

	/**
	 * @遍历文件
	 */
	public static void main(String[] args) {
		File fDir=new File(File.separator);
		System.out.println(fDir.getAbsolutePath());
		String strFile="LAworkspace"+File.separator+"JavaGram"+File.separator+"src"
		+File.separator+"cn"+File.separator+"csu"+File.separator+"io";
		File f=new File(fDir,strFile);
		String[] names=f.list();
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
	}
}
