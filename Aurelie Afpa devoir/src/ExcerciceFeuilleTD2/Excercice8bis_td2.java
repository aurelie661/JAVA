package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice8bis_td2 {

	public static void main(String[] args) {
		Integer nombreSaisie = 1;
		Integer lePlusGrandNombre = 0;
		Integer position = null;
		//DEMANDER NOMBRE ET S'ARRETERA QUAND L'UTILISATEUR TAPE ZERO
		for (int a = 1; nombreSaisie != 0; a++) {
			System.out.println("Entrez le nombre numéro " + a + " :");
			Scanner saisie = new Scanner(System.in);
			nombreSaisie = saisie.nextInt();
			//NOMBRE SAISIE DEVIENT LE PLUS GRAND ET LAFFICHE AVEC SA POSITION
			if (nombreSaisie > lePlusGrandNombre) {
				lePlusGrandNombre = nombreSaisie;
				position = a;
			}
		}
		System.out.println("Le plus grand de ces nombres est : " + lePlusGrandNombre);
		System.out.println("C'étais le nombre numéro : " + position);


	}

}
