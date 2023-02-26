package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice1_td2 {

	public static void main(String[] args) {
		String msg = "Nombre incorrecte ! Veuillez rentrer un nombre entre 1 et 3.";
		String msg2 = "Merci !";
		//DEMANDER UN NOMBRE ENTRE 1 ET 3
		System.out.println("Veuillez rentrer un nombre entre 1 et 3.");
		Scanner nombre = new Scanner(System.in);
		Integer nB = nombre.nextInt();
		
		//TANT QUE CE N'EST PAS LE BON NOMBRE/ REPETER
		do {
			System.out.println(msg);
			nB = nombre.nextInt();
		} while (nB < 1 || nB > 3);
		System.out.println(msg2);

	}

}
