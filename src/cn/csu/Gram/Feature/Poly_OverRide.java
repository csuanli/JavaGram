package cn.csu.Gram.Feature;

/**
 * 重载可以改变返回值，但并不能只有返回值不同，而其他参数完全一样
 * 重载可以方法的参数个数，类型不同，而不能参数相同，返回值不同
 * @author Lenovo
 *
 */

/**
 * 方式一：通常情况下是不允许返回值不同的重写，如下
 */
/**
class Super{
	void f(){
		
	}
}
class Sub extends Super{
	int f(){
		return 1;
	}
}
*/
/**
 * 方式二：但是有办法可以不同（表面上不同）。比如
 * 
 * 实际Wheat是Grain的子类，即返回值都为Grain类。
 * 这个是JAVA1.5后引入的一个概念：协变返回类型 
 */
class Grain{
	public String toString(){
		return "Grain";
	}
}
class Wheat extends Grain{
	public String toString(){
		return "Wheat";
	}
}
class Mill{
	Grain process(){//注意返回值
		return new Grain();
	}
}
class WheatMill extends Mill{
	Wheat process(){//注意返回值
		return new Wheat();
	}
}

public class Poly_OverRide {
	
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);
		
		m = new WheatMill();
		g = m.process();
		
		System.out.println(g);
	}

}
