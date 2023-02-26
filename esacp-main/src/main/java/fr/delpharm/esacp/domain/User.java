package fr.delpharm.esacp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    @Column(unique =true)
    private String email;
    private Boolean enabled;
    @Column(unique =true)
    private Long matricule;
    private Date dateDeNaissance;
    private Boolean isAffiche;
    private Boolean pilote;
    
    @Transient
    private Long manangerId;
    
    @Transient
    private Long statutId;
    
    @Transient
    private Long sexeId;
    
    @Transient
    private Long siteId;
    
    @Transient
    private Long cspId;
    
    @Transient
    private Long roleID;

    @ManyToOne
	@JoinColumn(name = "statutID", referencedColumnName = "id")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name="sexeID", referencedColumnName = "id")
    private Sexe sexe;
 
    @ManyToOne
    @JoinColumn(name="userID", referencedColumnName = "id")
    private User mananger;
        
    @ManyToOne
    @JoinColumn(name="siteID", referencedColumnName = "id")
    private Site site;

    @ManyToOne
    @JoinColumn(name="CspID", referencedColumnName = "id")
    private Csp csp;
    
    @ManyToOne
    @JoinColumn(name="roleID", referencedColumnName = "id")
	private Role role;
       
}
