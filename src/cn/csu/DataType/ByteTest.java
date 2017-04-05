package cn.csu.DataType;

/**
 * @file ByteTest.java
 * @author 李岸
 * @version 1.0
 * @since Apr 9, 2010
 */
public class ByteTest {
	public static void main(String agrs[]){
		byte b=-128;		//byte 分正负型，-128到127
		System.out.println("size of Byte"+b);
		while(++b>0)
		System.out.println("--------"+b);
		System.out.println("end");
	}
}
