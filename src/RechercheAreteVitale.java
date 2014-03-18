


public class RechercheAreteVitale {

	private int extr1;    // extrémité 1 de l'arête vitale trouvée
	private int extr2;    // extrémité 2
	private Dijkstra dijkstra;

	public RechercheAreteVitale (int n, Bordure bordure) {
		extr1 = -1;
		extr2 = -1;
		dijkstra = new Dijkstra(n, bordure);
	}

	public int getExtr1 () {
		return extr1;
	}

	public int getExtr2 () {
		return extr2;
	}



	public Arete executerRecherche (Graphe g, Sommet s, Sommet t) {
		int max = 0;
		int valeurDijkstraOrigine;
		Arete vitale = null;
		Arete[] TAC = new Arete[g.nbSommet-1];         // tableau des arêtes du plus court chemin
		int j = 0;
		int k = t.num;
		
		dijkstra.executerDijkstra(g, s);
		
		while (dijkstra.getPred(k) != -2) {
			int z = dijkstra.getPred(k);
			for(int i=0;i< g.TabSommet[k].Successeur.size();i++){
				
				if(g.TabSommet[k].Successeur.get(i).getS(k).num == z){
					TAC[j++] = g.TabSommet[k].Successeur.get(i);
				}
			}
			k = dijkstra.getPred(k);
		}

		max = dijkstra.coutChemin(t);    
		valeurDijkstraOrigine = max;

		for (int i = 0 ; i<j ; i++) {
			TAC[i].chemin=true;
			g.suppA(TAC[i]);
			dijkstra.executerDijkstra(g, s);
			if (dijkstra.coutChemin(t) > max || dijkstra.coutChemin(t) == -1) {
				if(dijkstra.coutChemin(t) == -1){
					max = Integer.MAX_VALUE;
				}else{
					max = dijkstra.coutChemin(t);
				}
				vitale = TAC[i];
			}
			g.addA(TAC[i]);
		}
		if (max == valeurDijkstraOrigine) {
			return null;
		} else {
			vitale.vital = true;
			return vitale;
		}

	}

}

