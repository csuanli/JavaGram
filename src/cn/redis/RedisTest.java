package cn.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
public class RedisTest {
    
    private static final String STRING_KEY = "myKey";
    
    private static final String LIST_KEY = "listKey";
    
    private static final String HASH_KEY = "hashKey";
    
    private static final String SET_KEY = "setKey";

    public static void main(String[] args) {
        Jedis jedis = getConnection();
        System.out.println();
        
        // 清空库中所有数据
        jedis.flushDB();
        
        System.out.println("------------String Demo---------- ");
        typeStringDemo(jedis);
        System.out.println();
        
        System.out.println("------------List Demo---------- ");
        typeListDemo(jedis);
        System.out.println();
        
        System.out.println("------------Hash Demo---------- ");
        typeHashDemo(jedis);
        System.out.println();
        
        System.out.println("------------Set Demo---------- ");
        typeSetDemo(jedis);
        System.out.println();
        
        getAllKeys(jedis);
        
    }
    
    /**
     * Description: 获取redis连接<br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @return <br>
     */ 
    private static Jedis getConnection() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connect to server...");
        if ("PONG".equals(jedis.ping())) {
            System.out.println("Server is running...");
            return jedis;
        }
        throw new RuntimeException("Connect to redis server failed!");
    }

    /**
     * Description: <br>
     * 
     * @author li.an1 <br>
     * @taskId <br>
     * @param jedis <br>
     */
    private static void typeStringDemo(Jedis jedis) {
        String keyValue = "keyValue";
        System.out.println("set key : " + STRING_KEY + " value : " + keyValue);
        jedis.set(STRING_KEY, keyValue);
        System.out.println("Stored string in redis: " + jedis.get(STRING_KEY));
        
        jedis.set("count", "3");
        jedis.incr("count");
        System.out.println("count in redis: " + jedis.get("count"));
    }
    
    /**
     * Description: List类型存取示例<br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param jedis <br>
     */ 
    private static void typeListDemo(Jedis jedis) {
        jedis.lpush(LIST_KEY, "index1");
        jedis.lpush(LIST_KEY, "index2");
        jedis.lpush(LIST_KEY, "index3");
        
        // 移除压入的最后一个元素
        System.out.println("lpop : " + jedis.lpop(LIST_KEY));
        
        List<String> lists = jedis.lrange(LIST_KEY, 0, 10);
        for(String index : lists){
            System.out.println(index);
        }
    }
    
    /**
     * Description: List类型存取示例<br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param jedis <br>
     */ 
    private static void typeHashDemo(Jedis jedis) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name1", "hello");
        map.put("name2", "word");
        jedis.hmset(HASH_KEY, map);

        // 获取map中指定key值
        System.out.println("get fields : " + jedis.hmget(HASH_KEY, "name1", "name2"));
        
        // 获取整个map
        Map<String, String> targetMap = jedis.hgetAll(HASH_KEY);
        Iterator<Entry<String, String>> it = targetMap.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    
    /**
     * Description: List类型存取示例<br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param jedis <br>
     */ 
    private static void typeSetDemo(Jedis jedis) {
        jedis.sadd(SET_KEY, "set1");
        jedis.sadd(SET_KEY, "set2");
        jedis.sadd(SET_KEY, "set3");
        
        Set<String> sets = jedis.smembers(SET_KEY);
        for(String member : sets){
            System.out.println(member);
        }
    }

    /**
     * Description: 获取所有键值<br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @param jedis <br>
     */ 
    private static void getAllKeys(Jedis jedis) {
        Set<String> sets = jedis.keys("*");
        for (String single : sets) {
            System.out.println(single);
        }
//        Iterator<String> it = sets.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
    }

}
