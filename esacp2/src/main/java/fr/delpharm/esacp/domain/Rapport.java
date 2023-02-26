package fr.delpharm.esacp.domain;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Rapport.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rapport{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDeCreation;
    private String uap;
    private Date dateEtHeureConnaissanceAt;
    private String prevenuComment;
    private String nomPremierePersonnePrevenu;
    private Date dateEtHeurePrevenu;
    private Boolean isTemoin;
    private String commentaireTemoin;
    private Boolean isTiersEnCause;
    private String commentaireTiersEnCause;
    private Boolean isAutreVictime;
    private String commentaireAutreVictime;
    private Boolean isRapportDePolice;
    private String commentaireRapportDePolice;
    private Boolean isVictimeTransports;
    private String commentaireVictimeTransporter;
    private Date dateEtHeureMomentAccident;
    private String lieuAccident;
    private Boolean isIdentifierDu;
    private String circonstanceAccident;
    private String materielEnCause;
    private String remarques;
    private Date dateEtieureValidationPilote;
    private Date dateEtHeureValidationPorteur;
    private String hse;
    private Date dateEtHeureValidationHse;
    private Boolean isIntervention8300;
    private Boolean isInterventionInfirmiere;
    private String commentaireInfirmere;
    private Boolean isInterventionMedecin;
    private String commentaireMedecin;
    private Boolean isInterventionsecouriste;
    private String commentaireSecouriste;
    private Boolean isInterventionsecouristeExterieur;
    private Boolean retourAuPosteDeTravail;
    private String travailLegerPossible;
    private Boolean analyseAChaudInfirmiere;
    private Boolean analyseAChaudCodir;
    private Boolean analyseAChaudHse;
    private Boolean analyseAChaudNplus1;
    private Boolean analyseAChaudCssCt;
    private String analyseAChaudCommentaire;  
    private String descriptionsituationdangereuse;  
    private String actionimmediat;
    private String pourquoi1;
    private String pourquoi2;
    private String pourquoi3;
    private String pourquoi4;
    private String pourquoi5;
    private String telephone;

    private Blob pjAutreRapport;

    private String motifDeplacement;
    private String nomTemoins;
    private String actionVictime;
    private String causeAccident;
    private Boolean cou;
    private Boolean colonne;
    private Boolean dos;
    private Boolean mainGauche;
    private Boolean mainDroite;
    private Boolean genou;
    private Boolean jambe;
    private Boolean cheville;
    private Boolean epaule;
    private Boolean bras;
    private Boolean coude;
    private Boolean poignet;
    private Boolean oeil;
    private Boolean pied;
    private Boolean torse;
    private Boolean tete;
    private Boolean siegesmultiples;
    private Boolean autreLesionSiege;
    private Boolean autreLesionNature; 
    private String autreSiegeLesionPrecision;
    private String autreNatureLesionPrecision;
    private Boolean brulureThermique;
    private Boolean brulureChimique;
    private Boolean contusionHematome;
    private Boolean douleur;
    private Boolean ecrasement; 
    private Boolean electrisationElectrocution;
    private Boolean intoxication;
    private Boolean piqure;
    private Boolean plaieMorsure;
    private Boolean corpsEtranger;
    private Boolean isRDP;
    

    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long personneATID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long departementID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long contratID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long moyenID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long statutID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long siegeLesionsID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long hierarchiqueID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long equipementID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long typeRapportID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long categorieID;
    //L'annotation @Transient indique au fournisseur JPA de ne pas persister d'attribut
    @Transient
    private Long typeID;
   
    
    @ManyToOne
    @JoinColumn(name="personneATID", referencedColumnName = "id")
    private User personneAT;
    
    @ManyToOne
    @JoinColumn(name="hierarchiqueID", referencedColumnName = "id")
    private User hierarchique;
    
    @ManyToOne
    @JoinColumn(name="redacteurID", referencedColumnName = "id")
    private User redacteur;

    @ManyToOne
    @JoinColumn(name="userID", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="piloteID", referencedColumnName = "id")
    private User pilote;
    
    @ManyToOne
    @JoinColumn(name="porteurID", referencedColumnName = "id")
    private User porteur;
    
    
    @ManyToMany
    @JoinTable( name = "JointureRapportToSiegeLesion",
    joinColumns = @JoinColumn( name = "siegeLesionID" ),
    inverseJoinColumns = @JoinColumn( name = "rapportID" ) )
    private List<SiegeLesions> siegeLesions = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name="typeID", referencedColumnName = "id")
    private Type type;

    @ManyToOne
    @JoinColumn(name="categorieID", referencedColumnName = "id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name="equipementID", referencedColumnName = "id")
    private Equipement equipement;

    @ManyToOne
    @JoinColumn(name="typeRapportID", referencedColumnName = "id")
    private TypeRapport typeRapport;

    @ManyToOne
    @JoinColumn(name="natureAccidentID", referencedColumnName = "id")
    private NatureAccident natureAccident;

    @ManyToOne
    @JoinColumn(name="origineLesionsID", referencedColumnName = "id")
    private OrigineLesions origineLesions;
   
    
    @ManyToOne
	@JoinColumn(name = "statutID", referencedColumnName = "id")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name="departementID", referencedColumnName = "id")
    private Departement departement;

    @ManyToOne
    @JoinColumn(name="contratID", referencedColumnName = "id")
    private Contrat contrat;
    

    @ManyToOne
    @JoinColumn(name="siteID", referencedColumnName = "id")
    private Site site;
    
    @ManyToOne
    @JoinColumn(name="moyenID", referencedColumnName = "id")
    private MoyenPrevenu moyen;

}
