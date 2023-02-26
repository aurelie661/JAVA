package ExcerciceFeuilleTD4;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice13_td4 {
	static Integer taille;
	static int[] trierTableau(int t[]) {
		for (int i = 0; i < t.length; i++) {
			for (int j = i + 1; j < t.length; j++) {
				if (t[i] > t[j]) {
					int ordre = t[i];
					t[i] = t[j];
					t[j] = ordre;
				}
			}
		}
		return t;
	}
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		System.out.println("De quelle taille est votre tableau :");
		taille = saisie.nextInt();
		int[] tab= Excercice12_td4.creerTableauAleatoire(taille);
		int[] tab1 = trierTableau(tab);
		System.out.println(Arrays.toString(tab1));
		
	}
}