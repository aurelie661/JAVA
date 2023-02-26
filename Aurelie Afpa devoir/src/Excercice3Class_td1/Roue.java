package Excercice3Class_td1;

public class Roue {
	private double dimension;
	private Pneu pneu;
	
	
	public Roue(double dimension, Pneu pneu) {
		super();
		this.dimension = dimension;
		this.pneu = pneu;
	}


	public double getDimension() {
		return dimension;
	}


	public Pneu getPneu() {
		return pneu;
	}


	public void setDimension(double dimension) {
		this.dimension = dimension;
	}


	public void setPneu(Pneu pneu) {
		this.pneu = pneu;
	}


	
	public String toString() {
		return "Roue dimension = " + dimension + " Pouces / pneu " + pneu + "";
	}


	public static void main(String...args) {
		
		
	}
}