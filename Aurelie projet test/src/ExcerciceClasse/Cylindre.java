package ExcerciceClasse;

public class Cylindre {
	double dimension;
	
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
		return "Cylindre\n [dimension = " + dimension + "]";
	}

	public static void main(String...args) {
		
	}
}
