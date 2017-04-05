package cn.csu.IO;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @name SearchFile.java
 * @author 李岸
 * @version 1.0
 * @date Nov 12, 2010 
 */
public class SearchFile {

	private static int countFile=0;
	private static int countDir=0;
	
    /*
     * 递归查找包含关键字的文件
     * 文件过滤器：FileFilter，在文件拷贝、移动、删除和压缩时，指定多个文件类型、修改时间、大小限制、覆盖条件、
     * 是否包含子目录等条件进行过滤。
     */
	public static File[] searchFiles(File fold,final String keyword){
		File[] subFolders=fold.listFiles(new FileFilter(){		//运用内部匿名内获得文件
			public boolean accept(File pathname) {
				if(pathname.isFile()){
					countFile++;
				}else{
					countDir++;
				}
				if(pathname.isDirectory()||pathname.isFile()&&pathname.getName().contains(keyword)){
					return true;
				}
				return false;
			}			
		});
		List result=new ArrayList();	//声明一个集合
		int j=subFolders.length;
		for(int i=0;i<j;i++){
			if(subFolders[i].isFile()){
				result.add(subFolders[i]);
			}else{
				File[] foldresult=searchFiles(subFolders[i], keyword);					
				for(int h=0,k=foldresult.length;h<k;h++){
					result.add(foldresult[h]);
				}				
			}
		}
		File files[]=new File[result.size()];
		result.toArray(files);
		return files;
	}
	
	public static void main(String[] args) {
		File folder=new File("F:/workspace/JavaBaseTest");
		String keyword="txt";
		if(!folder.exists()){
			System.out.println("目录不存在！"+folder.getAbsolutePath());
			return;
		}
		File[] result=searchFiles(folder, keyword);
		int size=result.length;
		System.out.println(""+folder+""+keyword);
		System.out.println("查找了"+countFile+"文件以及"+countDir+"个目录。共找到"
				+size+"个符合条件的文件：");
		for(int i=0;i<size;i++){
			File file=result[i];
			System.out.println(file.getAbsolutePath()+"");//显示文件的绝对路径
		}
		
	}

}