package Excercice2Class_td1;

public class Cercle {
	double rayon;
	Point point;
	
	public static void main(String...args) {
		Cercle r = new Cercle();
		r.rayon = 2;
		Point p = new Point();
		p.abscisse =3;
		p.ordonnée = 2;
		r.point = p;
		
		System.out.println("Le cercle 'C' est de rayon : "+r.rayon);
		System.out.println("Le cercle 'C' est de centre : "+p.abscisse+", "+p.ordonnée);
	}
}