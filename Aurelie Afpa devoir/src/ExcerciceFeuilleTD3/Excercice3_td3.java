package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice3_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer[] array1 = new Integer[5];
		Integer nB = 0;
		Integer somme = 0;
		Integer produit = 1;
		Integer moyenne = 0;

		// SAISIE
		Scanner saisie = new Scanner(System.in);
		System.out.println("Entrez 5 nombres :");
		for (int i = 0; i < array1.length; i++) {
			nB = saisie.nextInt();
			array1[i] = nB;
			somme = somme + array1[i];
			produit = produit * array1[i];
			moyenne = somme / 5;
		}
		System.out.println("Le calcul des sommes du tableau est de : " + somme);
		System.out.println("Le produit des nombres du tableau est de : " + produit);
		System.out.println("La moyenne des nombres du tableau est de : " + moyenne);

	}

}
