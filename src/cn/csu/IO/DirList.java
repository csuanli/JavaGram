package cn.csu.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @file DirList.java
 * @author 李岸
 * @version 1.0
 * @since Apr 22, 2010
 */
public class DirList {

	public static void main(String[] args) {
		File path=new File(".");
//		System.out.println(path.getAbsolutePath());
		String[] list;
		if(args.length==0)
			list=path.list();
		else
			list=path.list(new DirFiter1(args[0]));
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem:list)
			System.out.println(dirItem);
	}

}

class DirFiter1 implements FilenameFilter{
	private Pattern pattern;
	public DirFiter1(String regex){
		pattern=Pattern.compile(regex);
	}
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
