package ExcerciceFeuilleTD3;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice11_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer taille;
		Integer nombre;
		Integer position;
		Integer index;
		// TAILLE TABLEAU
		System.out.println("Entrer la taille du tableau :");
		Scanner saisie = new Scanner(System.in);
		taille = saisie.nextInt();
		Integer[] tab = new Integer[taille];
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Veuillez entrer la valeur :" + (i + 1));
			tab[i] = saisie.nextInt();
		}
		System.out.println("Quel élèment voulez vous rajouter à ce tableau :");
		nombre = saisie.nextInt();
		System.out.println("A quel index :");
		index = saisie.nextInt();
		Integer[] tab2 = new Integer[taille + 1];
		for (int i = 0; i < tab2.length; i++) {
			if (i < index) {
				tab2[i] = tab[i];
			} else if (i == index) {
				tab2[i] = nombre;
			} else {
				tab2[i] = tab[i - 1];
			}
			System.out.println(tab2[i]);

		}

	}
}