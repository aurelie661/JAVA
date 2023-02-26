package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice5_td1 {

	public static void main(String[] args) {
		System.out.println("Vous êtes : h / f");
		Scanner saisie = new Scanner(System.in);
		String sexe    = saisie.next();
		System.out.println("Quel âge avez vous ?");
		Integer age     = saisie.nextInt();
		if( sexe.equals("f") && age >= 18 && age <=35){
			System.out.println("Vous êtes imposable");
		}
		else if( sexe.equals("h") && age >= 20){
			System.out.println("Vous êtes imposable");
		}
		else {
			System.out.println("Vous n'êtes pas imposable");

	}

}
}