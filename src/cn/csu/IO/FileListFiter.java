package cn.csu.IO;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @file FileList.java
 * @author 李岸
 * @version 1.0
 * @since Apr 24, 2010
 */
public class FileListFiter {

	/**
	 * @遍历文件list,利用文件过滤器，得到所需的文件
	 */
	public static void main(String[] args) {
		File fDir=new File(File.separator);		//根目录
		String strFile="workspace"+File.separator+"JavaBaseTest"+File.separator+"src"
		+File.separator+"cn"+File.separator+"csu"+File.separator+"io";
		File f=new File(fDir,strFile);
		String[] names=f.list(new FilenameFilter(){
			public boolean accept(File dir,String name){
				return name.indexOf(".java")!=-1;
			}
		});		
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
	}
}


