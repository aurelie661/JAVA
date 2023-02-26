package fr.delpharm.esacp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Actions.
 */
// Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity déclare la classe comme un entity bean 
@Entity
public class Action{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String redacteur;
	private Boolean isActionImmediate;
	private Date dateEtHeureCreation;
	private String titre;
	private String descriptionAction;
	private String descriptionReponse;
	private Date delai;
	private String etat;
	private String pilote;
	private Date dateEtHeureValidationPilote;
	private String porteur;
	private Date dateEtHeureValidationPorteur;
	private String hse;
	private Date dateEtHeureValidationHse;
	private Long etape;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rapportID", referencedColumnName = "id")
	private Rapport rapport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="correctPreventID", referencedColumnName = "id")
	private CorrectPrevent correctPrevent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="prioriteID", referencedColumnName = "id")
	private Priorite priorite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="etapeValidationID", referencedColumnName = "id")
	private EtapeValidation etapeValidation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="typeActionID", referencedColumnName = "id")
	private TypeAction typeAction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="criticiteID", referencedColumnName = "id")
	private Criticite criticite;

	
}
