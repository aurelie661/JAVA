package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice10_td2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		// DECLARATION VARIABLE
		Integer achatClient = 1;
		Integer sommeAPayer = 0;
		Integer sommePayer = 0;
		Integer renduClient = 0;
		Integer billetDeDix = 0;
		Integer billetDeCinq = 0;
		Integer pieceDeUn = 0;
		// GERER ACHAT CLIENT
		for (int i = 1; achatClient != 0; i++) {
			System.out.println("Votre achat " + i + " :");
			achatClient = saisie.nextInt();
			sommeAPayer = sommeAPayer + achatClient;

		}
		System.out.println("Total de vos achats : " + sommeAPayer + " €");
		// LE CLIENT PAYE
		System.out.println("Quel somme donnez-vous ?");
		sommePayer = saisie.nextInt();
		// SYSTEME RENDU CLIENT
		renduClient = sommePayer - sommeAPayer;
		for (; renduClient >= 10;) {
			renduClient = renduClient - 10;
			billetDeDix += 1;
		}
		if (renduClient >= 5) {
			renduClient = renduClient - 5;
			billetDeCinq = 1;
			pieceDeUn += 1;
		}

		System.out.println("Voici votre monnaie : " + billetDeDix + " billet(s) de 10 € " + billetDeCinq
				+ " billet(s) de 5 € " + pieceDeUn + " pièce(s) de 1 €");

	}

}
