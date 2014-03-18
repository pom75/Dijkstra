import java.util.LinkedList;
import java.util.List;


public class Listetrie extends Bordure {

	public List<Sommet> ListeA ;
	
	public Listetrie(){
		initialiser(1, 0);
	}

	@Override
	public void ajouter(Sommet s) {
		for(int i =0;i<ListeA.size();i++){
			if( ListeA.get(i).distance > s.distance ){
			ListeA.add(i, s);
			return;
			}
		}
		ListeA.add(s);
		
	}

	@Override
	public void supprimer(Sommet s) {
		
		for(int i =0;i<ListeA.size();i++){
			if( ListeA.get(i).num == s.num ){
			ListeA.remove(i);
			return;
			}
		}
	}

	@Override
	public boolean estVide() {
		
		return ListeA.isEmpty();
	}

	@Override
	public Sommet recupMin() {
		Sommet s = ListeA.get(0);
		ListeA.remove(0);
		return s;
		
	}

	@Override
	public void initialiser(int n, int C) {
		ListeA  = new LinkedList<Sommet>();
		
	}

}
