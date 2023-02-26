package ExcerciceFeuilleTD4;

public class Excercice7_td4 {
	/**
	 * 
	 * @param length
	 * @param width
	 * @return
	 */
	static double hypoténuse(double length,double width) {
		return Math.sqrt(width*width+length*length) ;
		
	}
	public static void main(String[] args) {
		System.out.println(hypoténuse(5, 6));

	}

}
