package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class TableauKanban implements Serializable {
	
	
	private Long id ; 
	private String libelle ;
	private List<Section> sections ;
	private List<Collaborateur> collaborateurs ; 
	
	public TableauKanban() {
		super();
	}
	
	public TableauKanban(List<Collaborateur> collaborateurs) {
		super();
		this.collaborateurs = collaborateurs;
	}
	//Libelle 
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany (mappedBy = "tableaukanban")
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@ManyToMany	
	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
}
