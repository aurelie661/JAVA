package fr.delpharm.esacp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A Contract.
 */

@Entity
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contrat;
	private Boolean isAffiche;
	
	
	public Contrat() {
		// TODO Auto-generated constructor stub
	}


	public Contrat(Long id, String contrat, Boolean isAffiche) {
		super();
		this.id = id;
		this.contrat = contrat;
		this.isAffiche = isAffiche;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getContrat() {
		return contrat;
	}


	public void setContrat(String contrat) {
		this.contrat = contrat;
	}


	public Boolean getIsAffiche() {
		return isAffiche;
	}


	public void setIsAffiche(Boolean isAffiche) {
		this.isAffiche = isAffiche;
	}
	
	
}
