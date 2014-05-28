

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
 	public void service(ServletRequest request, ServletResponse response)
	 throws ServletException, IOException{
		 response.setContentType("text/html");
		 PrintWriter writer= response.getWriter();
		 writer.print("<html><body><marquee><h1>Hello World</h1></marquee>"+new Date(0).toString()+"</BODY><HTML>");
		 writer.print("<html><body><marquee><h1>Gabriel Rivera Morales</h1></marquee>");
	 }
	
	
	
	
	
	
	
   

}
