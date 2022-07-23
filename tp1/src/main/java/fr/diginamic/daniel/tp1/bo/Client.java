package fr.diginamic.daniel.tp1.bo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "CLIENT") 
public class Client {
	
	
	@Column(name = "ID") 
	private int id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@OneToMany(mappedBy="clent")
	private Set<Emprunt> emprunts;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String prenom) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
	}
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
	
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	

	
}
