package ExcerciceFeuilleTD2;

import java.util.Scanner;

public class Excercice11_td2 {

	public static void main(String[] args) {
		//VARIABLE
				Integer chevauxPartant;
				Integer chevauxJoues;
				Integer f1 = 1;
				Integer p = 1;
				Integer j = 1;
				Integer x = 1;
				Integer y = 1;
				//SAISIE UTILISATEUR
				System.out.println("Chevaux partant :");
				Scanner saisie = new Scanner(System.in);
				chevauxPartant = saisie.nextInt();
				System.out.println("Chevaux joués :");
				chevauxJoues   = saisie.nextInt();
				//FACTORIELLE DES CHEVAUX PARTANT - CHEVAUX JOUES
				Integer p1 = chevauxPartant - chevauxJoues;
				for(int i = 1;i<=p1;i++) {
					f1=f1*i;
				}
				//FACTORIELLE DE CHEVAUX PARTANT ET JOUES
				for(int n1=1;n1<=chevauxPartant;n1++) {
					p=p*n1;
				}
				for(int n1=1;n1<=chevauxJoues;n1++) {
					j=j*n1;
				}
				//CALCULE DE CHANCE
				x=p/f1;
				y=p/(j*f1);
				//AFFICHER RESULTAT
				System.out.println("Dans l'ordre : 1 chance sur "+x+" de gagner.");
				System.out.println("Dans le désordre : 1 chance sur "+y+" de gagner.");

	}

}
