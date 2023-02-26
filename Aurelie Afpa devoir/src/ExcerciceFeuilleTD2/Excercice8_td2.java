package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice8_td2 {

	public static void main(String[] args) {
		Integer entrer = 1;
		Integer nombreSaisie;
		Integer lePlusGrandNombre = 0;
		Integer position = null;
		// DEMANDER 20 NOMBRES
		for (int a = 1; a < 21; a++) {
			System.out.println("Entrez le nombre numéro " + entrer + " :");
			Scanner saisie = new Scanner(System.in);
			nombreSaisie = saisie.nextInt();
			System.out.println("nombre numéro " + entrer + " :" + nombreSaisie);
			entrer++;
			// LE NOMBRE SAISIE LE PLUS GRAND DEVIENT LE PLUS GRAND NOMBRE ET L'AFFICHE
			if (nombreSaisie > lePlusGrandNombre) {
				lePlusGrandNombre = nombreSaisie;
				
			}
		}
		System.out.println("Le plus grand de ces nombres est : " + lePlusGrandNombre);
		

	}

}
