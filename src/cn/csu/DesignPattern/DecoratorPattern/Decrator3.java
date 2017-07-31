package cn.csu.DesignPattern.DecoratorPattern;

//装饰模式要点：变继承为组合
//一个类从网络上读取信息并显示
//将所有读模块用接口管理
interface Reader3 {
    public void read();

    public void display();

    public String getInfo();

    public void setInfo(String info);
}

class ReadFromNet3 implements Reader3 {
    private String info;

    public void read() {
	System.out.println("连接到网络");
	System.out.println("读信息");
	info = "  这是一句  模拟的  网络信息  ";
    }

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

class ReadFromFile3 implements Reader3 {
    private String info;

    public void read() {
	System.out.println("连接到文件");
	System.out.println("读信息");
	info = "  这是一句  模拟的  文件信息  ";
    }

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

class TrimSpace3 {
    private Reader3 reader;

    public TrimSpace3(Reader3 reader) {
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

class Decrator3 {
    public static void main(String[] args) {
	TrimSpace3 ts = new TrimSpace3(new ReadFromNet3());
	ts.read();
	ts.display();

	TrimSpace3 ts2 = new TrimSpace3(new ReadFromFile3());
	ts2.read();
	ts2.display();
    }
}