package ExcerciceClasse;

public class Programme {

	public static void main(String[]  args) {
		Cylindre[] cylindres=new Cylindre[6];
		for (int i = 0; i < 6 ; i++) {
			cylindres[i] = new Cylindre(2.0);
			
		}
		Roue[] roue = new Roue[4];
		Pneu[] pneu = new Pneu[4];
		for (int i = 0; i < roue.length; i++) {
			pneu[i] = new Pneu("Michelin", 2.8);
			roue[i] = new Roue(20, pneu[i]); 	
		}
		Moteur moteur = new Moteur(cylindres , 1000);
		Personne p = new Personne("Bout", "Aurélie", 37);
		Voiture v = new Voiture("Mercedes", "Rouge", moteur, roue, p);
		System.out.println("Voiture\n\nMarque : "+v.marque+"\nCouleur : "+v.couleur+
				"\n"+moteur.cylindres.length+" Cylindres\n"+v.moteur+"\nPuissance : "+v.moteur.puissance+" chv\n"
				+roue.length+" Roue de dimension : "+roue[0].dimension+" Pouces\n" +pneu.length+" Pneu de marque : "+roue[0].pneu.marque+
				"\nPresion des Pneus : "+roue[0].pneu.pression+" bar\nProprietaire : "+p.nom+" "+p.prenom+"\nAge : "+p.age+" ans");
		
		
	}
}
