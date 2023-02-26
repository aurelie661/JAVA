package Excercice3Class_td1;

import Excercice1Class_td1.Personne;

public class Voiture {
	private String marque,couleur;
	private Moteur moteur;
	private Roue[] roue;
	private Personne proprietaire;
	
	
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


	public String getCouleur() {
		return couleur;
	}


	public Moteur getMoteur() {
		return moteur;
	}


	public Roue[] getRoue() {
		return roue;
	}


	public Personne getProprietaire() {
		return proprietaire;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}


	public void setRoue(Roue[] roue) {
		this.roue = roue;
	}


	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String toString() {
		return ("voiture class A\n\nmarque : "+this.marque+"\ncouleur : "+this.couleur+
				"\nmotoristion : "+this.moteur.getPuissance()+"chv\n"+"nombre de cylindre : "+moteur.getCylindres().length+" Cylindres  "+" \n"
				+this.roue.length+" roues de dimension : "+roue[0].getDimension()+" pouces / pression : "+roue[0].getPneu().getPression()+" barre / de marque : "+roue[0].getPneu().getMarque()+
				"\nproprietaire : "+this.proprietaire.getNom()+" "+
				this.proprietaire.getPrenom()+" ag�e de "+this.proprietaire.getAge()+" ans ");
	}
	
}
