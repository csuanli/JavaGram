package cn.csu.DesignPattern.PrototypePattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Description: 深克隆实现 <br>
 * 
 * @author li.an1 <br>
 * @version 8.0 <br>
 * @taskId <br>
 * @CreateDate 2017年7月31日 <br>
 * @since V8 <br>
 * @see cn.csu.DesignPattern.PrototypePattern <br>
 */
public class Prototype2 {
    public static void main(String[] args) throws Exception {
	Word4 w1 = new Word4("好", new Font("黑体", "蓝色", 50));
	Word4 w2 = w1.copy();// 克隆

	System.out.println("W1的字体是:" + w1.font.fontName);
	System.out.println("W2的字体是:" + w2.font.fontName);

	w1.font.fontName = "宋体";
	System.out.println("w1改后W2的字体是:" + w2.font.fontName);
    }
}

class Font implements java.io.Serializable {
    String fontName;
    String fontColor;
    int fontSize;

    public Font(String fontName, String fontColor, int fontSize) {
	this.fontColor = fontColor;
	this.fontName = fontName;
	this.fontSize = fontSize;
    }
}

/*
 * 单纯克隆叫做浅克隆，无法复制引用对象，如果要实现全面克隆 用深克隆：将对象写入流中，然后取出
 */
class Word4 implements java.io.Serializable {

    String content;
    Font font;// 引用对象

    public Word4(String content, Font font) {
	this.content = content;
	this.font = font;
    }

    public Word4 copy() throws Exception { // 深克隆
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	oos.writeObject(this);
	ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	ObjectInputStream ois = new ObjectInputStream(bais);
	return (Word4) ois.readObject();
    }
}