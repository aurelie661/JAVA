package ExcerciceClasse;

public class Pneu {
	String marque;
	double pression;
	
	public Pneu(String marque, double pression) {
		super();
		this.marque = marque;
		this.pression = pression;
	}

	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPression() {
		return pression;
	}

	public void setPression(double pression) {
		this.pression = pression;
	}
	@Override
	public String toString() {
		return "Pneu\n [marque = " + marque + " , pression = " + pression + "]";
	} 
	public static void main(String...args) {
		
}
}