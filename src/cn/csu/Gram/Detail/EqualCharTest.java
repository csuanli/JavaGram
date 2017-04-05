package cn.csu.Gram.Detail;

/**
 * equals方法来自object,任务==，没有进行内部实现判断值相等
 * 而在String内中，String重写了equals方法，实现了值相等
 * @author csuanli
 *
 */
public class EqualCharTest {
	
	public static void main(String[] args) {
		String str="hello";
		char c[]={'h','e','l','l','o'};
		char ch[]=str.toCharArray();	//字符串转换为char
		
		System.out.println(c+"  "+ch);	//不同的对象
		
		if(c==ch){						//false
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		if(c.equals(ch)){		//false equals方法来自object,任务==，没有进行内部实现判断值相等
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		String s=new String(c);		//char转换为字符串
		
		if(s==str){					//false		不同的对象
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		if(s.equals(str)){			//true		相等的值，String重写了equals方法，实现了值相等
			System.out.println("true");		
		}else{
			System.out.println("false");
		}
	}
	
}
