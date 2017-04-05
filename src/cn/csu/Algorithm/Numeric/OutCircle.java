package cn.csu.Algorithm.Numeric;

import java.util.ArrayList;
import java.util.List;

/**
 * 出圈算法
 * 50个人围成一圈数到3和3的倍数时出圈，问剩下的人是谁，原来的位置是？
 *
 */
public class OutCircle {

	public static void main(String[] args) {
		System.out.println("最后一个出圈的人是："+localCircle(50, 3));
	}
	
	//total个人中，以div的倍数出圈
	public static int localCircle(int total, int div){
		List<Integer> circle=new ArrayList<Integer>();
		for(int i=0;i<total;i++){		//初始化人圈
			circle.add(new Integer(i+1));
		}
		int index=-1;		//初始化为-1，保证从第一个开始数数
		while(circle.size()>1){		//当只有一个人时返回结果
			index=(index+div)%circle.size();	//如果下标超过了圈的人数，则取余
			circle.remove(index--);
		}
		return circle.get(0);
		
	}

}
