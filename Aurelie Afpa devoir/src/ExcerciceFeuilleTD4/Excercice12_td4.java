package ExcerciceFeuilleTD4;

import java.util.Arrays;
import java.util.Scanner;

public class Excercice12_td4 {
	static int[] creerTableauAleatoire(int n) {
		int[] tab = new int[n];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int)(Math.random()*100)+1;
		}
		return tab;
	}
	static Integer taille;
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		System.out.println("De quelle taille est votre tableau :");
		taille = saisie.nextInt();
		
		int[] tab = creerTableauAleatoire(taille);
		System.out.println(Arrays.toString(tab));	
		}
		
	}
