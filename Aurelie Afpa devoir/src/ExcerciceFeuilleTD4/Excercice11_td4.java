package ExcerciceFeuilleTD4;

public class Excercice11_td4 {
static int lancerDe6() {
		
		return (int)(Math.random()*6) +1;
	}
	public static void main(String[] args) {
		for (int i = 0; i <10; i++) {
			System.out.println(lancerDe6());
		}
		

	}

}
