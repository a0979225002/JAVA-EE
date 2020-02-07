package tw.brad.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class brad13
 */
@WebServlet("/brad13")
public class brad13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("brad14");
		// RequestDispatcher:能將request的東西加入server //實作request
		PrintWriter out = response.getWriter();// 寫出
		out.println("<h1>brad big company</h1><hr />");
		
		dispatcher.forward(request, response);
		//forward:轉送

	}

}
