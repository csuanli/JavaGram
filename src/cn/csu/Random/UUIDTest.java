package cn.csu.Random;

import java.util.UUID;

public class UUIDTest {

    /**
     * Description: <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        for(int i = 0; i<20;i++){
            System.out.println(UUID.randomUUID());
        }
    }

}
