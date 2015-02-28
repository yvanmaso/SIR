package fr.istic.tpjpa.domain;
import fr.istic.tpjpa.domain.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Home 
{

	
	
	private int id;
	
	private String adresse;
	private int superficie;
	private String ip;
	
	
	private List<Peripherique>peripheriques;
	//private List<ElectricDevice>devices;
	
	public Home() 
	{
		// TODO Auto-generated constructor stub
		
		peripheriques=new ArrayList<Peripherique>();
		/*chauffages=new ArrayList<Chauffage>();
		devices=new ArrayList<ElectricDevice>();*/
		id=0;
		superficie=0;
		adresse="";
	}
	
//	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}



	public Home(int id) 
	{

	this.id = id;
    }

	public void setId(int id) {
		this.id =id ;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Peripherique> getPeripheriques() {
		return peripheriques;
	}

	public void setPeripheriques(List<Peripherique> peripheriques) {
		this.peripheriques = peripheriques;
	}

	public  void addDevice(Peripherique p)
	{
		getPeripheriques().add(p);
		
	}

	/*
	
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Chauffage> getChauffages() {
		return chauffages;
	}

	public void setChauffages(List<Chauffage> chauffages) {
		this.chauffages = chauffages;
	}

	
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<ElectricDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<ElectricDevice> devices) {
		this.devices = devices;
	}
	*/
	
	

}
