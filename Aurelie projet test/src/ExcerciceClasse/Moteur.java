package ExcerciceClasse;

import java.util.Arrays;

public class Moteur {
	Cylindre[] cylindres;
	int puissance;
	
	public Moteur(Cylindre[] cylindres, int puissance) {
		super();
		this.cylindres = cylindres;
		this.puissance = puissance;
	}

	public Cylindre[] getCylindres() {
		return cylindres;
	}

	public void setCylindres(Cylindre[] cylindres) {
		this.cylindres = cylindres;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Moteur\n [cylindres = " + Arrays.toString(cylindres) + " , puissance = " + puissance + "]";
	}

	public static void main(String...args) {
		
	}
}
