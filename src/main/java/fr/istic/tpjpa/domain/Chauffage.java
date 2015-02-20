package fr.istic.tpjpa.domain;


import fr.istic.tpjpa.domain.*;

import javax.persistence.Entity;




@Entity
public class Chauffage extends Peripherique
{

	public Chauffage() 
	{
		// TODO Auto-generated constructor stub
	}
	//9876543210L;
	
	
	
	
	private String cons;
	

	public Chauffage(String cons) {
		
		this.cons =cons;
	}


	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	
	

}
