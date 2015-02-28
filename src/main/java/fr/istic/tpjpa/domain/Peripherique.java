package fr.istic.tpjpa.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_peripherique")
@DiscriminatorValue("Peripherique")
public class Peripherique 
{

	
	
	private long id;
	protected String cons;
	public String getCons() {
		return cons;
	}


	public void setCons(String cons) {
		this.cons = cons;
	}


	public Peripherique() 
	
	{
		id=0;
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Peripherique(long id) {
		super();
		this.id = id;
	}


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	




	







}
