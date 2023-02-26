package Excercice3Class_td1;

public class Pneu {
	private String marque;
	private double pression;

	public Pneu(String marque, double pression) {
		super();
		this.marque = marque;
		this.pression = pression;
	}

	public String getMarque() {
		return marque;
	}

	public double getPression() {
		return pression;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setPression(double pression) {
		this.pression = pression;
	}

	@Override
	public String toString() {
		return "Pneu [marque = " + marque + ", pression = " + pression + "]";
	}

	public static void main(String... args) {

	}
}