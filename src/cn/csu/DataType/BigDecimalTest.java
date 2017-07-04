/**************************************************************************************** 
 Copyright © 2014-2018 Changsha ZTEsoft Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package cn.csu.DataType;

import java.math.BigDecimal;

/** 
 * Description: <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8 <br>
 * @see cn.csu.DataType <br>
 */

public class BigDecimalTest {

    public static void main(String[] args) {
        float f1 = Float.parseFloat("21464148");
        float f2 = (float) (Math.round(f1 * 100)) / 100;
        float f3 = 10;
        float f4 = f2+f3;
        System.out.println(f1 + "   " + f2 + "   " + "   " + f3 +"    " + Float.toString(f4));
        
        
        BigDecimal b1 = new BigDecimal("21464148");
        BigDecimal b2 = new BigDecimal("10");
        BigDecimal b3 = b1.add(b2);
        System.out.println(b3.setScale(2).toString());
        
        BigDecimal a1 = new BigDecimal("0.0");
        System.out.println(a1.setScale(2).toString());
    }

}
