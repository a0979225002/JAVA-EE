package tw.brad.javaee;

import com.sun.glass.ui.View;

import sun.net.www.content.audio.x_aiff;

public class brad16 {
	private int x, y, op;
	private String view;

	public brad16(String x, String y, String op, String view) {
		this.x = Integer.valueOf(x);
		this.y = Integer.valueOf(y);
		this.op = Integer.valueOf(op);
		this.view = view;
	}

	public String view() {

		switch (view) {
		case "view1":
			return "view1.html";
		case "view2":
			return "view2.html";
		default:
			return "view2.html";
		}

	}

	// 加減乘除運算
	public double operation() {

		switch (op) {
		case 1:
			return x + y;
		case 2:
			return x - y;
		case 3:
			return x * y;
		case 4:
			return x * 1.0 / y;// x*1.0為了得到浮點數;
		default:
			return 0;

		}
	}
}
