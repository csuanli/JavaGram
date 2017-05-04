package cn.csu.Gram.Detail;

/**
 * Description: 引用与传值演示 <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017-4-11 <br>
 * @since V8 <br>
 * @see cn.csu.Gram.Detail <br>
 */
public class QuoteTest {

    public static void main(String[] args) {
        // 传值
        method1();
        // 引用
        method2();
        method3();
    }
    
    private static void method1() {
        int i = 0;
        change1(i);
        System.out.println(i);
    }
    
    private static void change1(int x) {
        x = 1;
    }
    
    private static void method2() {
        StringBuffer sb = new StringBuffer("hello ");
        change2(sb);
        System.out.println(sb.toString());
    }
    
    private static void change2(StringBuffer sb) {
        sb.append("world!");
    }

    private static void method3() {
        // sb引用的内存块并没有发生变化，因此调用change3后，输出依然是hello
        StringBuffer sb = new StringBuffer("hello ");
        // change3函数，重新指向了新的内存块，且参数sb只是临时变量，可以是sb1,sb2。。。没有影响到原来的引用
        change3(sb);
        System.out.println(sb.toString());
    }
    
    private static void change3(StringBuffer sb) {
        sb = new StringBuffer("hi ");
        sb.append("world!");
        System.out.println("change3 inner : " + sb.toString());
    }
}
