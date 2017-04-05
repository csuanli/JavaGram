package cn.csu.ExpReg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计代码函数小程序
 * @author Li an
 * Apr 10, 2011
 */
public class CodeCounter {
	private static int codeLine=0;
	private static int whiteLine=0;
	private static int commentLine=0;
	
	public static void main(String[] args) {
			File file=new File("E:\\aa");
			List<File> fileList=new ArrayList<File>();
			fileList=listFile(file, fileList);
			for(File f:fileList){
				parse(f);
			}
			System.out.println("codeLine:"+codeLine);
			System.out.println("whiteLine:"+whiteLine);
			System.out.println("commentLine:"+commentLine);
	}
	/**
	 * 遍历后缀名为.java的文件
	 *@parm 
	 *@return
	 */
	public static List<File> listFile(File file,List<File> fileList){		
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isDirectory()){
				listFile(f,fileList);
			}else if(f.getName().matches(".*\\.java$")){	//只添加java文件
				fileList.add(f);
			}
		}
		return fileList;
	}
	/**
	 * 分析文件中包含的注释，代码，空白函数
	 *@parm 
	 *@return
	 */
	public static void parse(File file){
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			boolean comment=false;
			String str=null;
			while((str=br.readLine())!=null){
				str=str.trim();	
				if(str.startsWith("/*")&&!str.endsWith("*/")){
					commentLine++;
					comment=true;										
				}else if(str.startsWith("/*")&&str.endsWith("*/")){
					commentLine++;
				}else if(str.matches("^[\\s]*$")){		//空白行,z注意readline不会读取回车
					whiteLine++;
				}else if(true==comment){
					commentLine++;
					if(str.endsWith("*/")){
						comment=false;
					}
				}else if(str.startsWith("//")){
					commentLine++;
				}else{
					codeLine++;
				}
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
