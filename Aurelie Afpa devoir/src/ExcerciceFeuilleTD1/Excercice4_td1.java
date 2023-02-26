package ExcerciceFeuilleTD1;

import java.util.Scanner;

public class Excercice4_td1 {

	public static void main(String[] args) {
		System.out.println("Bonjour, combien de photocopie voulez-vous effectuer ?");
		Scanner saisie = new Scanner(System.in);
	    Integer nbCopie   = saisie.nextInt();
	    double prix;
	    if( nbCopie <= 10) {
	    	prix = nbCopie * 0.10;
	    }
	    else if(nbCopie > 10 && nbCopie <= 30) {
	    	prix = 1+(nbCopie - 10) * 0.09;
	    }
	    else {
	    	prix = 2.80+(nbCopie - 30 ) * 0.08;
	    }
	    if(prix < 1) {
	    	System.out.println("Pour "+nbCopie+" photocopie(s)"+","+" le prix sera de "+prix+" centimes.");
	    }
	    else {
	    	System.out.println("Pour "+nbCopie+" photocopie(s)"+","+" le prix sera de "+prix+" Euros.");

	}

}
}