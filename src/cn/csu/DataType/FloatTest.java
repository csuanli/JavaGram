package cn.csu.DataType;

import java.util.List;

/**
 * 金山笔试
 * float，int赋初值问题
 * @author user
 */
public class FloatTest {
	public static void main(String[] args) {
		//1:float类型赋值必须加f后缀，double不必须加d
		float f=3.15f;	//必须加f	float f1=3.5;	//erro
		double d=3.11;	//不是必须加d	
		//int i=10.0;	//erro 强制转换 10.0为double类型
		//boolean b=null;	//erro错误	布尔变量只能赋值为true、false
		//2:复合表达式运算
		int i=3;
		i+=i-=i*i;		//相当于 i=i+(i-i*i);
		System.out.println(i);
		//3:单精度和双精度类型，通过自定义方式确定精度
		float a=0.34f,b=0.34000011f;
		//double a=0.34,b=0.340000000000000001;
		if(a==b){
			System.out.println("a==b");
		}
		if(isEqual(a, b)){
			System.out.println("isEqual	a==b");
		}
		
		float f1 = 58635.1235f;//单精度数字有效位是7位
        double d1 = 15210.2300356985412023689;//双精度数字有效位是16位
        System.out.println(f1);
        System.out.println(d1);
        // 4:小数点精确值
        System.out.println("-------4:小数点精确值--------");
        float c = 123.12f;
        float c1 = (float) (Math.round(c * 100)) / 100;
        System.out.println(c1);
	}
	
	public static boolean isEqual(float a,float b){
		if(a-b>-0.000000001&&a-b<0.000000001){	//自定义精确度
			return true;
		}
		return false;
	}
}
