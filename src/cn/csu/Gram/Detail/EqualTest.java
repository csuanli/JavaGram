/**
 * 
 */
package cn.csu.Gram.Detail;

/**
 * equal:比较对象值是否相等
 * ==:比较基本数据类型时，比较值是否相等，而比较引用类型时比较引用地址是否相等，即是否指向同一个对象。
 * @李岸
 *
 */
public class EqualTest {

	public static void main(String[] args) {
		String a="abc";
		String b="abc";
		String c=new String("abc");
		String d=new String("abc");
		System.out.println("a==b "+(a==b));
		System.out.println("a==c "+(a==c));
		System.out.println("a.equal(b) "+(a.equals(b)));
		System.out.println("c==d "+(c.equals(d)));
	}

}
