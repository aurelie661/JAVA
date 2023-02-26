package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice8_td3 {

	public static void main(String[] args) {
		int occurence = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer la taille du tableau :");

		Integer nombre = scanner.nextInt();
		int[] tab = new int[nombre];
		int[] tabTraite = new int[nombre];
		int positionTraite = 0;

		for (int i = 0; i < nombre; i++) {
			System.out.println("Case n°" + (i + 1));
			tab[i] = scanner.nextInt();
		}

		/* Je cherche pour chaque élément du tableau tab : */
		for (int i = 0; i < nombre; i++) {

			boolean dejaTraite = false;
			for (int j = 0; j < nombre; j++) {
				if (tab[i] == tabTraite[j]) {
					dejaTraite = true;
				}
			}

			if (dejaTraite == false) {

				/* On remet le compteur à 0 */
				occurence = 0;
				/*
				 * Pour l'élément actuel, chercher combien de fois il est présent dans le
				 * tableau tab :
				 */

				for (int j = 0; j < nombre; j++) {
					/* est-ce que le nombre que je cherche est dans cette case */
					if (tab[i] == tab[j]) {
						occurence = occurence + 1;
					}
				}

				System.out.println(tab[i] + " est présent " + occurence + " fois.");
				tabTraite[positionTraite] = tab[i];
				positionTraite = positionTraite + 1;
			}
		}

	}
}