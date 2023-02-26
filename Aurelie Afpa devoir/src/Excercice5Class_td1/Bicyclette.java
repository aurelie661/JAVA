package Excercice5Class_td1;

public class Bicyclette {

	private String couleur, orientation;
	private int nombreDeVitesse, vitesseActuelle, vitesseCourante;
	
	public Bicyclette(String couleur, String orientation, int nombreDeVitesse, int vitesseActuelle,
			int vitesseCourante) {
		super();
		this.couleur = couleur;
		this.orientation = orientation;
		this.nombreDeVitesse = nombreDeVitesse;
		this.vitesseActuelle = vitesseActuelle;
		this.vitesseCourante = vitesseCourante;
	}
	public void tourner(String orientation) {
		if(this.orientation.equals("doite") || this.orientation.equals("gauche") || this.orientation.equals("haut") || this.orientation.equals("bas")) {
			this.orientation = orientation;
		}
	}
	public void accelerer(int vitesseAjouter) {
		if(vitesseAjouter >= 0) {
			this.vitesseCourante = this.vitesseCourante+vitesseAjouter;
		}
	}
	public void freiner() {
		if(this.vitesseActuelle >=10) {
			this.vitesseActuelle = this.vitesseActuelle - 10;
		}
		else {
			this.vitesseActuelle = 0;
		}
	}
	
	public String toString() {
		return "Bicyclette [couleur=" + couleur + ", orientation=" + orientation + ", nombreDeVitesse="
				+ nombreDeVitesse + ", vitesseActuelle=" + vitesseActuelle + ", vitesseCourante=" + vitesseCourante
				+ "]";
	}
	public static void main(String[] args) {
		
	}
}