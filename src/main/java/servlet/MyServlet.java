package servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="mytest",urlPatterns={"/myurl"})
public class MyServlet extends HttpServlet {

	
protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
{
	PrintWriter str=resp.getWriter();
	str.println("Ca marche");
}

protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
{
	super.doPost( req, resp);
	
}




}
