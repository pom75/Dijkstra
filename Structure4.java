
public class Structure4 extends Structure3_4 {

	private int C;                     // coût max d'une arête
	
	
	public void initialiser(int n, int C) {
		paquets = new Liste[C+1];
		sommets = new ElementListe[n];
		this.C = C;
		
		for (int i = 0 ; i<C+1 ; i++) {
			paquets[i] = new Liste();
		}
		
		for (int i = 0 ; i<n ; i++) {
			sommets[i] = null;
		}
		
	}

	
	public boolean estVide() {
		if (paquets.length < sommets.length) {
			for (int i = 0 ; i<paquets.length ; i++) {
				if (!paquets[i].estVide()) {
					return false;
				}
			}
			return true;
		} else {
			for (int i = 0 ; i<sommets.length ; i++) {
				if (sommets[i] != null) {
					return false;
				}
			}
			return true;
		}
	}

	
	public void ajouter(Sommet s) {
		ElementListe elem = new ElementListe(s, s.distance);
		paquets[(s.distance)%(C+1)].inserer(elem);
		sommets[s.num] = elem;
	}

}