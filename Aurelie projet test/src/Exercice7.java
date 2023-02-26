import java.util.Scanner;

public class Exercice7 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		
		System.out.println(" Quel âge avez-vous ?");
		Integer age = saisie.nextInt();
		System.out.println(" Depuis combien de temps avez-vous le permis ?");
		Integer anneeDePermis = saisie.nextInt();
		System.out.println(" Depuis combien de temps êtes vous assurer chez nous ?");
		Integer anneeDassurance = saisie.nextInt();
		System.out.println(" Combien d'accident avez-vous eu ?");
		Integer accident = saisie.nextInt();
		
		String message = null;
		
		if(age < 25 && anneeDePermis <=2 && accident ==0) {
			message ="Bienvenue, vous bénéficiez d'un tarif ROUGE.";
		}
		else if(age > 25 && anneeDePermis <= 2 && accident ==1) {
			message ="Bienvenue, vous bénéficiez d'un tarif ROUGE.";
		}
		else if(age > 25 && anneeDePermis > 2 && accident ==2 && anneeDassurance >=5) {
			message ="Bravo vous passer d'un tarif ROUGE au tarif ORANGE.";
		}
		else if(age > 25 && anneeDePermis > 2 && accident ==2) {
			message ="Bienvenue, vous bénéficiez d'un tarif ROUGE.";
		}
		else if(age > 25 && anneeDePermis <= 2 && accident ==0) {
			message ="Bienvenue, vous bénéficiez d'un tarif ORANGE.";
		}
		else if(age < 25 && anneeDePermis > 2 && accident ==0 && anneeDassurance >=5) {
			message ="Bravo vous passer d'un tarif ORANGE au tarif VERT.";
		}
		else if(age < 25 && anneeDePermis > 2 && accident ==0) {
			message ="Bienvenue, vous bénéficiez d'un tarif ORANGE.";
		}
		else if(age > 25 && anneeDePermis > 2 && accident ==1 && anneeDassurance >=5 ) {
			message ="Bravo vous passer d'un tarif ORANGE au tarif VERT.";
		}
		else if(age > 25 && anneeDePermis > 2 && accident ==1) {
			message ="Bienvenue, vous bénéficiez d'un tarif ORANGE.";
		}
		else if(age > 25 && anneeDePermis > 2 && accident ==0 && anneeDassurance >=5) {
			message ="Bravo vous passer d'un tarif VERT au tarif BLEU.";
		}
		else if(age > 25 && anneeDePermis > 2 && accident ==0) {
			message ="Bienvenue, vous bénéficiez d'un tarif VERT.";
		}
		else {
			message ="Désolé, nous sommes dans l'imposibilité de vous assurer.";
		}
		System.out.println(message);
	}

}
