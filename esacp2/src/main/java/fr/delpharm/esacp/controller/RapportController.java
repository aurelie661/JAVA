package fr.delpharm.esacp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.delpharm.esacp.domain.Categorie;
import fr.delpharm.esacp.domain.Contrat;
import fr.delpharm.esacp.domain.Departement;
import fr.delpharm.esacp.domain.Equipement;
import fr.delpharm.esacp.domain.MoyenPrevenu;
import fr.delpharm.esacp.domain.Rapport;
import fr.delpharm.esacp.domain.SiegeLesions;
import fr.delpharm.esacp.domain.Statut;
import fr.delpharm.esacp.domain.Type;
import fr.delpharm.esacp.domain.TypeRapport;
import fr.delpharm.esacp.domain.User;
//import fr.delpharm.esacp.excel.ExtractAtInterne;
import fr.delpharm.esacp.repository.SiegeLesionsRepository;
import fr.delpharm.esacp.repository.UserRepository;
import fr.delpharm.esacp.service.CategorieService;
import fr.delpharm.esacp.service.ContratService;
import fr.delpharm.esacp.service.DepartementService;
import fr.delpharm.esacp.service.EquipementService;
import fr.delpharm.esacp.service.MoyenPrevenuService;
import fr.delpharm.esacp.service.RapportService;
import fr.delpharm.esacp.service.StatutService;
import fr.delpharm.esacp.service.TypeRapportService;
import fr.delpharm.esacp.service.TypeService;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author GS
 * API CRUD rapports
 */
