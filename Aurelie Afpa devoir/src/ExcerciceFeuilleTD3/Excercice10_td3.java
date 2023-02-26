package ExcerciceFeuilleTD3;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice10_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer taille, nombre, index;
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
		System.out.println("Quel élément voulez vous modifier ? :");
		index = saisie.nextInt();
		System.out.println("Vous voulez modifier l'élèment n°:" + index);
		System.out.println("Par quelle valeur voulez vous le modifier ? :");
		nombre = saisie.nextInt();
		System.out.println("Vous voulez modifier l'élèment n°:" + index + " par la valeur : " + nombre);
		tab[index - 1] = nombre;
		System.out.println(Arrays.toString(tab));

	}

}
