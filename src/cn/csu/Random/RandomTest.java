/**************************************************************************************** 
 Copyright © 2014-2018 Changsha ZTEsoft Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package cn.csu.Random;

import java.util.Random;

/** 
 * Description: <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017-2-23 <br>
 * @since V8 <br>
 * @see cn.csu.Random <br>
 */
public class RandomTest {

    public static void main(String[] args) {
        // 此种方式将会返回随机的数字，每次运行结果不一样
        System.out.println("\n-----不带种子：此种方式将会返回随机的数字，每次运行结果不一样（实际种子为System.currentTimeMillis()）-----\n");
        Random ran = new Random();

        for(int i=0;i<50;i++){
            // 返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
            System.out.print(ran.nextInt() +" ");
        }
        
        // 返回一个伪随机数，它是从此随机数生成器的序列中取出的、在 0（包括）和指定值（不包括）之间均匀分布的 int值。
        for(int i=0;i<50;i++){
            System.out.print(ran.nextInt(100) + " ");
        }
        
        // 此种方式，无论程序运行多少次，返回结果都是一样的
        System.out.println("\n-----带种子:此种方式，无论程序运行多少次，返回结果都是一样的-----\n");
        Random ran1 = new Random(100);
        for (int i = 0; i < 20; i++) {
            System.out.print(ran1.nextInt(100)+" ");
        }
    }

}
