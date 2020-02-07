package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/brad11")
public class brad11 extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//輸出到網頁指定的文字格式
		String name = request.getParameter("name");
		if (name==null) {
			name = "world";
		}
		
		//request:取得的東西
		//response:傳出的東西
		RequestDispatcher dispatcher = 
					request.getRequestDispatcher("brad12?name=brad"+name);//? = 加入參數
		//RequestDispatcher:能將request的東西加入server //實作request
	
		
		PrintWriter out = response.getWriter();//寫出
		out.println("<h1>brad big company<h1><hr />");
		dispatcher.include(request, response);//把後端的dispatcher實體物件送出,比如.html
		//查看是否能在取得物件實體加入使用
		dispatcher = 
				request.getRequestDispatcher("brad05.html");
		dispatcher.include(request, response);
		
		out.println("im am brad <hr />");
	}


}
