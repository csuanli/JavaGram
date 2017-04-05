package cn.redis;

import redis.clients.jedis.Jedis;

/** 
 * Description: <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2016-2-26 <br>
 * @since V8 <br>
 * @see cn.redis <br>
 */

public class RankingList {
    
    private static final String RANK_LIST = "RankList";

    /**
     * Description: <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.zadd(RANK_LIST, 90, "lian");
        jedis.zadd(RANK_LIST, 40, "leo");
        jedis.zadd(RANK_LIST, 30, "a");
        jedis.zadd(RANK_LIST, 78, "b");
        jedis.zadd(RANK_LIST, 89, "e");
        jedis.zadd(RANK_LIST, 99, "cindy");
       
        
        System.out.println(jedis.zrangeWithScores(RANK_LIST, 0, 6)); 
        
    }

}
