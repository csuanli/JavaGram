package cn.csu.Gram.Detail;

import java.text.NumberFormat;

public class RoundTest {
	/**
	 * Math.ceil()向上取整
	 * Math.floor()向下取整
	 * Math.round()函数四舍五入==Math.floor(x+0.5)
	 */
	public static void main(String[] args) {
		//Math.ceil()向上取整
		System.out.println("Math.ceil(11.1)="+Math.ceil(11.1));
		System.out.println("Math.ceil(-11.6)="+Math.ceil(-11.6));
		//Math.floor()向下取整
		System.out.println("Math.floor(11.1)="+Math.floor(11.1));
		System.out.println("Math.floor(-11.6)="+Math.floor(-11.6));
		//Math.round()函数四舍五入==Math.floor(x+0.5)
		System.out.println("Math.round(11.1)="+Math.round(11.1)+
				" newRound(11.1):"+newRound(11.1));
		System.out.println("Math.round(11.5)="+Math.round(11.5)+
				" newRound(11.5):"+newRound(11.5));
		System.out.println("Math.round(-11.5)="+Math.round(-11.5)+
				" newRound(-11.5):"+newRound(-11.5));
		System.out.println("Math.round(-11.1)="+Math.round(-11.1)+
				" newRound(-11.1):"+newRound(-11.1));
		System.out.println("Math.round(-11.6)="+Math.round(-11.6)+
				" newRound(-11.6):"+newRound(-11.6));
		
		double d=1.11102;
		System.out.println(Math.round(d*1000/1000.0));
	}
	
	public static double newRound(double x){
		return Math.floor(x+0.5);
	}

}
