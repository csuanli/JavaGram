package cn.csu.Enum;

/**
 * Description: 不推荐的枚举使用，这种方式没有跟具体int值关联，顺序调换会导致值也变化 <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017-5-10 <br>
 * @since V8 <br>
 * @see cn.csu.Enum <br>
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    /**
     * Description: ordinal方法为枚举类型内置方法，返回枚举类型所在的位置int值 <br> 
     *  
     * @author li.an1 <br>
     * @taskId <br>
     * @return <br>
     */
    public int numberOfDirection() {
        return ordinal() + 1;
    }
    // UP(1), DOWN(2)
}
