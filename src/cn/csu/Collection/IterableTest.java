/**************************************************************************************** 
 Copyright © 2014-2018 Changsha ZTEsoft Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package cn.csu.Collection;

import java.util.Iterator;
import java.util.List;

/** 
 * Description: <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2016-3-8 <br>
 * @since V8 <br>
 * @see cn.csu.Collection <br>
 */

public class IterableTest {

    /**
     * Description: <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<String>();
        for (String str : myCollection) {

        }
    }

}

class MyCollection<T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    
}
