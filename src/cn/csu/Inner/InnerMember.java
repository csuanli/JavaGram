package cn.csu.Inner;

/**
 * 成员内部类
 * 成员内部类要等外部类创建了对象以后才被加载到JVM中，它是属于外部类的某个实例
 * 成员类的构造方法，系统会默认为其加上一个外部类的参数以及一个外部类的成员变量，这是为了遵循现有外部类实例再有内部类实例的原则：
 * class Inner(Outter o){
 *     this.o=o;
 * }
 * @author Administrator
 *
 */
public class InnerMember {

	public static void main(String[] args) {
		Outter2 o=new Outter2();			//创建外部类
		Outter2.Inner2 oi=o.new Inner2();	//创建内部类
		oi.abc();
	}
	
}

class Outter2{
	public int var=1;
	private void def(){
		System.out.println("执行外部内的def()方法");
	}
	
	class Inner2{
		public void abc(){
			System.out.println("执行InnerMember内部类！"+var);
			def();
		}
	}
}