

public class Structure3 extends Structure3_4 {

	
	
	public void initialiser(int n, int C) {
		
		paquets = new Liste[n*C+1];
		sommets = new ElementListe[n];
		
		for (int i = 0 ; i<(n*C)+1 ; i++) {
			paquets[i] = new Liste();
		}
		
		for (int i = 0 ; i<n ; i++) { 
			sommets[i] = null;
		}
	}

	
	public boolean estVide() {
		for (int i = 0 ; i<sommets.length ; i++) {
			if (sommets[i] != null) {
				return false;
			}
		}
		return true;
	}

	
	public void ajouter(Sommet s) {
		ElementListe elem = new ElementListe(s, s.distance);
		sommets[s.num] = elem;
		paquets[s.distance].inserer(elem);	
	}

}
