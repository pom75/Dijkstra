import java.io.IOException;


public class Main {


	public static void main(String[] args) throws IOException {
		Graphe g = new Graphe("non");

		//Initialisation
		g.lireFichier("rl1889_900_20_7.gph");
		RechercheAreteVitale r = new RechercheAreteVitale(g.nbSommet, new Listetrie());// Structure4(g.nbSommet,g.C) Structure3(g.nbSommet,g.C) Heap() Listetrie()   

		
		//Temps exécution
	    long begin = System.currentTimeMillis();
	    r.executerRecherche(g, g.TabSommet[g.s], g.TabSommet[g.t]);
	    long end = System.currentTimeMillis();
	    float time = ((float) (end-begin)) / 1000f;
		System.out.println(time); 
		
		//Ecriture du fichier
		//g.ecrirFichier("rl1889_900_20_7.ps",  g);
		

	}

}
