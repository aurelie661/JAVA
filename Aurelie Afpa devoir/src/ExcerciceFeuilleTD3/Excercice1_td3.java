package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice1_td3 {

	public static void main(String[] args) {
		// VARIABLE
		double nB;
		double somme = 0;
		// DEMANDER LA SAISIE DE 5 NOMBRES
		double[] monTableau = new double[5];
		Scanner saisie = new Scanner(System.in);
		System.out.println("Veuillez saisir 5 nombres réels :");
		// CREATION TABLEAU
		for (int i = 0; i <= 4; i++) {
			nB = saisie.nextDouble();
			monTableau[i] = nB;
			somme = somme + nB;
		}
		System.out.println(somme);
	}

}
