package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice2_td2 {

	public static void main(String[] args) {
		//DEMANDER NOMBRE ENTRE 10 ET 20
				System.out.println("Veuillez entrer un nombre entre 10 et 20 :");
				Scanner nombre = new Scanner(System.in);
				Integer nB = nombre.nextInt();

				String msg1 = "Plus petit !";
				String msg2 = "Plus grand !";
				String msg3 = "Parfait!";
				//TANT QUE CE N'EST PAS ENTRE 10 ET 20 /REPETER
				while (nB < 10 || nB > 20) {
					if (nB > 20) {
						System.out.println(msg1);
						System.out.println("Erreur: Veuillez entrer un nombre entre 10 et 20 :");
						nB = nombre.nextInt();
					} else if (nB < 10) {
						System.out.println(msg2);
						System.out.println("Erreur: Veuillez entrer un nombre entre 10 et 20 :");
						nB = nombre.nextInt();
					}

				}
				System.out.println(msg3);

	}

}
