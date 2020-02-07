package tw.brad.javaee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//view:輸出介面
@WebServlet("/brad17")
public class brad17 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String x = request.getParameter("x");
		String op = request.getParameter("op");
		String y = request.getParameter("y");
		String result = request.getParameter("result");
		String filename = request.getParameter("filename");
		
		String op1 = op.equals("1")?"selcted":"";
		String op2 = op.equals("2")?"selcted":"";
		String op3 = op.equals("3")?"selcted":"";
		String op4 = op.equals("4")?"selcted":"";
		String html = loadview(filename);//將view.html檔案移到外面去,可以方便修改
		out.print(String.format(html,x,op1,op2,op3,op4,y,result));//輸出loadview方法
		response.flushBuffer();
		//flushBuffer將東西東衝出來,以防萬一
	}
	
	
	//loadview方法:載入view1.html
	private String loadview(String filename) {
		ServletContext context = getServletContext();
		//context:上下文,代表整個servlet的執行環境
		String viewpath =  context.getInitParameter("viewpath");//取得初始參數 更改的東西是xml檔
		//目的達到維護性高,需改寫網頁只需改寫這裡
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(
											new FileReader(
													new File(viewpath,filename)));
			
			String line;
			while ((line = reader.readLine())!=null) {
				sb.append(line+"\n");//這樣會沒煥頁,加入\n 方便看
			}
				reader.close();
		} catch (Exception e) {
			e.toString();
		}
		return sb.toString();
		
	}
	
}
