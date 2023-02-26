package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice2_td1 {

	public static void main(String[] args) {
		
			Scanner saisie = new Scanner(System.in);
			
			System.out.println("Veuillez renseigner l'heure actuelles :");
			Integer heure =  saisie.nextInt();
			
			System.out.println("Veuillez renseigner les minutes actuelles :");
			Integer minute =  saisie.nextInt();
			
			System.out.println("Veuillez renseigner les secondes actuelles :");
			Integer seconde =  saisie.nextInt();
			
			if( heure == 23 && minute == 59 && seconde == 59) {
				heure = 0;
				minute = 0;
				seconde = 0;
			}
			else if(minute == 59 && seconde == 59) {
				heure += 1;
				minute = 0;
				seconde = 0;
			}
			else {
				seconde += 1;
			}
			System.out.println("Dans une seconde il sera "+heure+"heure(s) "+minute+"minute(s) "+seconde+"seconde(s).");

	}

}
