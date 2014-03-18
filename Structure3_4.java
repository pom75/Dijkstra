

public abstract class Structure3_4 extends Bordure {

	protected Liste [] paquets;          // tableau des paquets (P dans le sujet)
	protected ElementListe [] sommets;   // tableau des références aux sommets 
	
	
	public abstract void initialiser(int n, int C);
	
	public abstract boolean estVide();
	
	public abstract void ajouter(Sommet x);
	
	
	public Sommet recupMin() {
		int i;
		int num;
		
		for (i = 0 ; i<paquets.length ; i++) {
			if (!paquets[i].estVide()) {
				num = paquets[i].retirerAvecNum();
				Sommet s = sommets[num].getS();
				sommets[num] = null;
				return s;
			}
		} return null;
		
		
	}
	
	
	public void supprimer(Sommet s) {
		 ElementListe elem = sommets[s.num];
		
		if (elem.estPremier()) {
			paquets[elem.getDist()].retirer();    // retire le premier élément
		} else {
			if (elem.estDernier()) {
				elem.getPrec().setSuiv(null);
				paquets[s.num].decrementeNbElem();
			} else {
				elem.getPrec().setSuiv(elem.getSuiv());
				elem.getSuiv().setPrec(elem.getPrec());
				paquets[s.num].decrementeNbElem();
			}
		}
		sommets[s.num] = null;
	}
	
	
	// rend le paquet numéro i
	public Liste getPaquet (int i) {
		return paquets[i];
	}
	
}
