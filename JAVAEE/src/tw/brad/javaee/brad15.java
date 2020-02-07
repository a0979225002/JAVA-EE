package tw.brad.javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/brad15")
public class brad15 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 第0動
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
		String view = request.getParameter("view");
		String filename="";
		if (x == null)
			x = "0";
		if (y == null)
			y = "0";
		if (op==null) 
			op="1";
		if (view ==null) {
			filename = "view2.html";
		}else if (view.equals("view2")) {
			filename = "view2.html";
		}else {
			filename = "view1.html";
		}
		System.out.println(view);
		// 第一動 寫 model
		brad16 model = new brad16(x, y,op,view);// 使用java檔去寫一個方法
		double result = model.operation();// 方法在brad16.operation()中
		//filename = model.view();
		System.err.println(filename+123);
		// 第二動 寫view
		RequestDispatcher dispatcher =
						request.getRequestDispatcher(
								String.format("brad17?filename=%s&x=%s&op=%s&y=%s&result=%s",
										filename,x,op,y,result));
		dispatcher.forward(request, response);
	}

}
