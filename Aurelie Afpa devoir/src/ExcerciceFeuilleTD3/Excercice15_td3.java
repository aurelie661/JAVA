package ExcerciceFeuilleTD3;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice15_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer taille, taille2, ordre;
		// TAILLE TABLEAU
		Scanner saisie = new Scanner(System.in);
		System.out.println("Entrer la taille du tableau 1:");
		taille = saisie.nextInt();
		Integer[] tab = new Integer[taille];
		System.out.println("Entrer la taille du tableau 2:");
		taille2 = saisie.nextInt();
		Integer[] tab2 = new Integer[taille2];
		Integer[] tab3 = new Integer[taille + taille2];

		// SAISIE VALEUR
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Veuillez entrer la valeur " + (i + 1) + " du premier tableau :");
			tab[i] = saisie.nextInt();
		}
		System.out.println("nombre d'élèment dans le tableau 1 :" + taille);

		for (int i = 0; i < tab2.length; i++) {
			System.out.println("Veuillez entrer la valeur " + (i + 1) + " du second tableau :");
			tab2[i] = saisie.nextInt();
		}
		System.out.println("nombre d'élèment dans le tableau 2 :" + taille2);
		System.out.println(Arrays.toString(tab));
		System.out.println(Arrays.toString(tab2));
		for (int i = 0; i < tab3.length; i++) {
			if (i < taille) {
				tab3[i] = tab[i];
			} else if (i >= taille) {
				tab3[i] = tab2[i - taille];
			}

		}
		System.out.println(Arrays.toString(tab3));

	}

}
