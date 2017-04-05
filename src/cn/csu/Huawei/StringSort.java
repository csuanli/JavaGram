package cn.csu.Huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSort {
    private List<String> words = new ArrayList<String>();

    public void getWords(String test_str) {
        Pattern p = Pattern.compile("[a-zA-Z]{2,}+");
        Matcher m = p.matcher(test_str);
        while (m.find()) {
            String tmp_str = m.group();
            if (check(tmp_str))
                words.add(getindex(tmp_str),tmp_str);
        }
    }

    private boolean check(String tmp_str) {
        if (words.contains(tmp_str)) {
            return false;
        } else {
            return true;
        }
    }

    private int getindex(String tmp_str){
        int tmp_length = tmp_str.length();
        int words_length = words.size();
        if(words_length==0){
            return 0;
        }
        else{
            for(int i =0;i<words_length;i++){
                if(tmp_length >= words.get(i).length()){
                    continue;
                }else{
                    return i;
                }
                
            }
            return words_length;
        }
    }
    
    private String newString() {
        String newString = "";
        
        for(int i =0;i<words.size();i++){
            if(i!= words.size()-1)
                newString += words.get(i)+" ";
            else
                newString += words.get(i);
        }
        
        return newString;
    }

    public static void main(String[] args) {
        StringSort ss = new StringSort();
        ss.getWords("hello12dd21 we / ;dw");
        System.out.println(ss.newString());
    }
}
