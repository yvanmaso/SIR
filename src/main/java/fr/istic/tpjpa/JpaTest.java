package fr.istic.tpjpa;



import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.istic.tpjpa.domain.*;




public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */

	/**
	 * Méthode d'initialisation de la connection
	 * @return
	 */
	private static   EntityManager create_connection()
	{
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
        return manager;

	}
	
	
	
	public static void main(String[] args) {

		
		
		JpaTest test = new JpaTest(create_connection());
		EntityTransaction tx = test.manager.getTransaction();
		tx.begin();

		// TODO create entity

		// TODO persist entity
		try
		{
		test.createInstances();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		


		
		//test.find_peripherique();
		tx.commit();

		// TODO run request

		System.out.println(".. done");
	}


	/**
	 * * Methode de Creation des differents instances du JPA
	 */
	public  void createInstances()
	{
		int numberofhomes=manager.createQuery("select p from Personne p", Personne.class).getResultList().size();
		if(numberofhomes==0)
		{
			Chauffage c=new Chauffage();
			c.setCons("5000K");
			ElectricDevice e=new ElectricDevice();
			e.setCons("300K");
			Home residence=new Home();
			Home home=new Home();
			home.getPeripheriques().add(c);
			residence.getPeripheriques().add(e);
			
		Personne pers=new Personne();
			pers.getHomes().add(home);
			pers.setMail("osamyvchris@yahoo.fr");
			pers.setNom("yvan");
			pers.setPrenom("christian");
			pers.setProfil("privee");
				    
			Personne pers1=new Personne();
			pers1.getHomes().add(residence);
				    
			pers1.setMail("chris@yahoo.fr");
			pers1.setNom("yvan christian");
			pers1.setPrenom("Regema");
			pers1.setProfil("public");
			pers1.getPersonnes().add(pers);
			this.manager.persist(pers);
			this.manager.persist(pers1);
				    
				 
			
			
		}
		
	}

	/**
	 * Query qui retourne l'ensemble des personnes
	 * @return
	 */
	public List<Personne> listPersonne()
	{
		List<Personne>result_list=manager.createQuery("select p from Personne p",Personne.class).getResultList();
		System.out.println("nombre de personnes est :"+result_list.size());
		for(Personne p:result_list)
		{
			System.out.println("la personne est :"+p.getNom());
		}
		
		return result_list;
		
	}


	/*
	Creation des instances pour les departements et les employes--->dernier reponse du TP2
	 */
	
	

			
/*

Requete avec CriteriaQuery en  utilisant l'heritage

 */
public List<Peripherique> find_peripherique()
	{
		CriteriaBuilder cr=create_connection().getCriteriaBuilder();
		CriteriaQuery <Peripherique>c=cr.createQuery(Peripherique.class);	
		
	CriteriaQuery<Peripherique> query =  cr.createQuery(Peripherique.class);
		Root<Peripherique> from = query.from(Peripherique.class);
		CriteriaQuery<Peripherique> select = query.select(from);
		TypedQuery<Peripherique> typedQuery = create_connection().createQuery(select);
		List<Peripherique> resultList = typedQuery.getResultList();
		

		for(Peripherique p:resultList)
		{
			System.out.println(p.getId());
		}

		return resultList;

	}
	
	
}
