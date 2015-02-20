package servlet;

import fr.istic.tpjpa.domain.Personne;
import fr.istic.tpjpa.jpa.JpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yvan on 08/02/2015.
 */

@WebServlet(name="inserdata",urlPatterns={"/InserData"})
public class InserData extends HttpServlet

{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("withoutcreate");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        int count_p=manager.createQuery("select p from Personne p where p.nom='"+req.getParameter("nom")
                +"'",Personne.class).getResultList().size();
        if(count_p==0)
        {
            
           Personne p= Create_Personne(req.getParameter("nom"),req.getParameter("prenom"),
                   req.getParameter("mail"),req.getParameter("sexe"));
            
            manager.persist(p);
            tx.commit();

        }
        int verif_p=manager.createQuery("select p from Personne p where p.nom='"+req.getParameter("nom")
                +"'",Personne.class).getResultList().size();
        
         if (verif_p>0)

         {

             resp.setContentType("text/html");
             PrintWriter out = new PrintWriter(resp.getWriter());

             out.print("<html>\n<Body>\n" +
                     "<H1>Recapitulatif des Informations</H1>\n");

             out.print("<script>L'inscription s'est effectue evac succes</script></Body></html>");
         }
    }
    
    public Personne Create_Personne(String nom,String prenom,String sexe,String mail)
    {
        Personne p=new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setMail(mail);
        return p;
    }
    
    
}
