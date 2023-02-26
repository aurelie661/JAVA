package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice9_td2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		Integer valeurMax = -1;
		Integer i = 1;
		Integer positionValeurMax = 0;
		Integer nombre = -1;
		
		System.out.println("Veuillez entrer des nombres en terminant par un 0 ");
		while(nombre != 0) {
			System.out.println("Veuillez entrer le nombre n°"+i+", 0 si vous avez fini :");
			nombre = saisie.nextInt();
			if( nombre > valeurMax ) {
				valeurMax = nombre;
				positionValeurMax = i;
			}
			i = i + 1;
		}
		System.out.println("Le nombre maximal entré est le nombre "+valeurMax+" à la position n°"+positionValeurMax);

	}

}
