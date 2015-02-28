package fr.istic.sir.rest;

import fr.istic.tpjpa.domain.Chauffage;
import fr.istic.tpjpa.domain.Home;

import java.awt.PageAttributes.MediaType;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * * Classe permattant de  comprendre le fonctionnement de REST
 * 
 */

@Path("/hello")
public class SampleWebService
{
    
    
    public List<Home> list_homes=new ArrayList<Home>();
    
    public SampleWebService()
    {

        for (int i = 0; i < 10; i++) 
        {
           Home h=new Home();
            h.setAdresse("A"+i);
           list_homes.add(h);
        }
    }
    
    @GET 
    @Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
public String sayHello()

{
return "Hello?How Are You?";	
}





    @GET @Path("search/{id}")
    @Produces({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
    public Home findById(@PathParam("id") String arg0) {
        return list_homes.get(Integer.parseInt(arg0));
    }
   /* 
    @GET
    @Produces({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
    public Collection<Home> list() {
        return list_homes;
    }
    
    */
    
    
    @GET
    @Path("/home")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Home getHome()
    {

        
       Home h=new Home();
        h.setAdresse("toto");
        Chauffage c=new Chauffage();
        c.setCons("500w");
        Chauffage c1=new Chauffage();
        c1.setCons("600w");
        h.addDevice(c);
        h.addDevice(c1);
        System.out.println("ok");
        return  h;
               
        
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON })
    public Home deleteById(@PathParam("id") String arg0) {
        return list_homes.remove(Integer.parseInt(arg0));
    }
    
    
    
    
    
}
