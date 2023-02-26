package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice5_td2 {

	public static void main(String[] args) {
		//DEMANDER NOMBRE
				System.out.println("Veuillez entrer un nombre :");
				Scanner nombre = new Scanner(System.in);
				Integer nB = nombre.nextInt();
				//AFFICHE LA TABLE DE MULTIPLICATION DU NOMBRE TAPER
				System.out.println("Table de " + nB + " :\n ");

				for (int nB2 = 1; nB2 <=10; nB2++) {
					Integer resultat = nB2 * nB;
					System.out.println(nB2 + "x" + nB + " = " + resultat);
				}

	}

}
