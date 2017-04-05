package cn.csu.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    static boolean isHuiWen(String str) {
        int low = 0, up = str.length() - 1;
        while (low < up) {
            if ((str.charAt(low)) != str.charAt(up))
                return false;
            else {
                low++;
                up--;
            }
        }
        return true;
    }

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入一个字符串：");
        String s = br.readLine();
        if (isHuiWen(s))
            System.out.println("输入的字符串\t" + s + "\t是回文的");
        else
            System.out.println("输入的字符串\t" + s + "\t不是回文的");
    }
}