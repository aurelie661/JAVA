package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice4_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer[] tab = new Integer[10];
		Integer nombre = null, position;
		// SCANNER BOUCLE FOR
		Scanner saisie = new Scanner(System.in);
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Veuillez entrer valeur " + (i + 1) + " :");
			nombre = saisie.nextInt();
			tab[i] = nombre;
		}
		// SCANNER BOUCLE WHILE ELEMENT A CONSULTER
		System.out.println("Quel est l'indice de l'élément à consulter ?");
		position = saisie.nextInt();
		while (position < 1 || position > 10) {
			System.out.println("position hors limite du tableau !");
			System.out.println("Quel est l'indice de l'élément à consulter ?");
			Scanner saisie2 = new Scanner(System.in);
			position = saisie2.nextInt();
		}
		System.out.println("Voici l'élément souhaitez : " + tab[position]);

	}

}
