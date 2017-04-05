package cn.csu.Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class myfillcolor extends JFrame implements MouseListener, ActionListener {
	JPanel p;
	JMenuBar b;
	JMenu m1, m2, m3, m4;
	JMenuItem m11, m12, m13, m21, m22, m31, m41;
	static Point d0;
	Point d1, d2, seed;				//表示 (x,y) 坐标空间中的位置的点
	Point[] d;
	Graphics g;
	String menuname;
	static Color fillcolor, linecolor;
	int n = 0;

	void go() {						//初始化界面
		setTitle("图形填充");
		b = new JMenuBar();			//菜单栏
		setJMenuBar(b);
		m1 = new JMenu("画图");
		m2 = new JMenu("选择颜色");
		m3 = new JMenu("填充");
		m4 = new JMenu("设置");
		b.add(m1);
		b.add(m2);
		b.add(m3);
		b.add(m4);
		menuname = "";

		m11 = new JMenuItem("直线");
		m1.add(m11);
		m11.addActionListener(this);		//注册监听

		m12 = new JMenuItem("多边形");
		m1.add(m12);
		m12.addActionListener(this);

		m13 = new JMenuItem("圆形");
		m1.add(m13);
		m13.addActionListener(this);

		m21 = new JMenuItem("线条颜色");
		m2.add(m21);
		m21.addActionListener(this);

		m22 = new JMenuItem("填充颜色");
		m2.add(m22);
		m22.addActionListener(this);

		m31 = new JMenuItem("确定种子位置");
		m3.add(m31);
		m31.addActionListener(this);

		m41 = new JMenuItem("清屏");
		m4.add(m41);
		m41.addActionListener(this);

		d1 = new Point();
		d2 = new Point();
		seed = new Point();
		d = new Point[100];
		p = new JPanel();
		add(p, "Center");
		p.setBackground(Color.WHITE);
		p.addMouseListener(this);
		fillcolor = Color.red;
		linecolor = Color.blue;
		setSize(600, 400);
		setLocation(150, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {

		if (ev.getActionCommand().equals("直线"))
			menuname = "直线";
		if (ev.getActionCommand().equals("多边形")) {
			menuname = "多边形";
			n = 0;
		}
		if (ev.getActionCommand().equals("圆形"))
			menuname = "圆形";
		if (ev.getActionCommand().equals("线条颜色"))
			linecolor = JColorChooser.showDialog(null, "请选择线条颜色", linecolor);		//设置线条颜色
		if (ev.getActionCommand().equals("填充颜色"))
			fillcolor = JColorChooser.showDialog(null, "请选择填充颜色", fillcolor);		//设置填充颜色
		if (ev.getActionCommand().equals("确定种子位置")) {
			menuname = "确定种子位置";													
		}

		if (ev.getActionCommand().equals("清屏")) {										//清屏
			g = p.getGraphics();
			g.setColor(Color.WHITE);					
			g.clearRect((int) p.getX(), (int) p.getY(), p.getWidth(), p
					.getHeight());
			menuname = "";
			repaint();
		}

	}

	public void mouseClicked(MouseEvent ev) {
		if (menuname.equals("多边形")) {			//点击多边形按钮
			if (ev.getClickCount() == 1) {		//鼠标单击次数
				d[n] = new Point();
				d[n].x = ev.getX();
				d[n].y = ev.getY();				
				g.setColor(linecolor);			//设置颜色
				g.fillOval(d[n].x, d[n].y, 1, 1);		//当前颜色填充外接指定矩形框的椭圆
				n++;

			} else if (ev.getClickCount() == 2) {
				d[n] = new Point();
				d[n].x = ev.getX();
				d[n].y = ev.getY();
				g.setColor(linecolor);
				for (int i = 0; i < n; i++)
					g.drawLine(d[i].x, d[i].y, d[i + 1].x, d[i + 1].y);
				g.drawLine(d[n].x, d[n].y, d[0].x, d[0].y);
				n = 0;
			}
		}
		if (menuname.equals("确定种子位置")) {	
			seed.x = ev.getX();
			seed.y = ev.getY();
			(new fil1()).fill_area(p, seed.x, seed.y, fillcolor);			//填充指定区域
		}

	}

	//获取坐标
	public void mousePressed(MouseEvent ev) {
		d1.x = ev.getX();
		d1.y = ev.getY();				
	}

	public void mouseReleased(MouseEvent ev) {
		d2.x = ev.getX();
		d2.y = ev.getY();
		g = p.getGraphics();
		g.setColor(linecolor);
		if (menuname.equals("直线"))					//点击直线按钮
			g.drawLine(d1.x, d1.y, d2.x, d2.y);		//画直线
		if (menuname.equals("圆形"))					//点击圆形按钮
			g.drawOval(d1.x, d1.y, Math.abs(d2.x - d1.x), Math.abs(d2.y			
							- d1.y));				//画圆
	}

	public void mouseEntered(MouseEvent ev) {
	}

	public void mouseExited(MouseEvent ev) {
	}

	public static void main(String[] arg) {
		myfillcolor f = new myfillcolor();
		f.go();
		d0 = f.getLocationOnScreen();
	}
}

class fil1 {
	static int LEFT = 0, RIGHT = 599, TOP = 0, BOTTOM = 399;
	static int TAB_TERM[] = new int[900];
	static int PUSH_POINT = 0;
	static int POP_POINT = 0;
	int xl = 0, xr = 0, x_left = 0, x_right = 0, x = 0, se_y = 0;
	Robot bt;

	void scan_board(JPanel p, int seed_x, int seed_y, Color f_color,
			Color g_color) {
		int x, y, r;
		Point d;
		d = p.getLocationOnScreen();
		Color color = p.getBackground();
		x = seed_x;
		y = seed_y;

		while (true) {
			--x;
			if (x <= LEFT)
				break;
			color = bt.getPixelColor(x + d.x, y + d.y);
			if (!color.equals(g_color))
				break;
		}
		x_left = ++x;
		xl = x_left;

		x = seed_x;
		while (true) {
			++x;
			if (x >= RIGHT)
				break;
			color = bt.getPixelColor(x + d.x, y + d.y);
			if (!color.equals(g_color))
				break;
		}
		x_right = --x;
		xr = x_right;
		Graphics g = p.getGraphics();
		g.setColor(f_color);
		g.drawLine(x_left, y, x_right, y);
	}

	void push_x(int x_left, int x_right, int seed_y) {
		if (PUSH_POINT >= TAB_TERM.length)
			PUSH_POINT = 0;
		TAB_TERM[PUSH_POINT] = x_left;
		PUSH_POINT++;
		TAB_TERM[PUSH_POINT] = x_right;
		PUSH_POINT++;
		TAB_TERM[PUSH_POINT] = seed_y;
		PUSH_POINT++;
	}

	void pop_x() {
		if (POP_POINT >= TAB_TERM.length)
			POP_POINT = 0;
		xl = TAB_TERM[POP_POINT];
		POP_POINT++;
		xr = TAB_TERM[POP_POINT];
		POP_POINT++;
		se_y = TAB_TERM[POP_POINT];
		POP_POINT++;
	}

	void fill_area(JPanel p, int x, int y, Color f_color) {			//填充
		Color color, g_color;
		Point d3;
		int xl1, xr1;
		d3 = p.getLocationOnScreen();
		int y_up, y_down, i;
		PUSH_POINT = 0;
		POP_POINT = 0;

		Graphics g = p.getGraphics();

		try {
			bt = new Robot();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		if (x < 0 || x >= RIGHT)
			return;
		if (y < 0 || y >= BOTTOM)
			return;

		g_color = bt.getPixelColor(d3.x + x, d3.y + y);
		if (f_color.equals(g_color))
			return;
		scan_board(p, x, y, f_color, g_color);
		push_x(xl, xr, y);

		while (PUSH_POINT != POP_POINT) {
			pop_x();
			y_up = se_y;
			y_down = se_y;
			if (y_up > TOP)
				y_up--;
			if (y_down < BOTTOM)
				y_down++;

			for (i = xl; i < xr; i++) {
				color = bt.getPixelColor(d3.x + i, d3.y + y_up);
				if (color.equals(g_color)) {
					xr1 = xr;
					xl1 = xl;
					scan_board(p, i, y_up, f_color, g_color);
					push_x(x_left, x_right, y_up);
					xr = xr1;
					xl = xl1;
				}
			}

			for (i = xl; i < xr; i++) {
				color = bt.getPixelColor(d3.x + i, d3.y + y_down);
				if (color.equals(g_color)) {
					xr1 = xr;
					xl1 = xl;
					scan_board(p, i, y_down, f_color, g_color);
					push_x(x_left, x_right, y_down);
					xr = xr1;
					xl = xl1;
				}
			}

		}

		g.dispose();		//释放此图形的上下文以及它使用的所有系统资源

	}
}

