package ExcerciceClasse;

import java.util.Arrays;

public class Voiture {
	String marque , couleur;
	Moteur moteur;
	Roue[] roue;
	Personne proprietaire;  
	
	public Voiture(String marque, String couleur, Moteur moteur, Roue[] roue, Personne proprietaire) {
		super();
		this.marque = marque;
		this.couleur = couleur;
		this.moteur = moteur;
		this.roue = roue;
		this.proprietaire = proprietaire;
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public Roue[] getRoue() {
		return roue;
	}

	public void setRoue(Roue[] roue) {
		this.roue = roue;
	}

	public Personne getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "Voiture\n [marque = " + marque + " , couleur = " + couleur + " , moteur = " + moteur + " , roue = "
				+ Arrays.toString(roue) + " , proprietaire = " + proprietaire + "]";
	}

	public static void main(String...args) {
		
	}
}
