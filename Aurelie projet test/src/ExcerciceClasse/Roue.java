package ExcerciceClasse;

public class Roue {
	double dimension;
	Pneu pneu;
	
	public Roue(double dimension, Pneu pneu) {
		super();
		this.dimension = dimension;
		this.pneu = pneu;
	}

	public double getDimension() {
		return dimension;
	}

	public void setDimension(double dimension) {
		this.dimension = dimension;
	}

	public Pneu getPneu() {
		return pneu;
	}

	public void setPneu(Pneu pneu) {
		this.pneu = pneu;
	}

	@Override
	public String toString() {
		return "Roue\n [dimension = " + dimension + " , pneu = " + pneu + "]";
	}

	public static void main(String...args) {
		
	}
}
