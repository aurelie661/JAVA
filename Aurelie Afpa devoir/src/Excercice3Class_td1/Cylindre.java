package Excercice3Class_td1;

public class Cylindre {
	private double dimension;
	
	
	public Cylindre(double dimension) {
		super();
		this.dimension = dimension;
	}


	public double getDimension() {
		return dimension;
	}


	public void setDimension(double dimension) {
		this.dimension = dimension;
	}


	@Override
	public String toString() {
		return "Cylindre [dimension = " + dimension + "]";
	}


	public static void main(String...args) {
		
		
	}
}