package cn.csu.DataType;

/**
 *测试布尔变量是由几个字节表示
 *boolean byte：1字节
 *char:			2字节
 *short:		2字节
 *int:			4字节
 *long:			8字节
 *float:		4字节
 *double		8字节
 */
public class BooleanTest {

	public static void main(String[] args) {
		int i1=Byte.SIZE;
		int i2=Character.SIZE;
		int i3=Integer.SIZE;
		int i4=Long.SIZE;
		int i5 = Float.SIZE;
		int i6 = Double.SIZE;
		int i7 = Short.SIZE;
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
		System.out.println(i7);
	}

}
