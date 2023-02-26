package ExcerciceFeuilleTD3;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice12_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer position = 0, taille;
		// TAILLE TAB & VALEURS
		Scanner saisie = new Scanner(System.in);
		System.out.println("Informer la taille de votre tableau :");
		taille = saisie.nextInt();
		Integer[] tab = new Integer[taille];
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Veuillez entrer la valeur " + (i + 1) + " :");
			tab[i] = saisie.nextInt();
		}
		System.out.println("A quelle position du tableau voulez vous supprimer un élèment ?");
		position = saisie.nextInt();
		Integer[] tab2 = new Integer[taille - 1];
		for (int i = 0, k = 0; i < tab.length; i++) {
			if (i == position) {
				continue;
			}
			tab2[k++] = tab[i];
		}
		System.out.println(Arrays.toString(tab2));

	}

}
