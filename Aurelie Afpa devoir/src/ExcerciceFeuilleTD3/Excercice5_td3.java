package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice5_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer[] tab = new Integer[7];
		Integer position = 0;
		Integer nB2 = 0;
		Integer occurence = 0;
		// SCANNER BOUCLE FOR
		System.out.println("Veuillez entrer 7 valeurs :");
		for (int i = 0; i < tab.length; i++) {
			Scanner saisie = new Scanner(System.in);
			tab[i] = saisie.nextInt();

		}
		System.out.println("De quelle valeur voulez vous vérifiez l'occurence :");
		Scanner saisie = new Scanner(System.in);
		nB2 = saisie.nextInt();
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == nB2) {
				occurence += 1;
				System.out.println("a l' index n° " + i);
			}
		}
		System.out.println("Il y as " + occurence + " occurence(s) dans ce tableau avec le n° " + nB2);

	}

}
