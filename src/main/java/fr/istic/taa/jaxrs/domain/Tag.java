package fr.istic.taa.jaxrs.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Tag {
	
	private Long id; 
	private String libelle ;
	private List<FicheKanban> fichekanbans ; 
	
	public Tag() {
	}
	
	@javax.persistence.Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	} 
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@ManyToMany (mappedBy ="tags")
	public List<FicheKanban> getFichekanbans() {
		return fichekanbans;
	}
	public void setFichekanbans(List<FicheKanban> fichekanbans) {
		this.fichekanbans = fichekanbans;
	}
	
	
}
