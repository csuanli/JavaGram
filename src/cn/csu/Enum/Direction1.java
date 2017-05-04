package cn.csu.Enum;

/**
 * Description: 推荐的枚举方式，绑定固定的序列值 <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017-5-10 <br>
 * @since V8 <br>
 * @see cn.csu.Enum <br>
 */
public enum Direction1 {
    UP(1), DOWN(2), LEFT(3), RIGHT(4);

    private final int directNum;

    Direction1(int size) {
        this.directNum = size;
    }

    public int numberOfDirection() {
        return directNum;
    }
}
