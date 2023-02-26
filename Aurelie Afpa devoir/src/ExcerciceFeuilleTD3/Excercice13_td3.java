package ExcerciceFeuilleTD3;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice13_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer taille, ordre;
		// TAILLE TABLEAU
		System.out.println("Entrer la taille du tableau :");
		Scanner saisie = new Scanner(System.in);
		taille = saisie.nextInt();
		Integer[] tab = new Integer[taille];
		// SAISIE VALEUR
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Veuillez entrer la valeur " + (i + 1) + " :");
			tab[i] = saisie.nextInt();
		}
		System.out.println(Arrays.toString(tab));
		for (int i = 0; i < tab.length; i++) {
			for (int j = i + 1; j < tab.length; j++) {
				if (tab[i] > tab[j]) {
					ordre = tab[i];
					tab[i] = tab[j];
					tab[j] = ordre;
				}
			}
		}
		System.out.println(Arrays.toString(tab));

	}

}
