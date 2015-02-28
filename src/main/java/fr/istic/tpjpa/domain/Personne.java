package fr.istic.tpjpa.domain;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Personne 

{
	
	
	
	private int id;
	
	private String nom;
	private String prenom;
	private String genre;
	private String mail;
	private List<Home> homes;
	private List<Personne>personnes;
	
	
	
	@Temporal(TemporalType.DATE) 
	private Date date_naissaince;
	
	private String profil;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDate_naissaince() {
		return date_naissaince;
	}
	public void setDate_naissaince(Date date_naissaince) {
		this.date_naissaince = date_naissaince;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Home> getHomes() 
	{
		return homes;
	}

	
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	public Personne() 
	
	{
		// TODO Auto-generated constructor stub
		homes=new ArrayList<Home>();
		personnes=new ArrayList<Personne>();
		
	}
	public Personne(String nom) {
		this.nom=nom;
	}

	
	
}
