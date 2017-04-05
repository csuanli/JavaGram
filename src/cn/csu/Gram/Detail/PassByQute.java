package cn.csu.Gram.Detail;
/**
 * 对象类型一般传的是引用
 * String类型的内容时不能更改的：public final class String
 * 参数传递时拷贝一份值生成新的String对象，原对象不变
 */
public class PassByQute {
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer("hello");
		changeSB(str);				//传引用，指向原对象
		System.out.println(str);
	
		String str2="hello";
		changeStr(str2);
		System.out.println(str2);
		
		String str3=new String("hello");
		changeStr(str3);
		System.out.println(str2);
		
		String str4="hello";
		str4.toUpperCase();
		System.out.println(str4);
		
		int x=3,y=4;
		swap(x, y);								//传值是将值拷贝一份到内存，并不会对原值有影响
		System.out.println("x="+x+"\ty="+y);
	}
	
	public static void changeSB(StringBuffer str){
		str.append(" world!");
	}
	
	public static void changeStr(String str2){
		str2="world";
	}
	
	public static void swap(int x,int y){
		int temp=x;
		x=y;
		y=temp;
	}
}