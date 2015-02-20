package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.tpjpa.jpa.JpaTest;
import fr.istic.tpjpa.domain.*;


@WebServlet(name="mydata",urlPatterns={"/myopower"})
public class OPower extends HttpServlet

{@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 

{
	// TODO Auto-generated method stub
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("example");
	EntityManager manager = factory.createEntityManager();
	JpaTest test = new JpaTest(manager);

	EntityTransaction tx = manager.getTransaction();
	tx.begin();
	
	PrintWriter str=resp.getWriter();
	
	List<Personne> personnes=test.listPersonne();
	resp.setContentType("text/html");
	PrintWriter out=new PrintWriter(resp.getWriter());
	out.print("<html>\n<Body>\n" +
			"<H1>Recapitulatif des Informations</H1>\n");
	for(Personne p :personnes)
	{
	out.print("<table>\n"
			+
			"<tr><th>Id</th>"
			+
			"<th>Nom</th>"
			+
			"<th>Prenom</th>"
			+
			"<th>Mail</th>"
			+
			"<th>Profil</th> <tr>"
	        +
			
				"<tr><td>"
                 +
				p.getId()+
				"</td><td>"
				+
				p.getNom()
				+
				"</td><td>"
				+
				p.getPrenom()
				+
				"</td><td>"
				+
				p.getMail()
				+
				"</td><td>"
				+
				p.getProfil()
				+
				"</td></tr></table></Body></html>");
      }
	
						
	tx.commit();
	
}
	
	

}
