package fr.delpharm.esacp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import fr.delpharm.esacp.domain.Action;
import fr.delpharm.esacp.domain.Categorie;
import fr.delpharm.esacp.domain.Contrat;
import fr.delpharm.esacp.domain.CorrectPrevent;
import fr.delpharm.esacp.domain.Criticite;
import fr.delpharm.esacp.domain.Csp;
import fr.delpharm.esacp.domain.Departement;
import fr.delpharm.esacp.domain.Equipement;
import fr.delpharm.esacp.domain.EtapeValidation;
import fr.delpharm.esacp.domain.NatureAccident;
import fr.delpharm.esacp.domain.OrigineLesions;
import fr.delpharm.esacp.domain.Priorite;
import fr.delpharm.esacp.domain.Rapport;
import fr.delpharm.esacp.domain.Repartition;
import fr.delpharm.esacp.domain.Role;
import fr.delpharm.esacp.domain.Sexe;
import fr.delpharm.esacp.domain.SiegeLesions;
import fr.delpharm.esacp.domain.Site;
import fr.delpharm.esacp.domain.Statut;
import fr.delpharm.esacp.domain.Type;
import fr.delpharm.esacp.domain.TypeAction;
import fr.delpharm.esacp.domain.TypeAt;
import fr.delpharm.esacp.domain.TypeRapport;
import fr.delpharm.esacp.domain.User;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	StopWatch clock = new StopWatch(getClass().getName());

	@Pointcut("execution(* fr.delpharm.esacp.service.*Service.*(..))")
	public void pointcut1() {
	}

	@Before("pointcut1()")
	public void advicebefore() {
		log.info("*** BEFORE ***");
	}

	@After("pointcut1()")
	public void adviceAfter(JoinPoint jeanpaul) {
		log.info("*** AFTER ***");
		log.info("Nom de la méthode executé => " + jeanpaul);
		for (Object arg : jeanpaul.getArgs()) {
			log.info("Valeur de l'Argument => " + arg);
		}
		log.info("*** AFTER ***");
	}

	@AfterReturning(value = "pointcut1() ", returning = "result")
	public void adviceAfterReturning(JoinPoint jeanpaul, Object result) {
		log.info("*** AFTER-RETURNING ***");
		if (result instanceof Action) {
			log.info("=> Action RETURNING = " + ((Action) result));
		}
		if (result instanceof Categorie) {
			log.info("=> Categorie RETURNING = " + ((Categorie) result));
		}
		if (result instanceof Contrat) {
			log.info("=> Contrat RETURNING = " + ((Contrat) result));
		}
		if (result instanceof CorrectPrevent) {
			log.info("=> CorrectPrevent RETURNING = " + ((CorrectPrevent) result));
		}
		if (result instanceof Criticite) {
			log.info("=> Criticite RETURNING = " + ((Criticite) result));
		}
		if (result instanceof Csp) {
			log.info("=> Csp RETURNING = " + ((Csp) result));
		}
		if (result instanceof Departement) {
			log.info("=> Departement RETURNING = " + ((Departement) result));
		}
		if (result instanceof Equipement) {
			log.info("=> Equipement RETURNING = " + ((Equipement) result));
		}
		if (result instanceof EtapeValidation) {
			log.info("=> EtapeValidation RETURNING = " + ((EtapeValidation) result));
		}
		if (result instanceof NatureAccident) {
			log.info("=> NatureAccident RETURNING = " + ((NatureAccident) result));
		}
		if (result instanceof OrigineLesions) {
			log.info("=> OrigineLesions RETURNING = " + ((OrigineLesions) result).toString());
		}
		if (result instanceof Priorite) {
			log.info("=> Priorite RETURNING = " + ((Priorite) result).toString());
		}
		if (result instanceof Rapport) {
			log.info("=> Rapport RETURNING = " + ((Rapport) result));
		}
		if (result instanceof Repartition) {
			log.info("=> Repartition RETURNING = " + ((Repartition) result).toString());
		}
		if (result instanceof Role) {
			log.info("=> Role RETURNING = " + ((Role) result).toString());
		}
		if (result instanceof Sexe) {
			log.info("=> Sexe RETURNING = " + ((Sexe) result).toString());
		}
		if (result instanceof SiegeLesions) {
			log.info("=> SiegeLesions RETURNING = " + ((SiegeLesions) result).toString());
		}
		if (result instanceof Repartition) {
			log.info("=> Repartition RETURNING = " + ((Repartition) result).toString());
		}
		if (result instanceof Role) {
			log.info("=> Role RETURNING = " + ((Role) result).toString());
		}
		if (result instanceof Sexe) {
			log.info("=> Sexe RETURNING = " + ((Sexe) result).toString());
		}
		if (result instanceof Site) {
			log.info("=> Site RETURNING = " + ((Site) result).toString());
		}
		if (result instanceof Statut) {
			log.info("=> Statut RETURNING = " + ((Statut) result).toString());
		}
		if (result instanceof Type) {
			log.info("=> Type RETURNING = " + ((Type) result).toString());
		}
		if (result instanceof TypeAction) {
			log.info("=> TypeAction RETURNING = " + ((TypeAction) result).toString());
		}
		if (result instanceof TypeAt) {
			log.info("=> TypeAt RETURNING = " + ((TypeAt) result).toString());
		}
		if (result instanceof TypeRapport) {
			log.info("=> TypeRapport RETURNING = " + ((TypeRapport) result).toString());
		}
		if (result instanceof User) {
			log.info("=> User RETURNING = " + ((User) result).toString());
		}
		log.info("*** AFTER-RETURNING ***");
	}

	@Around(value = "pointcut1() ")
	public Object adviceAfterAround(ProceedingJoinPoint jeanpaul) throws Throwable {
		log.info("*** AROUND ***");
		log.info("--------- START ---------" + jeanpaul.getSignature().getName());
		Object result = jeanpaul.proceed();
		log.info("--------- EXIT ----------" + jeanpaul.getSignature().getName());
		return result;
	}

}