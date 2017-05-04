package cn.csu.Enum;

public class TestEnum {

    public static void main(String[] args) {
        // 不推荐的枚举方式，没有绑定序列值
        System.out.println(Direction.DOWN.ordinal());
        System.out.println(Direction.DOWN.numberOfDirection());
        // 推荐的枚举实现，绑定固定的序列值
        System.out.println(Direction1.DOWN.numberOfDirection());
    }

}
