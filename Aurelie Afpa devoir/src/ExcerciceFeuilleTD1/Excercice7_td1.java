package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice7_td1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Je récupère les informations clients.
		System.out.println("Veuillez entrer votre age");
		Integer age = scanner.nextInt();

		System.out.println("Veuillez entrer depuis combien d'année êtes vous détenteur du permis de conduire");
		Integer anneePermis = scanner.nextInt();

		System.out.println("Veuillez entrer le nombre d'accidents pour lesquels vous avez été responsable (0 pour aucun)");
		Integer nombreAccident = scanner.nextInt();

		System.out.println("Veuillez entrer depuis combien d'années êtes vous client chez nous");
		Integer anciennete = scanner.nextInt();

		
		Integer categorie = 0;
		
		if ( age > 25 ) {
			categorie = categorie + 1;
		}
		
		if ( anneePermis >= 2 ) {
			categorie = categorie + 1;
		}
		
		if ( anciennete >= 5 ) {
			categorie = categorie + 1;
		}
		
		categorie = categorie - nombreAccident;
		
		if (categorie == 0) {
			System.out.println("Vous bénéficiez du tarif rouge.");
		}else if (categorie == 1) {
			System.out.println("Vous bénéficiez du tarif orange.");
		}else if (categorie == 2) {
			System.out.println("Vous bénéficiez du tarif vert. ");
		}else if ( categorie == 3 ){
			System.out.println("Vous bénéficiez du tarif bleu.");
		}else {
			System.out.println("Vous ne pouvez pas être assuré chez nous. Désolé.");

	}

}
}