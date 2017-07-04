package cn.csu.DesignPattern.PrototypePattern;

/** 
 * Description: 原型模式浅克隆实现 <br> 
 *  
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017年7月31日 <br>
 * @since V8 <br>
 * @see cn.csu.DesignPattern.PrototypePattern <br>
 */

public class Prototype1 {
    public static void main(String[] args) throws Exception{
	Word3 w1 = new Word3("好","黑体","蓝色",50);
	Word3 w2 = w1.copy();//克隆
	
	System.out.println("W1的内容是:" + w1.content);
	System.out.println("W2的内容是:" + w2.content);
	w1.content = "坏";
	System.out.println("W2的内容是:" + w2.content);					
	}
}

class Word3 implements java.lang.Cloneable {// 可以被克隆
    String content;
    String fontName;
    String fontColor;
    int fontSize;

    public Word3(String content, String fontName, String fontColor, int fontSize) {
	this.content = content;
	this.fontName = fontName;
	this.fontColor = fontColor;
	this.fontSize = fontSize;
    }

    /*
     * 要点：定义一个方法，通过clone来获得对象拷贝 这是业界推荐的方法。但是该方法隐患，只能拷贝值对象，无法 拷贝引用对象
     */
    public Word3 copy() throws Exception {
	return (Word3) this.clone();// 快速克隆，只拷贝数据
    }
}
