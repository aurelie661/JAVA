import java.util.Scanner;

public class Exercice7_bis {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);

		System.out.println("Quel �ge avez-vous ?");
		Integer age = saisie.nextInt();
		System.out.println("Depuis combien de temps avez-vous le permis ?");
		Integer anneeDePermis = saisie.nextInt();
		System.out.println("Combien d'accident avez-vous eu ?");
		Integer accident = saisie.nextInt();
		System.out.println("Depuis combien de temps �te-vous assurer chez nous ?");
		Integer anneeDAssurance = saisie.nextInt();
		
		String cat1 ="bleu";
		String cat2 = "vert";
		String cat3 = "orange";
		String cat4 = "rouge";
		String refus = "refus�";
		
		if(age < 25) {
			if(anneeDePermis <= 2 && accident ==0) {
				System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat4+".");
			}
			else if(anneeDePermis > 2 && accident ==0 && anneeDAssurance >= 5) {
				System.out.println("Bravo! vous passez d'un tarif "+cat3+" � un tarif "+cat2+".");
			}
			else if(anneeDePermis > 2 && accident ==0) {
				System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat3+".");
			}
			else if(anneeDePermis > 2 && accident == 1 && anneeDAssurance >=5) {
				System.out.println("Bravo! vous passez d'un tarif "+cat4+" � un tarif "+cat3+".");
			}
			else if(anneeDePermis > 2 && accident == 1) {
				System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat4+".");
			}
			else {
				System.out.println("Vous �tes "+refus+".");
			}
		}
		else{
			if(anneeDePermis <= 2 ) {
				if(accident == 0) {
					System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat3+".");
				}
				else if(accident == 1) {
					System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat4+".");
				}
				else {
					System.out.println("Vous �tes "+refus+".");
				}
			}
			else {
				if(anneeDePermis > 2) {
					if(accident == 0 && anneeDAssurance >=5) {
						System.out.println("Bravo! vous passez d'un tarif "+cat2+" � un tarif "+cat1+".");
					}
					else if(accident == 0) {
						System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat2+".");
					}
					else if(accident == 1 && anneeDAssurance >=5) {
						System.out.println("Bravo! vous passez d'un tarif "+cat3+" � un tarif "+cat2+".");
					}
					else if(accident == 1) {
						System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat3+".");
					}
					else if (accident == 2 && anneeDAssurance >=5) {
						System.out.println("Bravo! vous passez d'un tarif "+cat4+" � un tarif "+cat3+".");
					}
					else if (accident == 2) {
						System.out.println("Bienvenue, vous b�n�ficiez d'un tarif "+cat4+".");
					}
					else {
						System.out.println("Vous �tes "+refus+".");
					}
				}
			}
			
		}
		
		
	}
}
