package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice5_td1 {

	public static void main(String[] args) {
		System.out.println("Vous �tes : h / f");
		Scanner saisie = new Scanner(System.in);
		String sexe    = saisie.next();
		System.out.println("Quel �ge avez vous ?");
		Integer age     = saisie.nextInt();
		if( sexe.equals("f") && age >= 18 && age <=35){
			System.out.println("Vous �tes imposable");
		}
		else if( sexe.equals("h") && age >= 20){
			System.out.println("Vous �tes imposable");
		}
		else {
			System.out.println("Vous n'�tes pas imposable");

	}

}
}