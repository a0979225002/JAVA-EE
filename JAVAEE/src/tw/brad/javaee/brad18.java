package tw.brad.javaee;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/brad18")
public class brad18 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		//context:上下文,代表整個servlet的執行環境
		String viewpath =  context.getInitParameter("viewpath");//取得初始參數 更改的東西是xml檔
		//目的達到維護性高,需改寫網頁只需改寫這裡
		System.out.println(viewpath);
		//我們改寫的xml檔案新增的值
		//<param-value>D:/JAVA EE/JAVAEE/WebContent/views</param-value>
	}

}
