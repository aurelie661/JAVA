package Excercice3Class_td1;

import java.util.Arrays;

public class Moteur {
	private Cylindre[] cylindres;
	private int puissance;
	
	
	public Moteur(Cylindre[] cylindres, int puissance) {
		super();
		this.cylindres = cylindres;
		this.puissance = puissance;
	}


	public Cylindre[] getCylindres() {
		return cylindres;
	}


	public int getPuissance() {
		return puissance;
	}


	public void setCylindres(Cylindre[] cylindres) {
		this.cylindres = cylindres;
	}


	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}


	@Override
	public String toString() {
		return "Moteur " + Arrays.toString(cylindres) + "\npuissance = " + puissance+" Chv";
	}


	public static void main(String[] args) {
		
}
}
