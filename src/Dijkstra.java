import java.util.List;


public class Dijkstra {

	public int [] pred;
	private int [] d;
	private Bordure bordure;
	
	// n représente le nombre de sommets dans le graphe
	public Dijkstra (int n, Bordure bordure) {
		pred = new int[n];
		d = new int[n];
		this.bordure = bordure;
	}
	
	public int getPred (int i) {
		return pred[i];
	}
	
	
	// rend le coût du chemin de s à t (il avoir exécuter dijkstra avant)
	public int coutChemin (Sommet t) {
		return d[t.num];
	}
	
	// r représente le numéro du sommet d'origine
	public void executerDijkstra (Graphe g, Sommet r) {
		int k;
		Sommet x;
		int i = 0;   // variable pour la structure 3
		Sommet y;   // variable temporaire
		
		List<Arete> liste;
		
		for (k = 0 ; k<g.nbSommet ; k++) {
			pred[k] = -1;
			d[k] = -1;       // nécessaire pour pouvoir appeler plusieurs fois cette méthode
		}
		
		bordure.initialiser(g.nbSommet, g.C);
		bordure.ajouter(r);
		d[r.num] = 0;
		pred[r.num] = -2;
		
		while (!bordure.estVide()) {
			x = bordure.recupMin();
			liste = x.Successeur;
			for (int j = 0 ; j<liste.size() ; j++) {
				y = liste.get(j).getS(x.num);
				if (pred[y.num] == -1) {
					d[y.num] = d[x.num] + liste.get(j).c;
					pred[y.num] = x.num;
					y.distance = d[y.num];
					bordure.ajouter(y);
				} else {
					if (d[y.num] > d[x.num] + liste.get(j).c) {
						d[y.num] = d[x.num] + liste.get(j).c;
						pred[y.num] = x.num;
						y.distance = d[y.num];
					}
				}
			}
			
			if (bordure instanceof Structure3_4) {
				if (((Structure3_4)bordure).getPaquet(x.num).estVide()) {
					i = d[x.num] + 1;
				} else {
					i = d[x.num];
				}
			}
		}
	
	}
}

