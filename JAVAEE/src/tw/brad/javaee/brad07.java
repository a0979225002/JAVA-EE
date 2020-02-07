package tw.brad.javaee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/brad07")
@MultipartConfig(
		location = 
		"D:\\JAVA EE\\JAVAEE\\WebContent\\upload")
public class brad07 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		File uploadDir = 
				new File("D:\\JAVA EE\\JAVAEE\\WebContent\\upload");

		// enctype="multipart/form-data"
		// MUST BE => @MultipartConfig 
		Collection<Part> parts = request.getParts();
		System.out.println("size = " +parts.size());
		System.out.println("文件名"+parts);
		int i=1;
		for (Part part : parts) {
			
			String name = part.getName();
			String sname = part.getSubmittedFileName();
			
			System.out.println(sname);
			System.out.println(name);
			//System.out.println(name + ":" + sname);
			
			if (sname.length() == 0) continue;
			if (!(sname.substring(sname.length()-3)).equals("jpg"))continue; 	
			
			part.write(FileName(i++));
			
		}
	
	}
	
	private String FileName(int i) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh點");
		Date now = new Date();
		String nowdate = simpleDateFormat.format(now);
		return  nowdate+"第"+i+".jpg";
	}

}
