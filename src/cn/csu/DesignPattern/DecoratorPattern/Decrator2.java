package cn.csu.DesignPattern.DecoratorPattern;

//一个类从网络上读取信息并显示
class ReadFromNet2 {
    protected String info;

    public void read() {
	System.out.println("连接到网络");
	System.out.println("读信息");
	info = "  这是一句  模拟的  网络信息  ";
    }

    public void display() {
	System.out.println("读取的信息是:" + info);
    }
}

class ReadFromFile2 {
    protected String info;

    public void read() {
	System.out.println("连接到文件");
	System.out.println("读信息");
	info = "  这是一句  模拟的  文件信息  ";
    }

    public void display() {
	System.out.println("读取的信息是:" + info);
    }
}

class TrimSpace2 {
    public String trimSpace(String str) {
	return str.replaceAll(" ", "");
    }
}

// 适配器,可以做到
// 问题：如果该项目中还有一个类，专门负责文件读取信息，读完
// 之后,也要去空格，即：TrimSpace需要接到多个模块上使用
// 如果用适配器模式，必须将读文件的类再继承一次，
// 造成子类过多
class NewReadFromNet2 extends ReadFromNet2 {
    public void read() {
	super.read();
	TrimSpace2 ts = new TrimSpace2();
	info = ts.trimSpace(info);
    }
}

class NewReadFromFile2 extends ReadFromFile2 { // 造成子类过多
    public void read() {
	super.read();
	TrimSpace2 ts2 = new TrimSpace2();
	info = ts2.trimSpace(info);
    }
}

public class Decrator2 {
    public static void main(String[] args) {
	ReadFromNet2 rfn = new NewReadFromNet2();
	rfn.read();
	rfn.display();
	ReadFromFile2 rff = new NewReadFromFile2();
	rff.read();
	rff.display();
    }
}