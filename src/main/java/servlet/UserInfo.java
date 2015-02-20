package servlet;

import java.awt.print.PrinterAbortException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter out=new PrintWriter(resp.getWriter());
		out.print("<html>\n<Body>\n" +
		"<H1>Recapitulatif des Informations</H1>\n"
				+
		"<ul>\n"
				+
		"<li>Nom:"
				+
		req.getParameter("name")+"\n"+
				"<li>Prenom:"
		        +
				req.getParameter("firstname")+"\n"+
		        "<li>Age:"
				+
		        req.getParameter("age")+"\n"+
				"</ul>\n" 
		        +
				"</Body></html>"
			
				);
		
		

		
		
	}


}
