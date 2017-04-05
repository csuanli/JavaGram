package cn.csu.Random;

public class TimeMilliTest {

    /**
     * Description: <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        // 这个方法返回一个从1970年1月1号0点0分0秒到目前的一个毫秒数，返回类型是long，
        // 我们可以拿他作为一个随机数，我们可以拿他对一些数取模，就可以把他限制在一个范围之内啦
        System.out.println(System.currentTimeMillis() % 1000);
    }

}
