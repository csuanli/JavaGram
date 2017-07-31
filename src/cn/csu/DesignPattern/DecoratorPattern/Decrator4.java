package cn.csu.DesignPattern.DecoratorPattern;

//装饰模式要点：变继承为组合
//一个类从网络上读取信息并显示
//将所有读模块用接口管理
abstract class Reader4 { // 变接口为抽象类，因为有成员变量
    public abstract void read();

    protected String info;

    public String getInfo() {
	return info;
    }

    public void setInfo(String info) {
	this.info = info;
    }

    public void display() {
	System.out.println("读取的信息是:" + info);
    }
}

class ReadFromNet4 extends Reader4 {
    public void read() {
	System.out.println("连接到网络");
	System.out.println("读信息");
	info = "  这是一句  模拟的  网络信息  ";
    }
}

class ReadFromFile4 extends Reader4 {
    public void read() {
	System.out.println("连接到文件");
	System.out.println("读信息");
	info = "  这是一句  模拟的  文件信息  ";
    }
}

class TrimSpace4 {
    private Reader4 reader;

    public TrimSpace4(Reader4 reader) {
	this.reader = reader;
    }

    public void read() {
	reader.read();
	reader.setInfo(reader.getInfo().replaceAll(" ", ""));

    }

    public void display() {
	reader.display();
    }
}

class Decrator4 {
    public static void main(String[] args) {
	TrimSpace4 ts = new TrimSpace4(new ReadFromNet4());
	ts.read();
	ts.display();

	TrimSpace4 ts2 = new TrimSpace4(new ReadFromFile4());
	ts2.read();
	ts2.display();
    }
}