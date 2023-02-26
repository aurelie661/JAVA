import java.util.Scanner;

public class AurelieProjetTest {

	public static void main(String... args){
		Integer entrer = 1;
		Integer nombreSaisie;
		Integer lePlusGrandNombre = 0;
		
		
		
		for(int a = 1; a < 21 ; a++) {
			
			System.out.println("Entrer le nombre "+entrer+" :");
			Scanner saisie = new Scanner(System.in);
			nombreSaisie = saisie.nextInt();
			System.out.println("nombre "+entrer+" : "+nombreSaisie);
			entrer++;
			
			if(nombreSaisie > lePlusGrandNombre) {
				lePlusGrandNombre = nombreSaisie;
				
			
			}
			
			
		}
		System.out.println("Le plus grand de ces nombres est : "+lePlusGrandNombre);	
		
		
		
		
		
}
}