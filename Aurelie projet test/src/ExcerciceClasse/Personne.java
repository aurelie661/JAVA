package ExcerciceClasse;

public class Personne {
	String nom , prenom;
	int age;
	
	public Personne(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Personne\n [nom = " + nom + " , prenom = " + prenom + " , age = " + age + "]";
	}

	public static void main(String...args) {
		
	}
}
