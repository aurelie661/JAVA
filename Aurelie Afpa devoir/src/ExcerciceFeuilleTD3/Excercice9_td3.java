package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice9_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer taille;
		Integer nombre;
		// TAILLE ET SAISIE VALEUR TABLEAU
		System.out.println("Entrer la taille du tableau :");
		Scanner saisie = new Scanner(System.in);
		taille = saisie.nextInt();
		Integer[] tab = new Integer[taille];
		for (int i = 0; i < tab.length; i++) {
			System.out.println("entrer la valeur" + (i + 1) + " :");
			tab[i] = saisie.nextInt();
		}
		// VALEUR A AJOUTER
		System.out.println("entrer la valeurs à rajouter à votre tableau :");
		nombre = saisie.nextInt();
		Integer[] tab2 = new Integer[taille + 1];
		tab2[tab.length] = nombre;
		for (int i = 0; i < tab.length; i++) {
			tab2[i] = tab[i];
		}
		for (int i = 0; i < tab2.length; i++) {
			System.out.println(tab2[i]);
		}

	}

}
