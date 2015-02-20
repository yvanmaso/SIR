package fr.istic.tpjpa.domain;

import fr.istic.tpjpa.domain.Peripherique;

import javax.persistence.Entity;

@Entity
public class ElectricDevice extends Peripherique

{
	
	private String cons;
	



	public ElectricDevice(String cons) {
		super();
		this.cons = cons;
	}


	ElectricDevice() {
		// TODO Auto-generated constructor stub
	
	}



	public String getCons() {
		return cons;
	}


	public void setCons(String cons) {
		this.cons = cons;
	}
	
	
	

}
