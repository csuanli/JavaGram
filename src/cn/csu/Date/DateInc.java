package cn.csu.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获得任意时间的下一天时间
 */
public class DateInc {

	public static void main(String[] args) {
		Date dat1=new Date();
		long datNum=dat1.getTime();
		long datNumNew=datNum+24*60*60*1000;		//增加一天的毫秒数
		Date dat2=new Date(datNumNew);
		SimpleDateFormat sdf=new SimpleDateFormat("线程 hhmmss");
		String datStr1=sdf.format(dat1);
		String datStr2=sdf.format(dat2);
		System.out.println(datStr1+" \n"+datStr2);
	}

}
