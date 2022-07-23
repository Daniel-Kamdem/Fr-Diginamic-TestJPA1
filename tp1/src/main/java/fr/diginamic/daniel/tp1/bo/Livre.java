package fr.diginamic.daniel.tp1.bo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "LIVRE")
public class Livre {
 
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "TITRE")
	private String titre;
	@Column (name = "AUTEUR")
	private String auteur;
@ManyToMany(mappedBy="livres")
private Set<Emprunt>emprunts;

	public Set<Emprunt> getEmprunts() {
	return emprunts;
}

public void setEmprunts(Set<Emprunt> emprunts) {
	this.emprunts = emprunts;
}

	public Livre() {
		super();
		// TODO Auto-generated constructor stub

	}

	public Livre(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}
	

	
	
}
