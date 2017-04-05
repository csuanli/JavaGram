package cn.csu.Random;

public class MathRandomTest {

    /**
     * Description: <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        // Math.random()产生的随机数是0-1之间的一个double
        double num = Math.random();
        System.out.println(num);
        System.out.println(Math.round(num * 100) % 100);
    }

}
