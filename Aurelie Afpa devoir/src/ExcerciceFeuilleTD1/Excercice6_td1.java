package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice6_td1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		
		System.out.println("Scores de Mr Durand :");
		double scoreCandidat1 = saisie.nextDouble();
		
		System.out.println("Scores de Mr Dufour :");
		double scoreCandidat2 = saisie.nextDouble();
		
		System.out.println("Scores de Mme Leroux :");
		double scoreCandidat3 = saisie.nextDouble();
		
		System.out.println("Scores de Mme Leclerd :");
		double scoreCandidat4 = saisie.nextDouble();
		String message = null;
		if(scoreCandidat1 < 50) {
			if(scoreCandidat1 < 12.5) {
				message = " Vous avez �t� battu !";
			}
			else if(scoreCandidat1 > scoreCandidat2 && scoreCandidat1 > scoreCandidat3 && scoreCandidat1 > scoreCandidat4){
				 message = "Vous �tes en ballotage favorable pour le 2�me tour.";
				}
			else{
				message = "Vous �tes en ballotage d�favorable pour le 2�me tour.";
				}
			}
		    else {
			   message = "Bravo Mr Durand, vous �tes �lue au 1er tour.";
		}
		System.out.println(message);

	}

}
