package ExcerciceFeuilleTD4;

public class Excercice2_td4 {
	static int maximum( int n1,int n2) {
		if(n1<n2) {
			return n2;
		}
		return n1;
		
		
	}
	public static void main(String[] args) {
		Integer resultat = maximum(45,99);
		System.out.println(resultat);
	}

}