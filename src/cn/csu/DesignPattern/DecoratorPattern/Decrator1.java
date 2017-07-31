package cn.csu.DesignPattern.DecoratorPattern;

class ReadFromNet1 {
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

class TrimSpace1 {
    public String trimSpace(String str) {
	return str.replaceAll(" ", "");
    }
}

// 适配器,可以做到
// 问题：如果该项目中还有一个类，专门负责文件读取信息，读完
// 之后,也要去空格，即：TrimSpace需要接到多个模块上使用
class NewReadFromNet1 extends ReadFromNet1 {
    public void read() {
	super.read();
	TrimSpace1 ts = new TrimSpace1();
	info = ts.trimSpace(info);
    }
}

class Decrator1t {
    public static void main(String[] args) {
	ReadFromNet1 rfn = new NewReadFromNet1();
	rfn.read();
	rfn.display();
    }
}