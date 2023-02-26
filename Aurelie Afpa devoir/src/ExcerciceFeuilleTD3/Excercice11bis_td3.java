package ExcerciceFeuilleTD3;

import java.util.ArrayList;
import java.util.Scanner;

public class Excercice11bis_td3 {

	public static void main(String[] args) {
		// VARIABLE
		Integer taille;
		Integer nombre;
		Integer index;
		// TAILLE TABLEAU
		System.out.println("Entrer la taille du tableau :");
		Scanner saisie = new Scanner(System.in);
		taille = saisie.nextInt();
		ArrayList<Integer> tab = new ArrayList<Integer>();
		// VALEUR TABLEAU
		System.out.println("Entrez les valeurs du tableau :");
		for (int i = 0; i < taille; i++) {
			tab.add(saisie.nextInt());
		}
		System.out.println(tab);
		System.out.println("entrer la valeurs à rajouter à votre tableau :");
		nombre = saisie.nextInt();
		System.out.println("A Quel index ? :");
		index = saisie.nextInt();
		tab.add(index, nombre);

		System.out.println(tab);

	}

}