@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rapports")
public class RapportController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RapportService rapportRepository;

	@Autowired
	private DepartementService departementRepository;

	@Autowired
	private StatutService statutRepository;

	@Autowired
	private ContratService contratRepository;

	@Autowired
	private MoyenPrevenuService moyenRepository;

	@Autowired
	private SiegeLesionsRepository siegeRepository;

	@Autowired
	private EquipementService equipementRepository;

	@Autowired
	private TypeRapportService typeRapportRepository;

	@Autowired
	private CategorieService categorieRepository;

	@Autowired
	private TypeService typeRepository;

	// Permet de d'afficher une liste d'objet rapports
	@GetMapping
	public ResponseEntity<List<Rapport>> listRapports(Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		List<Rapport> rapports = rapportRepository.findAll();
		return new ResponseEntity<List<Rapport>>(rapports, HttpStatus.OK);
	}

	// Permet d'ajouter un objet rapports
	@PostMapping
	public ResponseEntity<Rapport> addRapport(@RequestBody @Valid Rapport rapport, Principal principal) {
		Long userConnectedId = UserController.getUserConnectedId(principal);
		Long rapportTypeID = rapport.getTypeRapportID();
		Optional<User> user = userRepository.findById(userConnectedId);
		Optional<TypeRapport> typeRapport = typeRapportRepository.findById(rapportTypeID);

		if (rapportTypeID == 1) {

		Long personneATID = rapport.getPersonneATID();
		Long departementID = rapport.getDepartementID();
		Long statutID = rapport.getStatutID();
		Long contratID = rapport.getContratID();
		Long moyenID = rapport.getMoyenID();
		Long siegeID = rapport.getSiegeLesionsID();
		Long equipementID = rapport.getEquipementID();
		Long hierarchiqueID = rapport.getHierarchiqueID();
		List<SiegeLesions> siegeValue = rapport.getSiegeLesions();
		List<SiegeLesions> listDesSieges = new ArrayList<SiegeLesions>();
		
		Optional<User> victim = userRepository.findById(personneATID);
		Optional<User> hierarchique = userRepository.findById(hierarchiqueID);
		Optional<Departement> departement = departementRepository.findById(departementID);
		Optional<Statut> statut = statutRepository.findById(statutID);
		Optional<Contrat> contrat = contratRepository.findById(contratID);
		Optional<MoyenPrevenu> moyen = moyenRepository.findById(moyenID);
		Optional<Equipement> equipement = equipementRepository.findById(equipementID);
		
	for (SiegeLesions siegeLesions : siegeValue) {

		siegeLesions = siegeRepository.findById(siegeID).get();
		listDesSieges.add(siegeLesions);
	}
		
rapport.setSiegeLesions(listDesSieges);
log.info(listDesSieges.toString());
		
		if (victim.isPresent())   {
			rapport.setPersonneAT(victim.get());
		}
		if (departement.isPresent())   {
			rapport.setDepartement(departement.get());
		}
		if (statut.isPresent())   {
			rapport.setStatut(statut.get());
		}
		if (contrat.isPresent())   {
			rapport.setContrat(contrat.get());
		}
		if (moyen.isPresent())   {
			rapport.setMoyen(moyen.get());
			rapport.setPrevenuComment(moyen.get().getMoyen());
		}
		if (equipement.isPresent())   {
			rapport.setEquipement(equipement.get());
		}
		if (hierarchique.isPresent())   {
			rapport.setHierarchique(hierarchique.get());
		}

		
		rapport.setDateDeCreation(new Date());
		rapport.setUap(departement.get().getDepartement());
		rapport.setRedacteur(user.get());
		rapport.setTypeRapport(typeRapport.get());
		
		rapportRepository.save(rapport);
		}

		
		if (rapportTypeID == 4) {
			System.out.println("************************IN THE RAPPORT EXTERNE************************");
			Long personneATID = rapport.getPersonneATID();;
			Long moyenID = rapport.getMoyenID();
			Long siegeID = rapport.getSiegeLesionsID();

			Long hierarchiqueID = rapport.getHierarchiqueID();
			List<SiegeLesions> siegeValue = rapport.getSiegeLesions();
			List<SiegeLesions> listDesSieges = new ArrayList<SiegeLesions>();
			
			Optional<User> victim = userRepository.findById(personneATID);
			Optional<User> hierarchique = userRepository.findById(hierarchiqueID);
			Optional<MoyenPrevenu> moyen = moyenRepository.findById(moyenID);
			
		for (SiegeLesions siegeLesions : siegeValue) {

			siegeLesions = siegeRepository.findById(siegeID).get();
			listDesSieges.add(siegeLesions);
		}
			
	rapport.setSiegeLesions(listDesSieges);
	log.info(listDesSieges.toString());
			
			if (victim.isPresent())   {
				rapport.setPersonneAT(victim.get());
			}
			if (moyen.isPresent())   {
				rapport.setMoyen(moyen.get());
				rapport.setPrevenuComment(moyen.get().getMoyen());
			}
			if (hierarchique.isPresent())   {
				rapport.setHierarchique(hierarchique.get());
			}

			
			rapport.setDateDeCreation(new Date());
			rapport.setRedacteur(user.get());
			rapport.setTypeRapport(typeRapport.get());
			
			rapportRepository.save(rapport);

		}
		

		if (rapportTypeID == 2) {

			rapport.setRedacteur(user.get());
			rapport.setTypeRapport(typeRapport.get());
			rapport.setDateDeCreation(new Date());

			rapportRepository.save(rapport);
		}

		if (rapportTypeID == 3) {

			Long categorieID = rapport.getCategorieID();
			Long typeID = rapport.getTypeID();

			Optional<Categorie> categorie = categorieRepository.findById(categorieID);
			Optional<Type> type = typeRepository.findById(typeID);

			rapport.setCategorie(categorie.get());
			rapport.setType(type.get());
			rapport.setRedacteur(user.get());
			rapport.setTypeRapport(typeRapport.get());
			rapport.setDateDeCreation(new Date());

			rapportRepository.save(rapport);
		}

		return new ResponseEntity<Rapport>(rapport, HttpStatus.CREATED);

	}

	// Permet de supprimer un objet rapports
	@DeleteMapping(value = "/{rapportId}")
	public ResponseEntity<Object> deleteRapport(@PathVariable("rapportId") Long rapportId, Principal principal) {
		rapportRepository.deleteById(rapportId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	// Permet de modifier un objet rapports
	@PutMapping(value = "/{rapportId}")
	public ResponseEntity<Rapport> updateBook(@PathVariable("rapportId") String rapportId,
			@Valid @RequestBody Rapport rapport, Principal principal) {
	System.out.println("in the update book");
		Optional<Rapport> rapportToUpdate = rapportRepository.findById(Long.valueOf(rapportId));
		log.info("||| Rapport To update ||| ");
		log.info(rapportToUpdate.toString());
		log.info("||| Rapport To update ||| ");
		Long userConnectedId = UserController.getUserConnectedId(principal);
		log.info("||| Rapport  ||| ");
		log.info(rapport.toString());
		log.info("||| Rapport  ||| ");
		log.info("||| userConnectedId  ||| ");
		Long rapportTypeID = rapport.getTypeRapportID();
		log.info("||| userConnectedId  ||| ");
		log.info(userConnectedId.toString());
		log.info("||| userConnectedId  ||| ");
		Optional<User> user = userRepository.findById(userConnectedId);
		log.info("||| user  ||| ");
		log.info(user.toString());
		log.info("||| user  ||| ");

		Optional<TypeRapport> typeRapport = typeRapportRepository.findById(rapportTypeID);
		if (!rapportToUpdate.isPresent()) {
			return new ResponseEntity<Rapport>(HttpStatus.BAD_REQUEST);
		}
		log.info("||| typeRapport  ||| ");
		log.info(typeRapport.toString());
		log.info("||| typeRapport  ||| ");
		Rapport rapportTosave = rapportToUpdate.get();

		if (rapportTypeID == 1) {
			log.info("||| typeRapport == 1 ||| ");
			Long personneATID = rapport.getPersonneATID();
			Long hierarchiqueID = rapport.getHierarchiqueID();
			Long departementID = rapport.getDepartementID();
			Long statutID = rapport.getStatutID();
			Long contratID = rapport.getContratID();
			Long moyenID = rapport.getMoyenID();
			Long siegeID = rapport.getSiegeLesionsID();
			Long equipementID = rapport.getEquipementID();
			Date connaissanceAT = rapport.getDateEtHeureConnaissanceAt();
			Date momentAccident = rapport.getDateEtHeureMomentAccident();
			Boolean isRDP = rapport.getIsRDP();
			Boolean isDU = rapport.getIsIdentifierDu();
			Boolean is8300 = rapport.getIsIntervention8300();
			Boolean isInterventionInfirmiere = rapport.getIsInterventionInfirmiere();
			Boolean isInterventionMedecin = rapport.getIsInterventionMedecin();
			Boolean isInterventionSecours = rapport.getIsInterventionsecouriste();
			Boolean isInterventionSecoursExterieur = rapport.getIsInterventionsecouristeExterieur();
			Boolean mainGauche = rapport.getMainGauche();
			Boolean mainDroite = rapport.getMainDroite();
			Boolean tete = rapport.getTete();
			Boolean cou = rapport.getCou();
			Boolean oeil = rapport.getOeil();
			Boolean epaule = rapport.getEpaule();
			Boolean bras = rapport.getBras();
			Boolean torse = rapport.getTorse();
			Boolean coude = rapport.getCoude();
			Boolean poignet = rapport.getPoignet();
			Boolean jambe = rapport.getJambe();
			Boolean genou = rapport.getGenou();
			Boolean cheville = rapport.getCheville();
			Boolean pied = rapport.getPied();
			Boolean siegeMultiple = rapport.getSiegesmultiples();
			Boolean colonne = rapport.getColonne();
			Boolean brulureThermique = rapport.getBrulureThermique();
			Boolean brulureChimique = rapport.getBrulureChimique();
			Boolean contusion = rapport.getContusionHematome();
			Boolean douleur = rapport.getDouleur();
			Boolean ecrasement = rapport.getEcrasement();
			Boolean electrisation = rapport.getElectrisationElectrocution();
			Boolean intoxication = rapport.getIntoxication();
			Boolean piqure = rapport.getPiqure();
			Boolean plaie = rapport.getPlaieMorsure();
			Boolean corpsEtranger = rapport.getCorpsEtranger();
			String autreNaturePrecision= rapport.getAutreNatureLesionPrecision();
			String autreSiegePrecision= rapport.getAutreSiegeLesionPrecision();
			String lieuAccident = rapport.getLieuAccident();
			String actionVictime = rapport.getActionVictime();
			String causeAccident = rapport.getCauseAccident();
			String remarques = rapport.getRemarques();
			String actionImmediate = rapport.getActionimmediat();
			List<SiegeLesions> siegeValue = rapport.getSiegeLesions();
			List<SiegeLesions> listDesSieges = new ArrayList<SiegeLesions>();
			log.info("||| typeRapport == 1 - AVANT FINDBYID ||| ");
			Optional<User> victim = userRepository.findById(personneATID);
			Optional<User> hierarchique = userRepository.findById(hierarchiqueID);
			Optional<Departement> departement = departementRepository.findById(departementID);
			Optional<Statut> statut = statutRepository.findById(statutID);
			Optional<Contrat> contrat = contratRepository.findById(contratID);
			Optional<MoyenPrevenu> moyen = moyenRepository.findById(moyenID);
			Optional<Equipement> equipement = equipementRepository.findById(equipementID);
			log.info("||| typeRapport == 1 - AVANT BOUCLE FOR ||| ");
			for (SiegeLesions siegeLesions : siegeValue) {
				siegeLesions = siegeRepository.findById(siegeID).get();
				listDesSieges.add(siegeLesions);
			}
			log.info("||| typeRapport == 1 - APRES BOUCLE FOR ||| ");
			rapportTosave.setSiegeLesions(listDesSieges);
			log.info(listDesSieges.toString());

			if (victim.isPresent()) {
				rapportTosave.setPersonneAT(victim.get());
			}
			if (departement.isPresent()) {
				rapportTosave.setDepartement(departement.get());
			}
			if (statut.isPresent()) {
				rapportTosave.setStatut(statut.get());
			}
			if (contrat.isPresent()) {
				rapportTosave.setContrat(contrat.get());
			}
			if (moyen.isPresent()) {
				rapportTosave.setMoyen(moyen.get());
				rapportTosave.setPrevenuComment(moyen.get().getMoyen());
			}
			if (equipement.isPresent()) {
				rapportTosave.setEquipement(equipement.get());
			}
			if (hierarchique.isPresent()) {
				rapportTosave.setHierarchique(hierarchique.get());
			}
//		if (siege.isPresent())   {
//			rapport.setSiegeLesions(siege.get());
//		}

			rapportTosave.setDateDeCreation(new Date());
			rapportTosave.setUap(departement.get().getDepartement());
			rapportTosave.setRedacteur(user.get());
			rapportTosave.setTypeRapport(typeRapport.get());
			rapportTosave.setHierarchique(hierarchique.get());
			rapportTosave.setDateEtHeureConnaissanceAt(connaissanceAT);
			rapportTosave.setIsIntervention8300(is8300);
			rapportTosave.setIsInterventionInfirmiere(isInterventionInfirmiere);
			rapportTosave.setIsInterventionMedecin(isInterventionMedecin);
			rapportTosave.setIsInterventionsecouriste(isInterventionSecours);
			rapportTosave.setIsInterventionsecouristeExterieur(isInterventionSecoursExterieur);
			rapportTosave.setIsIntervention8300(is8300);
			rapportTosave.setIsIntervention8300(is8300);
			rapportTosave.setDateEtHeureMomentAccident(momentAccident);
			rapportTosave.setLieuAccident(lieuAccident);
			rapportTosave.setActionVictime(actionVictime);
			rapportTosave.setCauseAccident(causeAccident);
			rapportTosave.setMainGauche(mainGauche);
			rapportTosave.setMainDroite(mainDroite);
			rapportTosave.setTete(tete);
			rapportTosave.setCou(cou);
			rapportTosave.setOeil(oeil);
			rapportTosave.setEpaule(epaule);
			rapportTosave.setBras(bras);
			rapportTosave.setTorse(torse);
			rapportTosave.setCoude(coude);
			rapportTosave.setPoignet(poignet);
			rapportTosave.setJambe(jambe);
			rapportTosave.setGenou(genou);
			rapportTosave.setCheville(cheville);
			rapportTosave.setPied(pied);
			rapportTosave.setSiegesmultiples(siegeMultiple);
			rapportTosave.setColonne(colonne);
			rapportTosave.setAutreSiegeLesionPrecision(autreSiegePrecision);
			rapportTosave.setBrulureThermique(brulureThermique);
			rapportTosave.setBrulureChimique(brulureChimique);
			rapportTosave.setContusionHematome(contusion);
			rapportTosave.setDouleur(douleur);
			rapportTosave.setEcrasement(ecrasement);
			rapportTosave.setElectrisationElectrocution(electrisation);
			rapportTosave.setIntoxication(intoxication);
			rapportTosave.setPiqure(piqure);
			rapportTosave.setPlaieMorsure(plaie);
			rapportTosave.setCorpsEtranger(corpsEtranger);
			rapportTosave.setAutreNatureLesionPrecision(autreNaturePrecision);
			rapportTosave.setRemarques(remarques);
			rapportTosave.setActionimmediat(actionImmediate);
			rapportTosave.setIsRDP(isRDP);
			rapportTosave.setIsIdentifierDu(isDU);

			log.info("||| typeRapport == 1 ||| ");
		}
		
		if (rapportTypeID == 4) {
			log.info("||| typeRapport ==  ||| ");
			Long personneATID = rapport.getPersonneATID();
			Long hierarchiqueID = rapport.getHierarchiqueID();
			Long moyenID = rapport.getMoyenID();
			Long siegeID = rapport.getSiegeLesionsID();
			Date connaissanceAT = rapport.getDateEtHeureConnaissanceAt();
			Date momentAccident = rapport.getDateEtHeureMomentAccident();
			Boolean isTemoin = rapport.getIsTemoin();
			Boolean isTiersEncause = rapport.getIsTiersEnCause();
			Boolean autreVictime = rapport.getIsAutreVictime();
			Boolean rapportPolice = rapport.getIsRapportDePolice();
			Boolean victimeTransport = rapport.getIsVictimeTransports();
			Boolean mainGauche = rapport.getMainGauche();
			Boolean mainDroite = rapport.getMainDroite();
			Boolean tete = rapport.getTete();
			Boolean cou = rapport.getCou();
			Boolean oeil = rapport.getOeil();
			Boolean epaule = rapport.getEpaule();
			Boolean bras = rapport.getBras();
			Boolean torse = rapport.getTorse();
			Boolean coude = rapport.getCoude();
			Boolean poignet = rapport.getPoignet();
			Boolean jambe = rapport.getJambe();
			Boolean genou = rapport.getGenou();
			Boolean cheville = rapport.getCheville();
			Boolean pied = rapport.getPied();
			Boolean siegeMultiple = rapport.getSiegesmultiples();
			Boolean colonne = rapport.getColonne();
			Boolean brulureThermique = rapport.getBrulureThermique();
			Boolean brulureChimique = rapport.getBrulureChimique();
			Boolean contusion = rapport.getContusionHematome();
			Boolean douleur = rapport.getDouleur();
			Boolean ecrasement = rapport.getEcrasement();
			Boolean electrisation = rapport.getElectrisationElectrocution();
			Boolean intoxication = rapport.getIntoxication();
			Boolean piqure = rapport.getPiqure();
			Boolean plaie = rapport.getPlaieMorsure();
			Boolean corpsEtranger = rapport.getCorpsEtranger();
			String autreNaturePrecision= rapport.getAutreNatureLesionPrecision();
			String autreSiegePrecision= rapport.getAutreSiegeLesionPrecision();
			String telephone = rapport.getTelephone();
			String commentaireTemoin = rapport.getCommentaireTemoin();
			String comentaireTiersEnCause = rapport.getCommentaireTiersEnCause();
			String commentaireAutreVictime = rapport.getCommentaireAutreVictime();
			String commentaireRapportPolice = rapport.getCommentaireRapportDePolice();
			String commentaireVictimeTransport = rapport.getCommentaireVictimeTransporter();
			String lieuAccident = rapport.getLieuAccident();
			String actionVictime = rapport.getActionVictime();
			String causeAccident = rapport.getCauseAccident();
			String remarques = rapport.getRemarques();
			String actionImmediate = rapport.getActionimmediat();
			List<SiegeLesions> siegeValue = rapport.getSiegeLesions();
			List<SiegeLesions> listDesSieges = new ArrayList<SiegeLesions>();
			log.info("||| typeRapport == 1 - AVANT FINDBYID ||| ");
			Optional<User> victim = userRepository.findById(personneATID);
			Optional<User> hierarchique = userRepository.findById(hierarchiqueID);
			Optional<MoyenPrevenu> moyen = moyenRepository.findById(moyenID);
			log.info("||| typeRapport == 1 - AVANT BOUCLE FOR ||| ");
			for (SiegeLesions siegeLesions : siegeValue) {
				siegeLesions = siegeRepository.findById(siegeID).get();
				listDesSieges.add(siegeLesions);
			}
			log.info("||| typeRapport == 1 - APRES BOUCLE FOR ||| ");
			rapportTosave.setSiegeLesions(listDesSieges);
			log.info(listDesSieges.toString());

			if (victim.isPresent()) {
				rapportTosave.setPersonneAT(victim.get());
			}
			if (moyen.isPresent()) {
				rapportTosave.setMoyen(moyen.get());
				rapportTosave.setPrevenuComment(moyen.get().getMoyen());
			}
			if (hierarchique.isPresent()) {
				rapportTosave.setHierarchique(hierarchique.get());
			}
//		if (siege.isPresent())   {
//			rapport.setSiegeLesions(siege.get());
//		}

			rapportTosave.setDateDeCreation(new Date());
			rapportTosave.setRedacteur(user.get());
			rapportTosave.setTypeRapport(typeRapport.get());
			rapportTosave.setTelephone(telephone);
			rapportTosave.setHierarchique(hierarchique.get());
			rapportTosave.setDateEtHeureConnaissanceAt(connaissanceAT);
			rapportTosave.setDateEtHeureMomentAccident(momentAccident);
			rapportTosave.setIsTemoin(isTemoin);
			rapportTosave.setCommentaireTemoin(commentaireTemoin);
			rapportTosave.setIsTiersEnCause(isTiersEncause);
			rapportTosave.setCommentaireTiersEnCause(comentaireTiersEnCause);
			rapportTosave.setIsAutreVictime(autreVictime);
			rapportTosave.setCommentaireAutreVictime(commentaireAutreVictime);
			rapportTosave.setIsRapportDePolice(rapportPolice);
			rapportTosave.setCommentaireRapportDePolice(commentaireRapportPolice);
			rapportTosave.setIsVictimeTransports(victimeTransport);
			rapportTosave.setCommentaireVictimeTransporter(commentaireVictimeTransport);
			rapportTosave.setLieuAccident(lieuAccident);
			rapportTosave.setActionVictime(actionVictime);
			rapportTosave.setCauseAccident(causeAccident);
			rapportTosave.setMainGauche(mainGauche);
			rapportTosave.setMainDroite(mainDroite);
			rapportTosave.setTete(tete);
			rapportTosave.setCou(cou);
			rapportTosave.setOeil(oeil);
			rapportTosave.setEpaule(epaule);
			rapportTosave.setBras(bras);
			rapportTosave.setTorse(torse);
			rapportTosave.setCoude(coude);
			rapportTosave.setPoignet(poignet);
			rapportTosave.setJambe(jambe);
			rapportTosave.setGenou(genou);
			rapportTosave.setCheville(cheville);
			rapportTosave.setPied(pied);
			rapportTosave.setSiegesmultiples(siegeMultiple);
			rapportTosave.setColonne(colonne);
			rapportTosave.setAutreSiegeLesionPrecision(autreSiegePrecision);
			rapportTosave.setBrulureThermique(brulureThermique);
			rapportTosave.setBrulureChimique(brulureChimique);
			rapportTosave.setContusionHematome(contusion);
			rapportTosave.setDouleur(douleur);
			rapportTosave.setEcrasement(ecrasement);
			rapportTosave.setElectrisationElectrocution(electrisation);
			rapportTosave.setIntoxication(intoxication);
			rapportTosave.setPiqure(piqure);
			rapportTosave.setPlaieMorsure(plaie);
			rapportTosave.setCorpsEtranger(corpsEtranger);
			rapportTosave.setAutreNatureLesionPrecision(autreNaturePrecision);
			rapportTosave.setRemarques(remarques);
			rapportTosave.setActionimmediat(actionImmediate);

			log.info("||| typeRapport == 1 ||| ");
		}

		if (rapportTypeID == 2) {
			log.info("||| typeRapport == 2 ||| ");
			rapportTosave.setRedacteur(user.get());
			rapportTosave.setTypeRapport(typeRapport.get());
			rapportTosave.setDateDeCreation(new Date());
			rapportTosave.setLieuAccident(rapport.getLieuAccident());
			rapportTosave.setDateEtHeureMomentAccident(rapport.getDateEtHeureMomentAccident());
			rapportTosave.setDescriptionsituationdangereuse(rapport.getDescriptionsituationdangereuse());
			rapportTosave.setActionimmediat(rapport.getActionimmediat());
			rapportTosave.setPourquoi1(rapport.getPourquoi1());
			rapportTosave.setPourquoi2(rapport.getPourquoi2());
			rapportTosave.setPourquoi3(rapport.getPourquoi3());
			rapportTosave.setPourquoi4(rapport.getPourquoi4());
			rapportTosave.setPourquoi5(rapport.getPourquoi5());
			log.info("||| typeRapport == 2 ||| ");
		}

		if (rapportTypeID == 3) {
			log.info("||| typeRapport == 3 ||| ");
			Long categorieID = rapport.getCategorieID();
			Long typeID = rapport.getTypeID();
			log.info("||| getDescriptionsituationdangereuse() ||| ");
			log.info(rapport.getDescriptionsituationdangereuse());
			log.info("||| getDescriptionsituationdangereuse() ||| ");
			Optional<Categorie> categorie = categorieRepository.findById(categorieID);
			Optional<Type> type = typeRepository.findById(typeID);

//			rapportTosave.setCategorie(categorie.get());
			rapportTosave.setType(type.get());
			rapportTosave.setRedacteur(user.get());
			rapportTosave.setTypeRapport(typeRapport.get());
			rapportTosave.setDateDeCreation(new Date());
			rapportTosave.setDescriptionsituationdangereuse(rapport.getDescriptionsituationdangereuse());
//			log.info("||| typeRapport == 3 ||| " );
		}

		log.info("||| FINDBYID GET PERSONNE AT ID ||| ");
		rapportRepository.save(rapportTosave);
		log.info("||| SAUVEGARDE FAITES ||| ");
		return new ResponseEntity<Rapport>(rapportTosave, HttpStatus.OK);
	}
	
	
	// Permet de récuperer un objet rapports pour voir l'afficher
	@GetMapping("/{rapportId}")
	public ResponseEntity<Rapport> loadRapport(@PathVariable("rapportId") String rapportId) {
		Optional<Rapport> rapport = rapportRepository.findById(Long.valueOf(rapportId));
		Rapport rpt = rapportRepository.findByIdRapport(Long.valueOf(rapportId));
//		try {
//				ExtractAtInterne.ExtractATInterne(rpt);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new ResponseEntity<Rapport>(rapport.get(), HttpStatus.OK);
	}

}