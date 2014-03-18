

public class Liste {

	private ElementListe premier;
	private int nbElem;   // nombre d'éléments dans la liste
	
	public Liste () {
		premier = null;
		nbElem = 0;
	}
	
	/* insertion en tête */
	public void inserer (ElementListe e) {
		if( premier == null){
			e.setPrec(null);
			e.setSuiv(null);
			premier= e;
			nbElem++;
		}else{
		e.setPrec(null);
		e.setSuiv(premier);
		premier.setPrec(e);
		premier = e;
		nbElem++;
		}
	}
	
	public boolean estVide () {
		return (nbElem == 0);
	}
	
	// sert quand on supprime dans la Structure3 ou 4
	public void decrementeNbElem () {
		nbElem--;
	}
	
	/* on ne peut retirer que le premier élément */
	public void retirer () {
		premier.getSuiv().setPrec(null);
		premier = premier.getSuiv();
		nbElem--;
	}
	
	/* retire le premier et rend le numéro du sommet retiré */
	public int retirerAvecNum () {
		int res = premier.getNum();
		if(nbElem > 1){
			premier.getSuiv().setPrec(null);
			premier = premier.getSuiv();
		}else{
			premier = premier.getSuiv();
		}
		nbElem--;
		return res;
	}
	
}
	