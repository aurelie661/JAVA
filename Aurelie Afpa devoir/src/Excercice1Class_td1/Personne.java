package Excercice1Class_td1;


	public class Personne {
		private String nom,prenom;
		private int age;
		
		public Personne(String n , String p, int a){
			nom = n;
			prenom =p;
			age = a;
		}
		public void setAge(int a) {
			age = a;
		}
		public void setNom(String n) {
			nom = n;
		}
		public void setPrenom(String p) {
			prenom = p;
		}
		public String getNom(){
			return nom;
		}
		public String getPrenom(){
			return prenom;
		}
		public int getAge(){
			return age;
		}
		
		
		@Override
		public String toString() {
			return "Personne [nom = " + nom + " , prenom=" + prenom + " , age = " + age + "]";
		}
		public static void main(String[] args) {
			Personne p = new Personne("toto","arthur",30);
			
			
			System.out.println("La personne s'appelle "+p.nom+" "+p.prenom+" il est ag� de "+p.age+" ans.");
			
		}	
	}
