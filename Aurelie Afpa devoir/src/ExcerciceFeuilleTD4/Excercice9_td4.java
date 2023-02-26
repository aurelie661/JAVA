package ExcerciceFeuilleTD4;

public class Excercice9_td4 {
	static Boolean bissestile(int annee) {
		if(annee%4 == 0 && annee%100 != 0) {
			return true;
		}
		else if(annee%400 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(bissestile(2000));
	}

}