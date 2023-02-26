package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice6_td2 {

	public static void main(String[] args) {
		//DEMANDER NOMBRE
				System.out.println("Veuillez entrer un nombre :");
				Scanner nombre = new Scanner(System.in);
				Integer nB = nombre.nextInt();
				Integer somme=0;
				//CALCULE LA SOMME DES NOMBRES ENTIER JUSQU'AU NOMBRE TAPER/AFFICHE LE RESULTAT
				for(int nB2 = 0 ; nB2 <= nB ;nB2++) {
					somme = somme + nB2;
					
				}
				System.out.println(somme);

	}

}
