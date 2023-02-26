package fr.delpharm.esacp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A Categorie.
 */
@Entity
public class Categorie{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categorie;
    private Boolean isAffiche;
    
    
    
	public Categorie() {
		super();
	}

	public Categorie(Long id, String categorie, Boolean isAffiche) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.isAffiche = isAffiche;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Boolean getIsAffiche() {
		return isAffiche;
	}

	public void setIsAffiche(Boolean isAffiche) {
		this.isAffiche = isAffiche;
	}
    
    
    
}


