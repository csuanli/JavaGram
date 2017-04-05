/**************************************************************************************** 
 Copyright © 2014-2018 Changsha ZTEsoft Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package cn.csu.Method;

/** 
 * Description: 可变参数用法 <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2016-3-8 <br>
 * @since V8 <br>
 * @see cn.csu.Method <br>
 */

public class VarMethod {

    /**
     * Description: <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        getSum(1,2,3);
    }
    
    public static void getSum(int... args) {
        int sum = 0;
        if (0 != args.length) {
            for(int i = 0;i<args.length;i++){
                sum += args[i];
            }
        }
        System.out.println(sum);
    }

}
