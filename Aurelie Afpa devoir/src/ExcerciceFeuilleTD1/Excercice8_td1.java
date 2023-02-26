package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice8_td1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		System.out.println("Veuillez entrez un numéro de jour (de 1 à 31) :");
		Integer jour = saisie.nextInt();
		System.out.println("Veuillez entrez un numéro de mois (de 1 à 12) :");
		Integer mois = saisie.nextInt();
		System.out.println("Veuillez entrez un numéro d'année :");
		Integer annee = saisie.nextInt();
		
		Boolean bissextile = false;
		
		
		if(annee % 100 == 0 && annee %400 ==0) {
			bissextile = true;
		}
		else if(annee % 100 == 0 && annee %400 !=0) {
			bissextile = false;
		}
		else if(annee %4 == 0) {
			bissextile = true;
		}
		else {
			bissextile = false;
		}
		
		if(mois == 8) {
			if(jour < 1 || jour > 31) {
				System.out.println("Date Incorrecte.");
			}
			else {
				System.out.println("Date Correcte.");
			}
		}
		else if(mois == 2) {
			if(bissextile == true) {
				if(jour < 1 || jour > 29) {
					System.out.println("Date Incorrecte.");
				}
				else {
					System.out.println("Date Correcte.");
				}
			}
			else if(bissextile == false) {
				if(jour < 1 || jour >28) {
					System.out.println("Date Incorrecte.");
				}
				else {
					System.out.println("Date Correcte.");
				}
			}
		}
		else if(mois %2 == 0) {
			if(mois < 1 || mois > 12) {
				if(jour < 1 || jour > 30) {
					System.out.println("Date Incorrecte.");
				}
				else {
					System.out.println("Date Incorrecte.");
				}
			}
			else if(jour < 1 || jour > 30) {
				System.out.println("Date Incorrecte.");
			}
			else {
				System.out.println("Date Correcte.");
			}
		}
		else {
			if(mois < 1 || mois > 12) {
				if(jour < 1 || jour > 31) {
					System.out.println("Date Incorrecte.");
				}
				else {
					System.out.println("Date Incorrecte.");
				}
				
			}
			else if(jour < 1 || jour > 31) {
				System.out.println("Date Incorrecte.");
			}
			else {
				System.out.println("Date Correcte.");
			}
	}

}
}