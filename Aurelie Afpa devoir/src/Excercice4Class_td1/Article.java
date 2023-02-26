package Excercice4Class_td1;

public class Article {
	private int noArticle;
	private String designation;
	private double prixHT,tauxTVA;
	

	double calculPrixTTC(double prixHT,double tauxTVA) {
		return prixHT+(prixHT*tauxTVA/100);
	}

	public Article(int noArticle, String designation, double prixHT, double tauxTVA) {
			super();
			this.noArticle = noArticle;
			this.designation = designation;
			this.prixHT = prixHT;
			this.tauxTVA = tauxTVA;
		}
	public double calculPrixTTC() {
		return prixHT+(prixHT*tauxTVA/100);
	}
	
	
	public String toString() {
		return "Article :\n\nnoArticle = " + noArticle + "\ndesignation = " + designation + "\nprixHT = " + prixHT + " �\ntauxTVA = "
				+ tauxTVA + " %";
	}
	public static void main(String[] args) {
		
		Article article = new Article(113, "parapluie", 9.90,20);
		Article article2 = new Article(114, "v�lo", 180,20);
		Article article3 = new Article(115, "maillot de bain", 11.90,20);
		Article article4 = new Article(116, "basket", 39.90,20);
		Article article5 = new Article(117, "raquette", 9.90,20);
		Article article6 = new Article(118, "casquette", 25.90,20);
		
		System.out.println(article2+"\n");
		System.err.println("Prix de l'article apr�s calcule de la tva : "+article2.calculPrixTTC()+" �");
	}	
	
}	


	