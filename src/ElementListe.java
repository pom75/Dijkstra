

public class ElementListe {

	private Sommet num;     // numéro du sommet
	private int dist;    // évaluation de ce sommet
	private ElementListe suiv;
	private ElementListe prec;
	
	public ElementListe (Sommet num, int dist) {
		this.num = num;
		this.dist = dist;
		suiv = null;
		prec = null;
	}
	
	public int getNum () {
		return num.num;
	}
	
	public Sommet getS () {
		return num;
	}
	
	public int getDist () {
		return dist;
	}
	
	public void setDist (int dist) {
		this.dist = dist;
	}
	
	public ElementListe getSuiv () {
		return suiv;
	}
	
	public void setSuiv (ElementListe suiv) {
		this.suiv = suiv;
	}
		
	public ElementListe getPrec () {
		return prec;
	}
	
	public void setPrec (ElementListe prec) {
		this.prec = prec;
	}
	
	public boolean estPremier () {
		return (prec == null);
	}
	
	public boolean estDernier () {
		return (suiv == null);
	}
	
}
