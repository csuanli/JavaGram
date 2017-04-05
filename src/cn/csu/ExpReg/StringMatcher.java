/**************************************************************************************** 
 Copyright © 2014-2018 Changsha ZTEsoft Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package cn.csu.ExpReg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: 匹配五个单词中的一个 <br>
 * 
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2016-1-11 <br>
 * @since V8 <br>
 * @see cn.csu.ExpReg <br>
 */

public class StringMatcher {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^C001$|^SYCPU$|^CDCPU$|^LSYCPU$|^LSYSCP$");
        String attrCode = "LSYCPsdU";
        Matcher m = p.matcher(attrCode);
        if (m.find()) {
            System.out.println(attrCode);
        }
        else {
            System.out.println("failed");
        }
    }
}
