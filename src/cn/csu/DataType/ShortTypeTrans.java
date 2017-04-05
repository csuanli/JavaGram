package cn.csu.DataType;

public class ShortTypeTrans {

	/**
	 * 关于short类型的强制转换问题
	 * short: 16
	 * int:	32
	 * 因此short+int转换为int类型
	 */
	public static void main(String[] args) {
		//p1: s1+1运算结果为int类型，因此编译出错需要强制类型转换
		short s1=1;
		//s1=s1+1;	//错

		//p2: 可以正确编译
		short s2=1;
		s2+=3;		//JVM内部实现不同，是运算符重载:
					//简单赋值运算和复合赋值运算的最大差别就在于：复合赋值运算符会自动地将运算结果转型为其左操作数的类型！
		
		short s3=1;
		s3+=32767;	//由于转换为做操作符，而32767+1超出short类型将溢出
		
		
		System.out.println("Short.MAX_VALUE="+Short.MAX_VALUE+"  Integer.MAX_VALUE"+Integer.MAX_VALUE);
		System.out.println("未溢出情况："+s2);
		System.out.println("溢出情况："+s3);
	}

}
