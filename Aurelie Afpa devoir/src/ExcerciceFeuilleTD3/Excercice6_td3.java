package ExcerciceFeuilleTD3;

import java.util.Scanner;

public class Excercice6_td3 {

	public static void main(String[] args) {
		Integer[] tab = new Integer[7];
		Integer nB2 = 0;
		Integer occurence=0;
		//SCANNER BOUCLE FOR
		System.out.println("Veuillez entrer 7 valeurs :");
		for (int i = 0; i < tab.length; i++) {
			Scanner saisie = new Scanner(System.in);
			tab[i] = saisie.nextInt();
			nB2 =tab[0];
			if(nB2 == tab[i]) {
				occurence+=1;
			}
		}
		System.out.println("Il y as "+occurence+" occurence(s) dans ce tableau avec l'index 0");

	}

}
